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
 <h1>User Profile</h1>
    <form  name="perfil" action="perfil-cliente" method="get" enctype="multipart/form-data">

                        </div>
                        <div class="itemDados">
                            <input type="text" class="campo" placeholder="Nome do titular:" value=<%= cliente.getName() %> readonly>
                            <input type="text" class="campo" placeholder="Sobrenome : " value= <%= cliente.getLastName() %>  readonly >
                            <input type="text" class="campo" placeholder="CPF do titular:" value= <%= cliente.getCpf() %>  readonly>
                            <input type="text" class="campo" placeholder="RG do titular:" value= <%= cliente.getEmail() %>  readonly>
                            <a id="button" href="#">Alterar senha</a>
                        </div>
                        </div>
                        </div>
                        </form>
    <a href="logout">Logout</a>
</body>
</html>






