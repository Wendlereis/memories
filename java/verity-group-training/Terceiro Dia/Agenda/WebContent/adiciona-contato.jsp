<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adicionar Contatos</title>
		<link rel="stylesheet" href="css/bulma.css">
		<link rel="stylesheet" href="css/estilo.css">
	</head>
	<body>
		<header>
			<h1>Cadastrar Contatos</h1>
		</header>
		
		<div class="column is-6 is-offset-3">
			<form method="post" action="adicionaContato">
				<label class="label">Nome</label>
				<p class="control">
				  <input class="input" type="text" name="nome">
				</p>
				
				<label class="label">E-mail</label>
				<p class="control">
				  <input class="input" type="text" name="email">
				</p>
				
				<label class="label">Endereço</label>
				<p class="control">
				  <input class="input" type="text" name="endereco">
				</p>
				
				<label class="label">Data Nascimento</label>
				<p class="control">
				  <input class="input" type="text" name="datanascimento">
				</p>
				
				<p class="control">
				  <button class="button is-success">Salvar</button>
				</p>
			</form>
		</div>		
	</body>
</html>