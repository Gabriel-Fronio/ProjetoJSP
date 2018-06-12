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
        <form>
            <%
                //PEGAR O ID DO SETOR APENAS COM O NOME(n sei como n)
                //DAOSetor.getIdSetor(new DBOSetor())
                String setor = request.getParameter("setor");
                int codSetor = Integer.parseInt(setor);
                session.setAttribute("codSetor", codSetor);
                ArrayList<DBOIngresso> ingressos =  DAOIngresso.getIngressoSetor(codSetor);
                if(ingressos != null)
                {
                    out.println("<input list='ingressos' name='categoria'>");
                    out.println("<datalist id='ingressos'>");
                    for(DBOIngresso i : ingressos)
                        out.println("<option>"+i.getCategoria()+"</option>");
                    out.println("</datalist><br>");
                }
                else
                    out.println("<h2 style='color:red'>Nao ha ingressos nessa sessao</h2>");
            %>
        </form>
        
        <!-- 
            LEMBRA DE FAZER A CONFIRMACAO DE COMPRA DE INGRESSOS AQUI
            VERIFICACAO DE LOGIN AQ TB
            (NUM INFRAME, DIV, SLA)
        -->
    </body>
</html>