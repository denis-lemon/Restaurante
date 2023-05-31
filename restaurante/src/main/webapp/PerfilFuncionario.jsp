<%@page import="br.com.restaurante.model.Employee"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Employee funcionario = (Employee) request.getAttribute("funcionario");
%>

<!DOCTYPE html>
    <html lang="PT-BR">

     <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Perfil</title>
        </head>
<style>
@import url('https://fonts.googleapis.com/css2? family= Inter:wght@100;200;300;400;500;600 & family= Poppins:ital,wght@0,100;0,200; 0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900 & display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Roboto+Condensed:ital,wght@0,700;1,300&display=swap');
* {
margin: 0;
padding: 0;
font-family: 'Poppins', sans-serif;
}

body {
overflow-x: hidden;
background-color: #ffffec;
}

/*HEADER*/
.containerHeader {
background-color: #6B1108;
font-weight: bold;
color: #ffffff;
padding: 10px;
position: relative;
width: 100%;
height: 60px;
}

.logo {
width: 15vh;
margin-top: -67px;
margin-right: 17px;
}

a:hover {
color: #ffffff;
transition: all .3s ease-out;
}

.navCadastro {
position: absolute;
top: 1vh;
right: 10vh;
}

.LoginECadastro {
display: inline;
font-size: 12pt;
}

.navOpcoes li {
position: relative;
top: 2vh;
left: 73vh;
padding: 30px;
}

.fonteCabecalho {
display: inline;
font-size: 15pt;
}

a {
text-decoration: none;
color: #daa520;
}

/*MAIN*/

.fundo {
content: "";
position: fixed;
left: 0;
right: 0;
z-index: -1;
display: block;
background-image: url("/img/fundo.jpg");
object-fit:fill;
height: 120vh;
width: 100%;
-webkit-filter: blur(10px);
-moz-filter: blur(10px);
-o-filter: blur(10px);
-ms-filter: blur(10px);
filter: blur(5px) brightness(0.80);


}

.containerMain {
display: flex;
flex-direction: column;
flex-wrap: nowrap;
margin-left: 25%;
margin-top: 150px;
width: 100%;
justify-content: center;
}

h1 {
display: flex;
align-items: flex-start;
margin-left: 15px;
color: #daa520;
}

.meuPerfil {
background-color: #6B1108;
width: 100vh;
padding: 12px;
line-height: 23px;
border-radius: 15px;
margin-left: 15px;
color: #ffffff;
}

.itemDados {
line-height: 25px;
color: #ffffff;
font-weight: 600;
}

.buttons{
display: flex;
text-align: start;
text-transform: uppercase;
font-weight: bold;
font-size: 15px;
align-items: flex-start;
gap: 25px;
margin-left: 20px;
margin-top: 30px;
}

.btn-style{
    background-color: #daa520;
    color: #6B1108;
    padding: 10px;
    border: 1px solid black;
    border-radius: 5px;
}

.btn-style a{
    color: #6B1108;
}

/*RODAPÉ*/
.Rodape {
background-color: #6B1108;
padding: 10px;
text-align: center;
color: #ffffff;
position: absolute;
font-size: 10pt;
width: 100%;
height: 10px;
margin: auto;
bottom: 0;
}

</style>
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
        <main>
<div class="containerMain">
 <div class="fundo"></div>
 <h1>Meu Perfil</h1>
    <div class="meuPerfil">
    <form  name="perfil" action="perfil-funcionario" method="post" enctype="multipart/form-data">

                        <div class="">
                         <label for="id" type="text" class="campo">ID: <%= funcionario.getId() %> <br></label>
                            <label for="name" type="text" class="campo">Nome: <%= funcionario.getName() %> <%= funcionario.getLastName() %><br></label>
                            <label for="cpf" type="text" class="campo">CPF: <%= funcionario.getCpf() %><br></label>
                            <label for="email" type="text" class="campo">Email: <%= funcionario.getEmail() %><br></label>
                            <a id="button" href="/update-funcionario?email=<%= funcionario.getEmail() %>">Atualizar<br></a>
                            </div>
                        </div>
                        </form>

    <div class="buttons">
    <div class="btn-style"><a href="logout">Logout </a></div>
    <div class="btn-style"><a href="/listar-reservas">Gerenciamento de Reservas</a></div>
    <div class="btn-style"><a href="/listar-pratos">Gerenciamento de Cardápio</a></div>
    </div>
</div>        
</main>
    <footer class="Rodape">
        <h5>&copyTodos os direitos reservados</h5>
    </footer>
</body>
</html>






