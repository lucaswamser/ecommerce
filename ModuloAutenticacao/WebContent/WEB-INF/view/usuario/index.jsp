<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Usuarios</h3>
		<p>
			<a href="${pageContext.request.contextPath}/Usuario/Cadastro">Cadastrar</a>
		</p>
		<br>
		<table class="table">

			<tr>
				<th>Id</th>
				<th>Login</th>
				<th>Nome</th>
				<th>Perfil</th>
				<th></th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.idUsuario}</td>
					<td>${usuario.credencial.usuario}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.perfil}</td>
					<td><a href="${pageContext.request.contextPath}/Usuario/Excluir/${usuario.idUsuario}">Excluir</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>