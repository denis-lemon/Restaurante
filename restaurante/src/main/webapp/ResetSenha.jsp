<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Redefinir Senha</title>
</head>
<body>
<h2>Redefinir Senha</h2>
<form action="resetSenha" method="post">
    <input type="hidden" name="id" value="${clienteId}">
    <label for="password">Nova Senha:</label><br>
    <input type="password" name="password" id="password"><br>
    <label for="confirmPassword">Confirmar Nova Senha:</label><br>
    <input type="password" name="confirmPassword" id="confirmPassword"><br>
    <button type="submit">Redefinir Senha</button>
</form>
</body>
</html>
