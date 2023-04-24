<%@page import="br.com.restaurante.model.Reserva"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

    ArrayList<Reserva> lista = (ArrayList<Reserva>) request.getAttribute("reservas");
%>
    <!DOCTYPE html>
    <html lang="PT-BR">


     <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Reservas</title>
        </head>

         <body>
                <h1>Reservas</h1>
                <a href="report" class="btn btn-info">Relatório</a>
                <table id="tabela" class="table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Data</th>
                            <th scope="col">Hora</th>
                            <th scope="col" >Pessoas</th>
                            <th scope="col">Ambiente</th>
                            <th scope="col">Observações</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < lista.size(); i++) {
                     %>
                    <tr scope="row">
                    <td id= <%=lista.get(i).getId()%> ><%=lista.get(i).getId()%></td>
                    <td><%=lista.get(i).getData()%>></td>
                    <td><%=lista.get(i).getHora()%></td>
                    <td><%=lista.get(i).getQntPessoas()%></td>
                    <td><%=lista.get(i).getAmbiente()%></td>
                    <td><%=lista.get(i).getObs()%></td>
                    </tr>
                    <% } %>
                    </tbody>
                    </table>
                      </body>
                    </html>