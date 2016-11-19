<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deposito - Movimentação de Saida</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Movimentação de Saida</h3>
		<br>
		<form:form method="post" commandName="movimentacaoSaida">
			<form:input type="hidden" path="idMovimentacao"/>
			<div class="form-group">
				<label>Produto:</label>
				<form:select path="produto" items="${produtos}" cssClass="form-control" itemValue="idProduto" />
				<form:errors path="produto" />
			</div>
			
			<div class="form-group">
				<label>Quantidade:</label>
				<form:input path="quantidade" cssClass="form-control" />
				<form:errors path="quantidade" />
			</div>
			
			<div class="form-group">
				<label>Deposito:</label>
				<form:select path="deposito" items="${depositos}" cssClass="form-control" itemValue="idDeposito" />
				<form:errors path="deposito" />
			</div>
			
			<input type="submit" class="btn btn-primary" value="Salvar">
		</form:form>
	</div>
</body>
</html>