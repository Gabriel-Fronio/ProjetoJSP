<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="DBO.DBOEvento"%>
<%@page import="DAO.DAOEvento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de ingressos</title>
    </head>
    <body>
        <h1>Escolha a data do evento:</h1>
        <form method="POST" action="escolheEvento.jsp">
            <h2>Escolha a data do evento:</h2>
            <datalist id="dataEvento" name="dataEvento">
                <%
                    List<Date> datas = DAOEvento.getAllDatas();
                    for(Date d : datas)
                        if(d.after(Date.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))))
                            out.println("<option>"+d.toString()+"</option>");
                %>
            </datalist>
            <input type="submit" value="Ir">
        </form>
    </body>
</html>
