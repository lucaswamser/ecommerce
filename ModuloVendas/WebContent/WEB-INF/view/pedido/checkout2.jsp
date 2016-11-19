<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Venda - Check Out</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
<link
	href="${pageContext.request.contextPath}/plugin/steeps.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">

		<h3>Check Out</h3>
		
		
<div class="stepwizard">
    <div class="stepwizard-row">
		<div class="stepwizard-step"> 
			<button type="button" class="btn btn-primary btn-circle">1</button>
			<p>Informações da Entrega</p>
		</div>
		<div class="stepwizard-step"> 
			<button type="button" class="btn btn-default btn-circle">2</button>
			<p>Pagamento</p>
		</div>
		<div class="stepwizard-step"> 
			<button type="button" class="btn btn-default btn-circle">3</button>
			<p>Conclusão da Compra</p>
		</div>
</div>
		
		<br>
		<form:form method="post" commandName="destinatario">
		
			<div class="form-group">
				<label>Nome do Destinatario:</label>
				<form:input path="nome"/>
				<form:errors path="nome" />
			</div>
			
			<div class="form-group">
				<label>CEP:</label>
				<form:input path="cep"/>
				<form:errors path="cep" />
			</div>
			
			<div class="form-group">
				<label>Rua:</label>
				<form:input path="rua"/>
				<form:errors path="rua" />
			</div>
			
			<div class="form-group">
				<label>Numero:</label>
				<form:input path="numero"/>
				<form:errors path="numero" />
			</div>
			<div class="form-group">
				<label>Estado:</label>
				<form:input path="estado"/>
				<form:errors path="estado" />
			</div>			
			<div class="form-group">
				<label>Cidade:</label>
				<form:input path="cidade"/>
				<form:errors path="cidade" />
			</div>
			
			<input type="submit" class="btn btn-primary" value="Pagamento >">
		</form:form>
	</div>
</body>
</html>