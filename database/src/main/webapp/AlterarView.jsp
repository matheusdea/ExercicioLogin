<!DOCTYPE html>
<%@page import="database.Perfume"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Perfumaria Online</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/principal.css">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>


<body>
	<div id="wrapper">
		<div class="overlay"></div>

		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand"><a href="#"> Usuário: ${usuario}</a>
				</li>
				<li><a href="perfume">Listar</a></li>
				<li><a href="consulta">Consultar</a></li>
				<li><a href="operacoes">Cadastar</a></li>
				<li><a href="alterar">Alterar</a></li>
				<li><a href="logout"> Logout</a></li>
			</ul>
		</nav>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>
			<div class="container">
				<div class="row">
					<div class="col-lg-9 col-lg-offset-1">
						<h1>Lista de Perfumes Cadastrados</h1>
						<hr>
						<b>${msg}</b>
						<hr>
						<table class="table table-hover">
							<tr>
								<th>Id</th>
								<th>Nome</th>
								<th>Fabricante</th>
								<th>Preço</th>
								<th>Ações</th>
							</tr>
							<%
      //Obtém a lista de alunos criada pelo controlador.
  	List<Perfume> perfumes =
      (List<Perfume>) request.getAttribute("lista-perfumes");

    if (perfumes != null && !perfumes.isEmpty()) {
      for (Perfume a : perfumes) {
    %>
							<tr>
								<td><%=a.getId()%></td>
								<td><%=a.getNome()%></td>
								<td><%=a.getFabricante()%></td>
								<td><%=a.getPreco()%></td>
								<td><a href="perfume?operacao=excluir&id=<%=a.getId()%>">Excluir</a></td>
							</tr>
							<%
      }
    }
    %>
						</table>
						
						<h1>Alterar</h1>
                        <hr>
						<form>
							<div class="form-group">
								<label>Id:</label> <input type="text" name="id"
									class="form-control" placeholder="Id" required="required">
							</div>
							
							<div class="form-group">
								<label>Nome:</label> <input type="text" name="nome"
									class="form-control" placeholder="Nome" required="required">
							</div>
							
							<div class="form-group">
								<label>Fabricante:</label> <input type="text" name="fabricante"
									class="form-control" placeholder="Fabricante" required="required">
							</div>
							
							<div class="form-group">
								<label>Preco:</label> <input type="text" name="preco"
									class="form-control" placeholder="Preço" required="required">
							</div>
							<button type="submit" name="operacao" value="alterar"
								class="btn btn-default">Alterar</button>
							</form>
						
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
	<script src="js/principal.js">

</script>
</body>
</html>

</body>

</html>