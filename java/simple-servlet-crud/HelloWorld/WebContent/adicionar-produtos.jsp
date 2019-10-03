<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastrar Produto</title>
		<link rel="stylesheet" href="css/bulma.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/eb229d8c54.css">
		<link rel="stylesheet" href="css/estilo.css">
	</head>
	<body>
		<header>
			<a href="home.jsp">	
      			<i class="return-button fa fa-angle-left fa-5x" aria-hidden="true"></i>
	      	</a>
			<h1>Cadastrar Produtos</h1>
		</header>
		
		<div class="column is-6 is-offset-3">
			<form method="post" action="adicionaProduto">
				<label class="label">Nome</label>	
				<p class="control">
				  <input class="input" type="text" name="nome">
				</p>
				
				<label class="label">Data Compra</label>
				<p class="control">
				  <input class="input" type="text" name="datacompra">
				</p>
				
				<label class="label">Descricao</label>
				<p class="control">
				  <input class="input" type="text" name="descricao">
				</p>
				
				<label class="label">Quantidade Estoque</label>
				<p class="control">
				  <input class="input" type="text" name="quantidade">
				</p>
				
				<label class="label">Preco</label>
				<p class="control">
				  <input class="input" type="text" name="preco">
				</p>			
				
				<p class="control">
				  <button class="button">Salvar</button>
				</p>
			</form>
		</div>		
	</body>
</html>