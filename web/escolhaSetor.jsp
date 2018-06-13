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
                <%
                    String evento = request.getParameter("evento");
                    ArrayList<DBOSetor> setores = DAOSetor.getSetorEvento(DAOEvento.getIdEvento(new DBOEvento(evento, Date.valueOf(session.getAttribute("data").toString()))));
                    session.setAttribute("evento", evento);
                    if(setores != null)
                    {
                        out.println("<select name='setor'>");
                        for(DBOSetor s : setores)
                            if(s.getQtdIngressos()>0)
                                out.println("<option value='"+ s.getNomeSetor() +"'>"+s.getNomeSetor()+" - "+s.getQtdIngressos()+" ingressos disponíveis</option>");
                            else
                                out.println("<option value='"+ s.getNomeSetor() +"' disabled>"+s.getNomeSetor()+" - esgotado </option>");
                        out.println("</select><br>");
                        out.println("<input type='submit' value='Continuar'>");
                    }
                    else
                        out.println("<br><h2 style='color:red'>Não há setores para o evento selecionado</h2><br>");
                    %>
        </form>
    </body>
</html>
