<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
		<link rel="stylesheet" href="css/bulma.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/eb229d8c54.css">
		<link rel="stylesheet" href="css/estilo.css">
	</head>
	<body>
		<header>
			<a href="index.jsp">	
      			<i class="return-button fa fa-sign-out fa-5x" aria-hidden="true"></i>
	      	</a>
			<h1>Home</h1>
		</header>
		
		<div class="container">
			<div class="columns">
				<div class="column">
					<a href="adicionar-produtos.jsp" class="button menu-button">
						<i class="fa fa-plus-square-o fa-3x" aria-hidden="true"></i></i>
						Adicionar
					</a>
				</div>
				<div class="column">
					<a href="listar-produtos.jsp" class="button menu-button">
						<i class="fa fa-search fa-lg fa-3x" aria-hidden="true"></i>
						Pesquisar
					</a>
				</div>
			</div>
		</div>	
	</body>
</html>