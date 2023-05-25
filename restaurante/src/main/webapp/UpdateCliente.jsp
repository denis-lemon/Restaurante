<%@page import="br.com.restaurante.model.Client"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    Client cliente = (Client) request.getAttribute("cliente");
%>

<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Perfil</title>
</head>

<body>
<header class="containerHeader">
    <div>
        <nav class="navCadastro">
            <ul>
                <li class="LoginECadastro"> Acesse seu <a href="login.jsp">Login</a></li>
                <li class="LoginECadastro"> ou <a href="Cadastro.html">Cadastre-se</a></li>
            </ul>
        </nav>
        <nav class="navOpcoes">
            <ul>
                <li class="fonteCabecalho"><a href="home.html">Home</a></li>
                <li class="fonteCabecalho"><a href="Sobre.html">Sobre</a></li>
                <li class="fonteCabecalho"><a href="Cardapio.html">Cardápio</a></li>
                <li class="fonteCabecalho"><a href="Reserva.jsp">Reservas</a></li>
            </ul>
        </nav>
        <nav class="reserva">
            <ul>
                <a href="home.html"><img class="logo" src="img/logo.png" alt="" srcset=""></a>
            </ul>
        </nav>
    </div>
</header>
<main>
    <h1>Atualizar Dados</h1>
    <form name="perfil" action="update-cliente" method="get" enctype="multipart/form-data">
        <div class="itemDados">
            <label for="nome" type="text" class="campo">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= cliente.getName() %>" required>
            <label for="email" type="text" class="campo">E-mail:</label>
            <input type="email" id="email" name="email" value="<%= cliente.getEmail() %>" required>
            <label for="senha" type="password" class="campo">Nova Senha:</label>
            <input type="password" id="senha" name="senha" required>
            <button type="submit">Atualizar</button>
        </div>
    </form>
    <a href="logout">Logout</a>
</main>
</body>
</html>
