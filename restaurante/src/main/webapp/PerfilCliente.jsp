<%@page import="br.com.restaurante.model.Client"%>
<%@page import="br.com.restaurante.model.Reserva"%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

Client cliente = (Client) request.getAttribute("cliente");
ArrayList<Reserva> reservas = (ArrayList<Reserva>) request.getAttribute("reservas");
    %>
    
    <!DOCTYPE html>
    <html lang="PT-BR">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Perfil</title>
            <!--<link rel="stylesheet" href="estilos/perfil-cliente.css">-->
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
object-fit: cover;
height: 100%;
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
align-items: center;
margin-top: 50px;
width: 100%;
}

h1 {
display: flex;
align-items: flex-start;
margin-top: 0px;
color: #daa520;
}

.meuPerfil {
background-color: #6B1108;
width: 100vh;
height: 20vh;
padding: 10px;
border-radius: 15px;
}

.itemDados {
line-height: 30px;
color: #ffffff;
font-weight: 600;
}

.button-end{
text-align: end;
margin-right: 14px;
text-transform: uppercase;
font-weight: bold;
font-size: 15px;
}


.minhaReserva {
position: absolute;
background-color: #6B1108;
width: 100vh;
height: 32vh;
padding: 10px;
border-radius: 15px;
top: 50vh;
box-sizing: border-box;
}

.itemDados2-container {
margin-top: 45px;
display: flex;
flex-direction: row;
flex-wrap: wrap;
gap: 10px;
align-items: flex-start;
justify-content:space-around;
}

.itemDados2 {
width: 30%;
line-height: 24px;
color: #6B1108;
font-weight: 600;
background-color: #ffffec;
float: left;
padding: 5px;
}

#perfil{
text-transform: capitalize;
}

.tit-reserva{
height: 15px;
}

.btn-container{
    position: absolute;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    flex-wrap: nowrap;
    width: 10%;
    text-align: center;
    top: 28vh;
    left: 130vh;
    gap: 5px;
}

.btn-style{
    background-color: #daa520;
    color: #6B1108;
    padding: 10px;
    border: 1px solid black;
    border-radius: 5px;
    width: 100%;
    cursor: pointer;
    }

    .btn-style:hover{
        background-color: #bb8e1c;
    }

    .btn-style a{
    color: #6B1108;
    }

     a {
        color: #daa520;
        text-decoration: none;
        margin-top: 30px;
        font-weight: bold;
    }

    a:hover {
        color: #ffffff;
    }

    .btn-style button{
        width: 50%;
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
                            <% if ( cliente != null) { %>
                            <label for="name" type="text" class="LoginECadastro" id="perfil" <li class="LoginECadastro"> Bem vindo! <%= cliente.getName() %> <%= cliente.getLastName() %></li></label>
                            <li class="LoginECadastro" ><br>Acesse seu <a href="PerfilCliente.jsp">perfil</a></li>
                            <% } else { %>
                             <ul>
                             <label for="name" type="text" class="loginECadastro"<li class="LoginECadastro"> Acesse seu <a href="login.jsp">Login</a></li></label>
                             <label for="name" type="text" class="loginECadastro" <li class="LoginECadastro"> ou <a href="Cadastro.jsp">Cadastre se</a></li></label>
                             <ul>
                            <% }; %>
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
        <div class="fundo"></div>
        <main>
            <div class="containerMain">
 <div class="meuPerfil">
 <h1>Meu Perfil: </h1>
    <form  name="perfil" action="perfil-cliente" method="post" enctype="multipart/form-data">
        <div class="itemDados">
            <label for="id" type="text" class="campo">ID: <%= cliente.getId() %><br> </label>
            <label for="name" type="text" class="campo">Nome: <%= cliente.getName() %> <%= cliente.getLastName() %><br></label>                                               <label for="cpf" type="text" class="campo">CPF: <%= cliente.getCpf() %><br></label>
            <label for="email" type="text" class="campo">Email: <%= cliente.getEmail() %><br></label>
                <div class="btn-container">
                    <div class="btn-style">
                        <a href="/update-cliente?email=<%= cliente.getEmail() %>">Atualizar</a>
                    </div>
                    <div class="btn-style">
                        <a href="logout">Logout</a>
                    </div>
                </div>
        </div>
    </form>
    
</div>
<div class="minhaReserva">    
<h1 class="tit-reserva">Minhas Reservas: <br></h1>
<% if (reservas != null) {  %>
    <div class="itemDados2-container">
<% for (Reserva reserva : reservas) {  %>
    <div class="itemDados2">
        <label for="id" type="text" class="campo">ID: <%=reserva.getId()%><br></label>
        <label for="data" type="text" class="campo">Data: <%=reserva.getData()%><br></label>
        <label for="hora" type="text" class="campo">Hora: <%=reserva.getHora()%><br></label>
        <label for="qntPessoas" type="text" class="campo">Quantidade de Pessoas: <%=reserva.getQntPessoas()%><br></label>
        <label for="ambiente" type="text" class="campo">Ambiente: <%=reserva.getAmbiente()%><br></label>
        <label for="obs" type="text" class="campo">Observações: <%=reserva.getObs()%><br></label>
        <label for="status" type="text" class="campo">Status: <%=reserva.getStatus()%><br></label>
         <form action = "/delete-reserva" method ="post">
         <input type="hidden" name="id" value="<%=reserva.getId()%>"/>
         <button class="btn-style" type="submit">Cancelar</button>
        </div>
        <% } %>
      </div>
      <% } %>
    </div>
</form>
</div>
</main>
<footer class="Rodape">
    <h5>&copyTodos os direitos reservados</h5>
</footer>
</body>
</html>






