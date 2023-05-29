<%@page import="br.com.restaurante.model.Client"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" type="text/css" href="estilos/cadastro.css">
  <title>Cadastro</title>

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
  <div class="container">
    <div class="card">

      <h2>Cadastro</h2>

      <form action="/create-client" method="post" >
        <div class="label-float">
          <label for="name">Nome:</label>
          <input type="text" name="name" id="name" maxlength ="30" required>
          <label for="lastName">Sobrenome:</label>
          <input type="text" name="lastName" id="lastName" maxlength="100" required>
          <label for="name">Cpf:</label>
          <input type="text" name="cpf" id="cpf" maxlength="11" pattern="[0-9]{11}" required>
          <label for="email">Email:</label><br>
          <input type="email" name="email" id="email" maxlength="100" required>
          <label for="password">Senha:</label>
<<<<<<< HEAD
          <input type="password" name="password" id="password" minlength="8" r\equired>
=======
          <input type="password" name="password" id="password" minlength="8" required>
>>>>>>> 0088bf488ae37fac566c720a056a8ad539275f37

        </div>
        <div class="justify-center">
          <button class="botao" type="submit">Cadastrar</button>
        </div>

        <div class="justify-center">
          <hr>
        </div>
      </form>
    </div>
  </div>

</main>

<footer class="Rodape">
  <h4>&copyTodos os direitos reservados</h4>
</footer>

</body>

</html>