<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <form method="post" action="/adicionarPrato" >

        <label for="nome">Nome do prato: </label>
       <input type="text" name="nome" id="nome">
       <label for="nome">Tipo:</label>
       <select name="tipo" id="tipo">
        <option> ENTRADA </option>
        <option> PRATO PRINCIPAL </option>
        <option> CARNES </option>
        <option> ACOMPANHAMENTOS </option>
        <option> BEBIDA </option>
        <option> SOBREMESA </option>
       </select>
       <label for="descricao">Descrição</label>
       <input type="text" name="descricao" id="descricao">

         <button id="submit">Enviar</button>

    </form>

</body>
</html>