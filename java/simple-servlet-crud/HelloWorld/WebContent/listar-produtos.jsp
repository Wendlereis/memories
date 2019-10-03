<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Produtos</title>
		<link rel="stylesheet" href="css/bulma.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/eb229d8c54.css">
		<link rel="stylesheet" href="css/estilo.css">
	</head>
	<body>
		<jsp:useBean id="business" class="br.com.verity.helloworld.business.ProdutoBusiness" />
		
		<header>
			<a href="home.jsp">	
      			<i class="return-button fa fa-angle-left fa-5x" aria-hidden="true"></i>
	      	</a>
			<h1>Listar Produtos</h1>
		</header>
		
		<div class="column is-8 is-offset-2 is-mobile">
			<table class="table is-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Data Compra</th>
						<th>Descrição</th>
						<th>Quantidade Estoque</th>
						<th>Preço</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="produto" items="${business.lista}">
					    <tr>
					      <td>${produto.nome}</td>
					      <td>
					      	<fmt:formatDate value="${produto.dataCompra}" pattern="dd/MM/yyyy"/>  
					      </td>
					      <td>
					      	<c:if test="${empty produto.descricao}">N/A</c:if>
					      	<c:if test="${not empty produto.descricao}">${produto.descricao}</c:if> 
					      </td>
					      <td>${produto.qtEstoque}</td>
					      <td>${produto.preco}</td>
					      <td>
					      	<a href="AlterarProdutoServlet?id=${produto.id}" class="button">
					      		<span class="icon">
						      		<i class="fa fa-pencil-square-o"></i>
						      	</span>
					      	</a>					      	
					      </td>
					      <td>
					      	<a href="ExcluirProdutoServlet?id=${produto.id}" class="button">
						      	<span class="icon">
						      		<i class="fa fa-trash-o"></i>
						      	</span>
					      	</a>					      	
					      </td>
					    </tr>
					</c:forEach>
				</tbody>			  
			</table>
		</div>				
	</body>
</html>