<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.restaurante.model.Prato"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Prato> lista = (ArrayList<Prato>) request.getAttribute("pratos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cardapio</title>
    <link rel="stylesheet" href="estilos/cardapio.css">
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
                <li class="fonteCabecalho"><a href="Reserva.html">Reservas</a></li>
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

    <div class="container-main">
        <div class="container" >
            <h1> Cardapio </h1>
                <table class="tabela">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Tipo</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Imagem</th>
                    </tr>
                    <c:forEach var="prato" items="${pratos}">
                        <tr>
                            <td>${prato.id}</td>
                            <td>${prato.nome}</td>
                            <td>${prato.tipo}</td>
                            <td>${prato.descricao}</td>
                            <td>R$  ${prato.preco}</td>
                            <td>
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${prato.image}">
                                    <img style="width: 200px" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${prato.image}" alt="...">
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
    </div>
</main>
<footer class="Rodape">
    <h5>&copyTodos os direitos reservados</h5>
</footer>
</body>
</html>