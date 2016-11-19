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
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Voltz
				Store</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/Carrinho/">
						<i class="fa fa-shopping-cart" aria-hidden="true"></i> Carrinho de
						Compras <span class="badge">0</span>
				</a></li>
				<c:if test="${usuarioLogado != null }">
				<li><a href="${pageContext.request.contextPath}/Compras/"><i
						class="fa fa-shopping-bag" aria-hidden="true"></i> Minhas Compras</a></li>
				</c:if>
			</ul>
			<c:if test="${usuarioLogado != null }">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${usuarioLogado.nome} <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/Logout">Sair</a></li>
						</ul></li>
				</ul>
			</c:if>

			<c:if test="${usuarioLogado == null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/Login">	 Logar-se 	</a></li>
				<li><a href="${pageContext.request.contextPath}/Cadastro/">	 Cadastre-se 	</a></li>
				</ul>
			</c:if>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>