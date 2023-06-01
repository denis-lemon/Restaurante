<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="estilos/login.css">
    <title>Login</title>
</head>
<body>
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
                        <li class="fonteCabecalho"><a href="/home">Home</a></li>
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
<main>
    <div class="container">
        <div class="card">

            <h2>Insira seu email e Redefina uma nova senha</h2>

            <form action="resetSenha" method="post">
            <div class="label-float">
                <label for="clienteEmail">Email:</label><br>
                <input type="email" name="clienteEmail" id="clienteEmail" maxlength="100" required><br>
                <label for="password">Nova Senha:</label><br>
                <input type="password" name="password" id="password" minlength="8" required><br>
                <label for="confirmPassword">Confirmar Nova Senha:</label><br>
                <input type="password" name="confirmPassword" id="confirmPassword" minlength="8" required><br>
                </div>
                <div class="justify-center">
                            <button class="botao" type="submit">Redefinir Senha</button>
                        </div>
            </form>




        </div>
    </div>

</main>
</body>
</html>
