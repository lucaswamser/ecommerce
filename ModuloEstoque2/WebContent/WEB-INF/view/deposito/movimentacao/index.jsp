<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movimentações</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Movimentações</h3>
		<br>
		<!-- Single button -->
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Movimentar <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="Entrada/Nova">Entrada no Estoque</a></li>
				<li><a href="Saida/Nova">Baixa no Estoque</a></li>
			</ul>
		</div>
		<br><br>
		<table class="table">

			<tr>
				<th>Id</th>
				<th>Tipo</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Deposito</th>
				<th>Data</th>
				<th></th>
			</tr>
			<c:forEach items="${movimentacoes}" var="movimento">
				<tr>
					<td>${movimento.idMovimentacao}</td>
					<c:if
						test="${movimento.getClass().name == 'com.up.estoque.domain.MovimentacaoEntrada'}">
						<td>Entrada</td>
					</c:if>
					<c:if
						test="${movimento.getClass().name == 'com.up.estoque.domain.MovimentacaoSaida'}">
						<td>Saida</td>
					</c:if>
					<td>${movimento.produto.nome}</td>
					<td>${movimento.quantidade}</td>
					<td>${movimento.deposito.nome}</td>
					<td>${movimento.date}</td>
					<td><a href="Remover/${movimento.idMovimentacao}">Remover</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>

</html>