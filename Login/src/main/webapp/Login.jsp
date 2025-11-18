<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login do Sistema</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>

	<div class="login-container">
		<h1>Bem-vindo</h1>
		
		<form action="LoginServlet" method="post">
			<label for="username">Usuário</label>
			<input type="text" id="username" name="username" placeholder="Digite seu usuário" required>
			
			<label for="senha">Senha</label>
			<input type="password" id="senha" name="senha" placeholder="Digite sua senha" required>
			
			<button type="submit">Entrar</button>
			<a href="Cadastro.jsp">Criar conta</a>
		</form>
	</div>

	<% 
		String msg = (String) request.getAttribute("mensagem");
		if(msg != null){
	%>
		<script>
			alert("<%= msg %>");
		</script>
	<% } %>

</body>
</html>