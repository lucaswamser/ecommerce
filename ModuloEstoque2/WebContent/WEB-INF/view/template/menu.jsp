<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Estoque</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/Produto/">Produtos</a></li>
				<li><a href="${pageContext.request.contextPath}/Fornecedor/">Fornecedores</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Estoque <span class="caret"></span></a>

					<ul class="dropdown-menu">
					<li><a
							href="${pageContext.request.contextPath}/Deposito/">Contagem de Estoque</a></li>
						<li role="separator" class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/Deposito/Movimentacao/">Movimentações</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Deposito/Movimentacao/Saida/Nova">Baixa
								do Estoque</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Deposito/Movimentacao/Entrada/Nova">Entrada
								do Estoque</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${usuarioLogado.nome} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/Logout">Sair</a></li>
					</ul></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>