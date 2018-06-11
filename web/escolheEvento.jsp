<%@page import="DBO.DBOEvento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="DAO.DAOEvento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de ingressos</title>
    </head>
    <body>
        <h1>Escolha o evento:</h1>
        <form method="POST" action="escolhaSetor.jsp">
            <input list="eventos" name="evento">
            <datalist id="eventos">
                <% 
                    String data = request.getParameter("dataEvento").toString();
                    session.setAttribute("data", data);
                    ArrayList<DBOEvento> evts = DAOEvento.getEventoPorData(Date.valueOf(data));
                    for(DBOEvento e : evts)
                        out.println("<option>"+e.getNome()+"</option>");
                %>
            </datalist>
            <input type="submit" value="Continuar">
        </form>
    </body>
</html>
