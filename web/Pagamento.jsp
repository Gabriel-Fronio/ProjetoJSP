<%@page import="DAO.DAOIngresso"%>
<%@page import="DBO.DBOIngresso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBO.DBOUsuarioIngresso"%>
<%@page import="DAO.DAOUsuarioIngresso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagamento</title>
    </head>
    <body>
        <%
            if(request.getParameter("metodo").toString().equals("dinheiro"))
            {
                int codSetor = Integer.parseInt(session.getAttribute("codSetor").toString());
                ArrayList<DBOIngresso> ingressos =  DAOIngresso.getIngressoSetor(codSetor);
                for(int i=0; i<ingressos.size(); i++)
                {
                    int qtd = Integer.parseInt(session.getAttribute("ing"+i).toString());
                    for(int j=0; j<qtd; j++)
                        DAOUsuarioIngresso.insert(new DBOUsuarioIngresso(session.getAttribute("login").toString(), DAOIngresso.getId(ingressos.get(i))));
                }
            
            %>
        <h1>Compra concluída! Total:R$<% out.print(session.getAttribute("valor")); %>
        </h1><br>
        <a href="index.html">Voltar</a> 
        <%
            }
            else{
                    %>
                    <form action="Conclusao.jsp" method="POST">
                    Numero do cartao:<input type="number" name="numCartao" required="true"><br>
                    Validade:<input type="number" name="valCartao" pattern="[0-1]{1}[0-9]{1}/[1-3]{1}[0-9]{1}" required="true"><br>
                    Código de segurança:<input type="number" name="codCartao" pattern="[0-9]{3}" required="true"><br>
                    <input type="submit" value="Pagar">
                    </form>
            <%
                    }
            
            %>
    </body>
</html>
