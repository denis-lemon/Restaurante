<%@page import="br.com.restaurante.model.Employee"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

    ArrayList<Employee> lista = (ArrayList<Employee>) request.getAttribute("employees");
%>
<!DOCTYPE html>
    <html lang="PT-BR">

     <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Lista de Funcionários</title>
            <link rel="stylesheet" type="text/css" href="estilos/listReserva.css">
        </head>
                 <body>
                        <h1>Gerenciamento de Funcionários</h1>
                        <table id="tabela" class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">LastName</th>
                                    <th scope="col" >CPF</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Ação</th>
                                   
                                    </tr>
                            </thead>
                            <tbody>
                            <%
                                for (int i = 0; i < lista.size(); i++) {
                             %>

                            <tr scope="row">
                            <td id= <%=lista.get(i).getId()%> ><%=lista.get(i).getId()%></td>
                            <td><%=lista.get(i).getName()%></td>
                            <td><%=lista.get(i).getLastName()%></td>
                            <td><%=lista.get(i).getCpf()%></td>
                            <td><%=lista.get(i).getEmail()%></td>
                            <td>
                            <form action = "/delete-funcionario" method="post">
                             <input type="hidden" name="id" value="<%=lista.get(i).getId()%>"/>
                             <input type="submit" value ="Delete"/>
                             </form>
                             </td>
                             </tr>
                              <% } %>
                              </tbody>
                             </table>
                             </thead>
                             </html>
