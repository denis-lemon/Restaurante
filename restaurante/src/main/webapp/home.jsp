<%@page import="br.com.restaurante.model.Client"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Client cliente = (Client) request.getAttribute("cliente");

%>

<!doctype html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="estilos/home.css">

  <title>Home</title>
</head>

<header class="containerHeader">
  <div>
        <nav class="navCadastro">
                    <ul>
                        <%-- Verifica se o cliente está logado --%>
                        <% if (cliente != null) { %>
                            <li class="LoginECadastro">Bem vindo! <%= cliente.getName() %> <%= cliente.getLastName() %></li>
                            <li class="LoginECadastro">Acesse seu <a href="/perfil-cliente">perfil</a></li>
                        <% } else { %>
                            <li class="LoginECadastro">Acesse seu <a href="login.jsp">Login</a></li>
                            <li class="LoginECadastro">ou <a href="Cadastro.jsp">Cadastre-se</a></li>
                        <% } %>
                    </ul>
                </nav>
    <nav class="navOpcoes">
      <ul>
        <li class="fonteCabecalho"><a href="home.jsp">Home</a></li>
        <li class="fonteCabecalho"><a href="Sobre.html">Sobre</a></li>
        <li class="fonteCabecalho"><a href="Cardapio.html">Cardápio</a></li>
        <li class="fonteCabecalho"><a href="Reserva.jsp">Reservas</a></li>

      </ul>
    </nav>
    <nav class="reserva">
      <ul>
        <a href="home.jsp"><img class="logo" src="img/logo.png" alt="" srcset=""></a>
      </ul>
    </nav>
  </div>
</header>

<body>
  <main>
    <div class="fundo">
    </div>
    <div class="descricao">
      <h2><strong>Bem vindos ao nosso Cantinho brasileiro!</strong></h2>
      <aside>
        Com uma enorme variedade de pratos servimos uma enorme variedade de comidas tipicas de todo o nosso grande
        Brasil!<br>
        Faça já sua <strong> <a href="Reserva.jsp"> reserva </a></strong> e venha aproveitar nossos deliciosos pratos e
        confira o nosso <strong> <a href="Cardapio.html"> cardapio</a></strong>.
      </aside>
    </div>
    <section class="galeria">
      <div class="fotos">
        <img src="./img/coxinha.webp" alt="Feijoada">
        <img src="./img/1684619014546-frango.jpg" alt="Frango">
        <img src="./img/1684618796874-moqueca.webp" alt="Moqueca">
        <img src="./img/comidas-tipicas-do-brasil-feijoada-1.jpg.webp" alt="Feijoada">
        <img src="./img/coxinha.webp" alt="Feijoada">
      </div>
    </section>

  </main>
</body>
<footer class="Rodape">

  <h4>&copyTodos os direitos reservados</h4>
</footer>


</html>