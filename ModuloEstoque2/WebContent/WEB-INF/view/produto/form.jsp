<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Produto</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Cadastro de Produto</h3>
		<br>
		<form:form method="post" commandName="produto">
			<form:input type="hidden" path="idProduto"/>
			<div class="form-group">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
				<label>Peso:</label>
				<form:input path="peso" cssClass="form-control" />
				<form:errors path="peso" />
			</div>
			<div class="form-group">
				<label>Preço:</label>
				<form:input path="preco" cssClass="form-control" />
				<form:errors path="preco" />
			</div>
						
			<input type="submit" class="btn btn-primary" value="Salvar">
		</form:form>
	</div>
</body>
</html>