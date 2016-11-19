<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp"/>
	<div class="container">
		<h3>Produtos</h3>
		<p><a href="Adicionar">Adicionar</a></p>
		<table class="table">

			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Peso</th>
				<th>Preço</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.idProduto}</td>
					<td>${produto.nome}</td>
					<td>${produto.peso}</td>
					<td>${produto.preco}</td>
					<td><a href="Atualizar/${produto.idProduto}">Atualizar</a></td>
					<td><a href="Remover/${produto.idProduto}">Remover</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>

</html>