<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Fornecedor</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Cadastro de Fornecedor</h3>
		<br>
		<form:form method="post" commandName="fornecedor">
			<form:input type="hidden" path="idFornecedor"/>
			<div class="form-group">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
				<label>Razao Social:</label>
				<form:input path="razaoSocial" cssClass="form-control" />
				<form:errors path="razaoSocial" />
			</div>
			<div class="form-group">
				<label>CNPJ:</label>
				<form:input path="cnpj" cssClass="form-control" />
				<form:errors path="cnpj" />
			</div>
			
			<div class="form-group">
				<label>Telefone:</label>
				<form:input path="telefone" cssClass="form-control" />
				<form:errors path="telefone" />
			</div>
			
			<div class="form-group">
				<label>Endereço:</label>
				<form:input path="endereco.rua" cssClass="form-control" />
				<form:errors path="endereco.rua" />
			</div>
			
						
			<input type="submit" class="btn btn-primary" value="Salvar">
		</form:form>
	</div>
</body>
</html>