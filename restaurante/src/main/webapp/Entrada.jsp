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
    <link rel="stylesheet" href="estilos/cardapioOpcao.css">
</head>

<body>
<header class="containerHeader">
    <div>
        <nav class="navCadastro">
            <ul>
                <li class="LoginECadastro"> Acesse seu <a href="login.jsp">Login</a></li>
                <li class="LoginECadastro"> ou <a href="Cadastro.jsp">Cadastre se</a></li>
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
        <div class="menu-opcao">
            <form action="/listar-entradas" method="get">
                <button class="opcao">ENTRADAS</button>
            </form>
            <form action="/listar-pratoPrincipal" method="get">
                <button class="opcao">PRATOS PRINCIPAIS</button>
            </form>
            <form action="/listar-carnes" method="get">
                <button class="opcao">CARNES</button>
            </form>
            <form action="/listar-acompanhamentos" method="get">
                <button class="opcao">ACOMPANHAMENTOS</button>
            </form>
            <form action="/listar-sobremesas" method="get">
                <button class="opcao">SOBREMESAS</button>
            </form>
            <form action="/listar-bebidas" method="get">
                <button class="opcao">BEBIDAS</button>
            </form>
        </div>

        <div class="container-cardapio">
            <c:forEach var="prato" items="${pratos}">
                <div class="cada-prato">
                    <div>
                    <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${prato.image}">
                        <img style="width: 160px" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${prato.image}" alt="...">
                    </a>
                    </div>
                    <div id="abc">
                        <div>${prato.nome}</div>
                        <div>R$  ${prato.preco}</div>
                    </div>
                    <div style="font-size: 12px;" >${prato.descricao}</div>

                </div>
            </c:forEach>
        </div>
    </div>
</main>
<footer class="Rodape">
    <h5>&copyTodos os direitos reservados</h5>
</footer>
</body>
</html>
