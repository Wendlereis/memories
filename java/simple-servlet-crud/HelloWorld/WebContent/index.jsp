<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="css/estilo.css">
		<link rel="stylesheet" href="css/bulma.css">
	</head>
	<body>
		<header>
			<h1>Login</h1>
		</header>
		
		<section class="column is-4 is-offset-4 is-mobile">
			<form id="formLogin" method="post" action="LoginServlet">
				<span class="tag is-danger is-large">
				 	Usuario não encontrado
				</span>
				
				<label class="label">Usuário</label>
				<p class="control">
					<input class="input" type="text" name="login">
				<p>
				
				<label class="label">Senha</label>
				<p class="control">
					<input class="input" type="password" name="senha">
				<p>
				
				<p class="control">
				  <button class="button">Entrar</button>
				</p>
			</form>
		</section>
	</body>
</html>