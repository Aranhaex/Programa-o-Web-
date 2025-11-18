<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Novo Usuário</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>

	<div class="login-container">
		<h1>Criar Conta</h1>
		
		<form action="CadastroServlet" method="post">
			<label for="username">Escolha um Usuário</label>
			<input type="text" name="username" placeholder="Ex: Ian Gabriel" required>
			
			<label for="senha">Escolha uma Senha</label>
			<input type="password" name="senha" placeholder="Sua senha" required>
			
			<button type="submit">Cadastrar</button>
		</form>
		
		<div style="text-align: center; margin-top: 15px;">
			<a href="Login.jsp" style="color: #667eea; text-decoration: none;">Já tem conta? Voltar</a>
		</div>
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