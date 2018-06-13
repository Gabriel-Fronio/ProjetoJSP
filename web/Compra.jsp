<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
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
                <%
                    ArrayList<Date> datas = DAOEvento.getAllDatas();
                    if(datas != null)
                    {
                        out.println("<select name='dataEvento'>");
                        for(Date d : datas)
                            if(d.after(Date.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))))
                                out.println("<option value='"+d.toString()+"'>"+d.toString()+"</option>");
                        out.println("</select><br>");
                        out.println("<input type='submit' value='Ir'>");
                    }
                    else
                        out.println("<br><h2 style='color:red'>Não há datas de eventos disponíveis</h2><br>");
                %>
        </form>
    </body>
</html>
