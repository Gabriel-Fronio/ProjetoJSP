<%@page import="DAO.DAOUsuarioIngresso"%>
<%@page import="DBO.DBOUsuarioIngresso"%>
<%@page import="DAO.DAOIngresso"%>
<%@page import="DBO.DBOIngresso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de Ingressos</title>
    </head>
    <body>
        <%
                int codSetor = Integer.parseInt(session.getAttribute("codSetor").toString());
                ArrayList<DBOIngresso> ingressos =  DAOIngresso.getIngressoSetor(codSetor);
                for(int i=0; i<ingressos.size(); i++)
                {
                    int qtd = Integer.parseInt(session.getAttribute("ing"+i).toString());
                    for(int j=0; j<qtd; j++)
                        DAOUsuarioIngresso.insert(new DBOUsuarioIngresso(session.getAttribute("login").toString(), DAOIngresso.getId(ingressos.get(i))));
                }
            
            %>
            <h1>Sua compra foi concluida com sucesso! Total: R$<% out.print(session.getAttribute("valor")); %></h1><br>
        <a href="index.html">Voltar</a> 
    </body>
</html>
