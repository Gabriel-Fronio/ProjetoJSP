<%@page import="DAO.DAOIngresso"%>
<%@page import="DBO.DBOIngresso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de ingressos</title>
    </head>
    <body>
        <h1>Finalizando compra</h1>
        <form method="POST" action="Pagamento.jsp">
        <%
            int codSetor = Integer.parseInt(session.getAttribute("codSetor").toString());
            ArrayList<DBOIngresso> ingressos =  DAOIngresso.getIngressoSetor(codSetor);
            float valorTotal=0.0f;
            for(int i=0; i<ingressos.size(); i++)
            {
                session.setAttribute("ing"+i, request.getParameter("ing"+i));
                valorTotal += Integer.parseInt(request.getParameter("ing"+i))*ingressos.get(i).getPreco();
            }
            if(valorTotal != 0.0f)
            {
                session.setAttribute("valor", valorTotal);
                out.println("<h2>Total da compra: R$"+valorTotal);
                %>
                <h3> Métodos de pagamento:</h3><br>
                <input type="radio" name="metodo" value="dinheiro" checked>Dinheiro<br>
                <input type="radio" name="metodo" value="cartao">Cartao<br>
                <input type="submit" value="Pagar">
                <%
            }
            else
            {
                response.sendRedirect("/escolhaIngressos.jsp");
                response.getWriter().println("<h2 style='color:red'> Selecione pelo menos um ingresso antes de prosseguir</h2>");
            }
                
        %>
        </form>
    </body>
</html>
