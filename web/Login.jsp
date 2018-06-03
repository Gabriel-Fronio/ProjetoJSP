<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="Login" style="border: 2px solid black">
            E-mail:<input type="email" id="email">
            <br>
            Senha: <input type="password" id="senha">
            <br>
            <input type="submit" value="Logar">
        </form>
        <br>
         Ainda não tem conta? Crie uma <a href="Cadastro.jsp">aqui</a>
    </body>
</html>
