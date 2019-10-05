<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Contato</title>
		<link rel="stylesheet" href="css/bulma.css">
		<link rel="stylesheet" href="css/estilo.css">		
	</head>
	<body>
		<header>
			<h1>Listar Contatos</h1>
		</header>
		
		<div class="column is-6 is-offset-3 is-mobile">
			<jsp:useBean id="dao" class="br.com.verity.agenda.dao.ContatoDAO"></jsp:useBean>
			
			<table class="table is-striped">
				<thead>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Endereço</th>
					<th>Data de Nascimento</th>
				</thead>
				<tbody>
					<c:forEach var="contato" items="${dao.lista}">
						<tr>
							<td>${contato.nome}</td>
							<td>
								<c:if test="${not empty contato.email}">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:if>
								<c:if test="${empty contato.email}">
									E-mail não informado
								</c:if>
							</td>
							<td>${contato.endereco}</td>
							<td>
								<fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy"/>
							</td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
		</div>
	</body>
</html>