
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
    <style>
        *{
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
        }
        #container-formulario h2{
         margin: 10px;
        }
        #cadastro{
            margin: 0px 25px;
            display: flex;
            flex-direction: column;
            gap: 1.5em;
        }
        #cadastro div{
             display: flex;
             flex-direction: column;
        }
        #cadastro div input{
            padding:5px;
            font-size: 16px;
            width: 400px;

        }
        #cadastro div button:hover{
            background: green;
            color: white;
         }
         #cadastro div button{
            background: lightgreen;
            width: 200px;
            height: 40px;
         }
         #cadastro div select{
            width: 400px;
            height: 25px;
          }

        div.container{
            display:flex;
            flex-direction:column;
            justify-content:center;
            align-items: center;
        }
        h1 {
            color: #daa520;
        }
        .tabela, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        .tabela{
            min-width: 800px;
            margin-top: 30px;
            margin-left: 15px;
            text-align: left;
        }

        .tabela tr th {
        	height: 30px;
        	padding: 5px;
        	background-color: #6B1108;;
        	color: #fff;
        }
        
        #tabela tr td {
            height: 30px;
        	padding: 10px;
        }

    </style>
</head>
<body>
    <div id="container-formulario">
        <h2> Cadastrar Cardapio </h2>
        <form id="cadastro" method="post" action="/cardapio" enctype="multipart/form-data">
            <div>
                <input type="hidden" name="id" id="id" value="${param.id}">
            </div>
            <div>
                <label for="nome">Nome do prato: </label>
               <input type="text" name="nome" id="nome" value="${param.nome}">
            </div>
            <div>
               <label for="tipo">Tipo:</label>
               <select name="tipo" id="tipo">
                <option> ENTRADA </option>
                <option> PRATO PRINCIPAL </option>
                <option> CARNES </option>
                <option> ACOMPANHAMENTOS </option>
                <option> BEBIDA </option>
                <option> SOBREMESA </option>
               </select>
           </div>
           <div>
               <label for="descricao">Descrição</label>
               <input type="text" name="descricao" id="descricao" value="${param.descricao}"> <br>
           </div>
            <div>
                <label for="preco">Preço : </label>
                <input type="text" name="preco" id="preco" value="${param.preco}"> <br>
            </div>
            <div>
                <input type="file" name="file" id="file">
                <button id="submit">Save</button>
            </div>
        </form>
    </div>
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

