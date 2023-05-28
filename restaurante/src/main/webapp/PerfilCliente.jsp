<%@page import="br.com.restaurante.model.Client"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
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
                        <li class="LoginECadastro"> ou <a href="Cadastro.html">Cadastre se</a></li>
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

 <h1>Meu Perfil</h1>
    <form  name="perfil" action="perfil-cliente" method="post" enctype="multipart/form-data">

                        </div>
                        <div class="itemDados">
                         <label for="id" type="text" class="campo">ID:<%= cliente.getId() %> </label>
                            <label for="name" type="text" class="campo">Nome:<%= cliente.getName() %></label>
                            <label for="lastName" type="text" class="campo">Sobrenome:<%= cliente.getLastName() %></label>
                            <label for="cpf" type="text" class="campo">CPF:<%= cliente.getCpf() %></label>
                            <label for="email" type="text" class="campo">Email:<%= cliente.getEmail() %></label>
                            <a id="button" href="/update-cliente?email=<%= cliente.getEmail() %>">Atualizar</a>
                        </div>
                        </div>
                        </div>
                        </form>
    <a href="logout">Logout</a>
</body>
</html>






