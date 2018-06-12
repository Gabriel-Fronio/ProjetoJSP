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
                <% 
                    String data = request.getParameter("dataEvento").toString();
                    session.setAttribute("data", data);
                    ArrayList<DBOEvento> evts = DAOEvento.getEventoPorData(Date.valueOf(data));
                    if(evts != null)
                    {
                        out.println("<datalist id='eventos'>");
                        for(DBOEvento e : evts)
                            out.println("<option>"+e.getNome()+"</option>");
                        out.println("</datalist><br>");
                        out.println("<input type='submit' value='Continuar'>");
                    }     
                    else
                        out.println("<br><h2 style='color:red'>Não há eventos na data selecionada</h2><br>");
                %>
        </form>
    </body>
</html>
