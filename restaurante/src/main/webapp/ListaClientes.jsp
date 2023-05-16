<%@page import="br.com.restaurante.model.Client"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

    ArrayList<Client> lista = (ArrayList<Client>) request.getAttribute("clients");
%>
<!DOCTYPE html>
    <html lang="PT-BR">

     <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Reservas</title>
            <link rel="stylesheet" type="text/css" href="estilos/listReserva.css">
        </head>
                 <body>
                        <h1>Gerenciamento de Clientes</h1>
                        <table id="tabela" class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">LastName</th>
                                    <th scope="col" >CPF</th>
                                    <th scope="col">Email</th>

                                </tr>
                            </thead>
                            <tbody>
                            <%
                                for (int i = 0; i < lista.size(); i++) {
                             %>

                            <tr scope="row">
                            <td id= <%=lista.get(i).getId()%> ><%=lista.get(i).getId()%></td>
                            <td><%=lista.get(i).getName()%>></td>
                            <td><%=lista.get(i).getLastName()%></td>
                            <td><%=lista.get(i).getCpf()%></td>
                            <td><%=lista.get(i).getEmail()%></td>

                            </tr>
                            <% } %>
                            </tbody>
                            </table>
                              </body>
                            </html>

