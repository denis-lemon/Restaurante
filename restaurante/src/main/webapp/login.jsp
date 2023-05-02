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
                <li class="LoginECadastro"> Acesse seu <a href="login.jsp">Login</a></li>
                <li class="LoginECadastro"> ou <a href="Cadastro.html">Cadastre se</a></li>
            </ul>
        </nav>
        <nav class="navOpcoes">
            <ul>
                <li class="fonteCabecalho"><a href="index.html">Home</a></li>
                <li class="fonteCabecalho"><a href="Sobre.html">Sobre</a></li>
                <li class="fonteCabecalho"><a href="Cardapio.html">Cardápio</a></li>
                <li class="fonteCabecalho"><a href="Reserva.html">Reservas</a></li>
            </ul>
        </nav>
        <nav class="reserva">
            <ul>
                <a href="index.html"><img class="logo" src="img/logo.png" alt="" srcset=""></a>
            </ul>
        </nav>
    </div>
</header>
<main>
    <div class="container">
        <div class="card">
            <h2>Login</h2>
            <form method="post" action="/login" >
                <div class="label-float">

                    <label for="email">Email:</label><br>
                    <input type="email" name="email" id="email">
                    <label for="password">Senha:</label>
                    <input type="password" name="password" id="password">
                </div>
                <div>
                    <a class="esqueceuSenha" href="EsqueceuSenha.html">Esqueceu sua senha?</a>
                </div>
                <div class="justify-center">
                    <button class="botao" id="submit">Entrar</button>
                </div>
                <div class="justify-center">
                    <hr>
                </div>

                <p class="semConta">Não tem uma conta?

                    <a class="cadastreSe" href="Cadastro.html">Cadastre se</a></p>
            </form>
        </div>
    </div>

</main>

<footer class="Rodape">

    <h4>&copyTodos os direitos reservados</h4>
</footer>

</body>
</html>