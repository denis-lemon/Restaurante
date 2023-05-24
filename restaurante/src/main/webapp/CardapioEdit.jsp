
<%@page import="br.com.restaurante.model.Prato"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Prato> lista = (ArrayList<Prato>) request.getAttribute("pratos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="estilos/listCardapio.css">
</head>
<body>
    <form method="post" action="/cardapio" enctype="multipart/form-data">
        <input type="hidden" name="id" id="id" value="${param.id}">
        <label for="nome">Nome do prato: </label>
       <input type="text" name="nome" id="nome" value="${param.nome}">
       <label for="tipo">Tipo:</label>
       <select name="tipo" id="tipo">
        <option> ENTRADA </option>
        <option> PRATO PRINCIPAL </option>
        <option> CARNES </option>
        <option> ACOMPANHAMENTOS </option>
        <option> BEBIDA </option>
        <option> SOBREMESA </option>
       </select>
       <label for="descricao">Descrição</label>
       <input type="text" name="descricao" id="descricao" value="${param.descricao}"> <br>
        <label for="preco">Preço : </label>
        <input type="text" name="preco" id="preco" value="${param.preco}"> <br>
        <input type="file" name="file" id="file">

        <button id="submit">Save</button>

    </form>
    <br>
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
                <th>Ações</th>
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
                            <img style="width: 50px" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${prato.image}" alt="...">
                        </a>
                    </td>
                    <td>
                        <form action="/delete-prato" method="post">
                        <input type="hidden" id="id" name="id" value="${prato.id}">
                        <button type="submit">Deletar</button>
                        <span> | </span>
                        <a href="CardapioEdit.jsp?id=${prato.id}&nome=${prato.nome}&tipo=${prato.tipo}&descricao=${prato.descricao}&preco=${prato.preco}&image=${prato.image}">Update</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

