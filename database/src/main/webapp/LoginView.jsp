<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Perfumaria</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/prefixfree.min.js"></script>

</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Perfumaria<br>
			<span><strong>Online</strong></span>
			
		</div>
		<p>Usuário: Matheus <br> Senha: 147258</p>
	</div>
	<br>
	<div class="login">
		<form>
		
					<input type="text" placeholder="Usuário" name="usuario" required="required"><br>
					<input type="password" placeholder="Senha" name="senha" required="required"><br>

			<button name="operacao" value="entrar">Entrar</button>
		</form>
		<h2>${msg}</h2>
	</div>
</body>

</html>