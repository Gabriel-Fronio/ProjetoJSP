<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Cadastro</title>
    </head>
    <body>
        <h1>Cadastre-se</h1>
        <form method="POST" action="Cadastro">
            E-mail:<input type="email" name="email" id="email" maxlength="100"><br>
            Senha:<input type="password" name="senha" id="senha" maxlength="32"><br>
            <hr>
            <br>
            Nome:<input type="text" name="nome" id="nome" maxlength="40">
            Sobrenome:<input type="text" name="sobrenome" id="sobrenome" maxlength="160"><br>
            CPF:<input type="text" name="cpf" id="cpf" maxlength="11"><br>
            Sexo:<br>
            <input type="radio" name="sexo" id="sexo" value="M">Masculino<br>
            <input type="radio" name="sexo" id="sexo" value="F">Feminino<br>
            <input type="radio" name="sexo" id="sexo" value="O">Outro<br>
            Data de Nascimento: <input type="date" name="data" id="data"><br>
            Telefone (apenas dígitos):<input type="text" name="telefone" id="telefone" placeholder="xx999999999" pattern="[0-9]{11}"  title="Numero de telefone apenas com digitos (com DDD)"><br>
            CEP (apenas dígitos): <input type="text" name="cep" id="cep" placeholder="13333333" pattern="[0-9]{8}" title="Código Postal apenas com dígitos"<br>
            Endereço:<input type="text" name="end" id="end" maxlength="70">                Número:<input type="number" name="numero" id="numero"  maxlength="5"><br>
            Bairro:<input type="text" name="bairro" id="bairro" maxlength="40">               Complemento:<input type="text" name="complemento" id="complemento" maxlength="73"><br>
            Cidade:<input type="text" name="cidade" id="cidade" maxlength="60">               UF:<input type="text" name="uf" id="uf" placeholder="XX" pattern="[A-Z]{2}"><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
