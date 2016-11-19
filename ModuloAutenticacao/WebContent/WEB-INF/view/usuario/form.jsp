<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários - Cadastrar Usuário</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Cadastro de Usuário</h3>
		<br>
		<form:form method="post" commandName="usuario">
			<div class="form-group">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
				<label>Email:</label>
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" />
			</div>
			<div class="form-group">
				<label>Perfil</label>
				<form:select path="perfil" cssClass="form-control">
				<form:option value="administrador">Administrador</form:option>
				<form:option value="usuario">Usuario</form:option>
				</form:select>
				<form:errors path="perfil" />
			</div>
			<div class="form-group">
				<label>Usuario</label>
				<form:input path="credencial.usuario" cssClass="form-control" />
				<form:errors path="credencial.usuario" />
			</div>
			
			<div class="form-group">
				<label>Senha:</label>
				<form:input type="password" path="credencial.senha"
					cssClass="form-control" />
				<form:errors path="credencial.senha" />
			</div>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</form:form>
	</div>
</body>
</html>