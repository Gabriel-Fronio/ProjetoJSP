<%@page import="java.sql.Date"%>
<%@page import="DAO.*"%>
<%@page import="DBO.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de ingressos</title>
    </head>
    <body>
        <h1>Escolha o setor:</h1>
        <form method="POST" action="escolhaIngressos.jsp">
            <input list="setores" name="setor">
                <%
                    String evento = request.getParameter("evento");
                    ArrayList<DBOSetor> setores = DAOSetor.getSetorEvento(DAOEvento.getIdEvento(new DBOEvento(evento, Date.valueOf(session.getAttribute("data").toString()))));
                    session.setAttribute("evento", evento);
                    if(setores != null)
                    {
                        out.println("<datalist id='setores'>");
                        for(DBOSetor s : setores)
                            out.println("<option value='"+s.getNomeSetor() +"'>Ingressos disponíveis:"+s.getQtdIngressos()+"</option>");
                        out.println("</datalist><br>");
                        out.println("<input type='submit' value='Continuar'>");
                    }
                    else
                        out.println("<br><h2 style='color:red'>Não há setores para o evento selecionado</h2><br>");
                    %>
        </form>
    </body>
</html>
