<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alterar Produto</title>
	<link rel="stylesheet" href="css/bulma.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/eb229d8c54.css">
	<link rel="stylesheet" href="css/estilo.css">
	</head>
	<body>
		<header>
			<a href="listar-produtos.jsp">	
      			<i class="return-button fa fa-angle-left fa-5x" aria-hidden="true"></i>
	      	</a>
			<h1>Alterar Produtos</h1>
		</header>
		
		<div class="column is-6 is-offset-3">
			<form method="post" action="AlterarProdutoServlet">
				<label class="label">ID</label>	
				<p class="control">
				  <input class="input is-disabled" type="text" value="${param.id}" name="id">
				</p>
				
				<label class="label">Nome</label>	
				<p class="control">
				  <input class="input" type="text" value="${produto.nome}" name="nome">
				</p>
				
				<label class="label">Data Compra</label>
				<p class="control">
				  <input class="input" type="text" value='<fmt:formatDate value="${produto.dataCompra}" pattern="dd/MM/yyyy"/>' name="datacompra">
				</p>
				
				<label class="label">Descricao</label>
				<p class="control">
				  <input class="input" type="text" value="${produto.descricao}" name="descricao">
				</p>
				
				<label class="label">Quantidade Estoque</label>
				<p class="control">
				  <input class="input" type="text" value="${produto.qtEstoque}" name="quantidade">
				</p>
				
				<label class="label">Preco</label>
				<p class="control">
				  <input class="input" type="text" value="${produto.preco}" name="preco">
				</p>			
				
				<p class="control">
				  <button class="button">Alterar</button>
				</p>
			</form>
		</div>		
	</body>
</html>