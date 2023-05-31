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
<style>
    @import url('https://fonts.googleapis.com/css2? family= Inter:wght@100;200;300;400;500;600 & family= Poppins:ital,wght@0,100;0,200; 0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900 & display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@700&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Roboto+Condensed:ital,wght@0,700;1,300&display=swap');
    * {
    margin: 0;
    padding: 0;
    font-family: 'Poppins', sans-serif;
    }
    
    body {
    overflow-x: hidden;
    background-color: #ffffec;
    }
    
    /*HEADER*/
    .containerHeader {
    background-color: #6B1108;
    font-weight: bold;
    color: #ffffff;
    padding: 10px;
    position: relative;
    width: 100%;
    height: 60px;
    }
    
    .logo {
    width: 15vh;
    margin-top: -67px;
    margin-right: 17px;
    }
    
    a:hover {
    color: #ffffff;
    transition: all .3s ease-out;
    }
    
    .navCadastro {
    position: absolute;
    top: 1vh;
    right: 10vh;
    }
    
    .LoginECadastro {
    display: inline;
    font-size: 12pt;
    }
    
    .navOpcoes li {
    position: relative;
    top: 2vh;
    left: 73vh;
    padding: 30px;
    }
    
    .fonteCabecalho {
    display: inline;
    font-size: 15pt;
    }
    
    a {
    text-decoration: none;
    color: #daa520;
    }

    /*main*/
    .fundo{
        content: "";
        position: fixed;
        left: 0;
        right: 0;
        z-index: -1;
        display: block;
        background-image: url("/img/fundo.jpg");
        object-fit: cover;
        height: 100%;
        width: 100%;
        -webkit-filter: blur(10px);
        -moz-filter: blur(10px);
        -o-filter: blur(10px);
        -ms-filter: blur(10px);
        filter: blur(5px) brightness(0.80);
        top: -5px;   
    }
    
    .containerMain {
        display: flex;
        flex-direction: column;
        flex-wrap: nowrap;
        align-items: center;
        margin-top: 50px;
        width: 100%;
    }

    h1{
    color: #fff;
    padding-bottom: 50px;
    }

    
    .form {
        background-color: #6B1108;
        width: 75vh;
        height: 45vh;
        display: flex;
        flex-direction: column;
        padding: 15px;
        border-radius: 10px;
        border: 2px solid black;
    }

    .campo {
        margin-bottom: 10px;
        font-weight: bold;
        padding: 15px;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        padding: 8px;
        border-radius: 5px;
        border: 1px solid black;
        margin-bottom: 15px;
        width: 50vh;
    }

    button[type="submit"] {
        background-color: #daa520;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-left: 42%;
    }

    button[type="submit"]:hover {
        background-color: #b5890b;
    }

    .gap{
        height: 15px;
    }

    a {
        color: #daa520;
        text-decoration: none;
        margin-top: 30px;
        font-weight: bold;
    }

    a:hover {
        color: #b5890b;
    }

    .btn-style{
    background-color: #daa520;
    color: #6B1108;
    padding: 10px;
    border: 1px solid black;
    border-radius: 5px;
    }

    .btn-style a{
    color: #6B1108;
    }

    .Rodape {
    background-color: #6B1108;
    padding: 10px;
    text-align: center;
    color: #ffffff;
    position: absolute;
    font-size: 10pt;
    width: 100%;
    height: 10px;
    margin: auto;
    bottom: 0;
    }
   </style> 
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
    <div class="fundo"></div>
    <div class="containerMain">
        <div class="form">
    <h1>Atualizar Dados</h1>
    <form name="perfil" action="update-cliente" method="post" enctype="application/x-www-form-urlencoded">
        <div class="itemDados">
            <label for="name" type="text" class="campo">Nome:</label>
            <input type="text" id="name" name="name" value="<%= cliente.getName() %>" required><br>
            <div class="gap"></div>
            <label for="email" type="text" class="campo">E-mail:</label>
            <input type="email" id="email" name="email" value="<%= cliente.getEmail() %>" required><br>
            <div class="gap"></div>
            <label for="password" type="password" class="campo">Nova Senha:</label>
            <input type="password" id="password" name="password" value="<%=cliente.getPassword() %>" required><br>
            <div class="gap"></div>
            <label for="id" type="text" class="campo">ID: </label>
            <input type="text" id="id" name="id" value="<%=cliente.getId() %>" readonly>
            <button type="submit">Atualizar</button>
        </div>
    </div>
    <a class="btn-style" href="logout">Logout</a>
    </div>
    </form>
</main>
<footer class="Rodape">
    <h5>&copyTodos os direitos reservados</h5>
</footer>
</body>
</html>
