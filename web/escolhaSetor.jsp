<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de ingressos</title>
    </head>
    <body>
        <h1>Escolha o setor:</h1>
        <form>
            <input data="setores" name="setor">
            <datalist id="setores">
                <%
                    String evento = request.getParameter("evento");
                    ArrayList<DBOSetor> setores = DAOSetor.getSetorEvento(DAOEvento.getIdEvento(new DBOEvento(evento, session.getAttribute("data"))));
                    session.setAttribute("evento", evento);
                    for(DBOSetor s : setores)
                        out.println("<option>"+s.getNome()+"</option>");
                    %>
            </datalist>
            <input type="submit" value="Continuar">
        </form>
    </body>
</html>
