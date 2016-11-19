<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fornecedores</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp"/>
	<div class="container">
		<h3>Fornecedores</h3>
		<p><a href="Adicionar">Adicionar</a></p>
		<table class="table">

			<tr>
				<th>Id</th>
				<th>Razao Social</th>
				<th>Telefone</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${fornecedores}" var="fornecedor">
				<tr>
					<td>${fornecedor.idFornecedor}</td>
					<td>${fornecedor.razaoSocial}</td>
					<td>${fornecedor.telefone}</td>
					<td><a href="Atualizar/${fornecedor.idFornecedor}">Atualizar</a></td>
					<td><a href="Remover/${fornecedor.idFornecedor}">Remover</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>

</html>