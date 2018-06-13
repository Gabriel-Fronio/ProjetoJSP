<%@page import="java.sql.Date"%>
<%@page import="DBO.DBOSetor"%>
<%@page import="DAO.DAOEvento"%>
<%@page import="DBO.DBOEvento"%>
<%@page import="DAO.DAOSetor"%>
<%@page import="DBO.DBOIngresso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOIngresso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de Ingressos</title>
    </head>
    <body>
        <h1>Escolha a quantidade e o tipo de ingresso:</h1>
        <form method="POST" action="fim.jsp">
            <%
                String setor = request.getParameter("setor");
                
                int idEvt = DAOEvento.getIdEvento(new DBOEvento(session.getAttribute("evento").toString()
                                            , Date.valueOf(session.getAttribute("data").toString())));
                int codSetor = DAOSetor.getIdSetor(new DBOSetor(idEvt, 0, setor));
                DBOSetor setorEscolhido = DAOSetor.getSetor(codSetor);
                session.setAttribute("codSetor", codSetor);
                
                if(session.getAttribute("login") == null)
                    out.println("<h2 style='color:red'><a href='Login.jsp' style='color:red'>Logue</a> antes de prosseguir na compra</h2>");
                else{
                
                    ArrayList<DBOIngresso> ingressos =  DAOIngresso.getIngressoSetor(codSetor);
                    if(ingressos != null)
                    {
                        int j=0;
                        out.println("Quantidade de ingressos:");
                        for(DBOIngresso i : ingressos)
                        {
                            out.println("<div id='categoriaIngresso' style='border:2px solid black; width:70%; align-self: center'>");
                            out.println(i.getCategoria()+"  -  R$"+i.getPreco()+"<br>");
                            
                            
                            int max = 20;
                            if(setorEscolhido.getQtdIngressos()<20*ingressos.size())
                                max = setorEscolhido.getQtdIngressos()/ingressos.size();
                            out.println("<input type='number' max='"+max+"' min='0' name='ing"+j+"'>");
                            out.println("</div><br>");
                            j++;
                        }
                        %>

                <input type="submit" value="Comprar">

                        <%
                    }
                    else
                        out.println("<h2 style='color:red'>Nao ha ingressos nessa sessao</h2>");
                }
            %>
        </form>
    </body>
</html>