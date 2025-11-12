<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="Stylesheet" href="Style.css">
</head>
<body>
	<h1>Página de Login</h1>
	<form action="LoginServlet" method="post">
	Usuário: <input type="text" name="username" placeholder="Digite seu usuário" requered><br><br>
	Senha: <input type="password" name="senha" placeholder="Digite sua senha" requered><br><br>
	<button type="submit">Entrar</button>
	</form>
<%String msg = (String) request.getAttribute("mensagem");
	if(msg != null){
%>

	<script>
	alert.("<%= msg %>");
	</script>
	<%} %>
</body>
</html>