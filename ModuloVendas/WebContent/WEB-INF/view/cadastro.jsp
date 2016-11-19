
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Voltz Store - Entrar</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
<link
	href="${pageContext.request.contextPath}/plugin/signin.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	

<div class="container">

      <form:form method="post" class="form-signin" commandName="usuario">
        <h2 class="form-signin-heading">Cadastre-se</h2>
        <c:if test="${erro != null}">
        <p>${erro}</p>
        </c:if>
        
        <label for="inputEmail" class="sr-only">Nome</label>
        <form:input path="nome"  class="form-control" placeholder="Nome" required="required"/>
		<form:errors path="nome" />
         <label for="inputEmail" class="sr-only">Email</label>
       	<form:input path="email" class="form-control" placeholder="Email" required="required"/>
		<form:errors path="email" />
        <label for="inputEmail" class="sr-only">Usuario</label>
       	<form:input path="credencial.usuario" class="form-control" placeholder="Usuário" required="required"/>
		<form:errors path="credencial.usuario" />
        <label for="inputPassword" class="sr-only" >Senha</label>
       	<form:input path="credencial.senha" type="password" class="form-control" placeholder="Senha" required="required"/>
		<form:errors path="credencial.senha" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastar</button>
      </form:form>

</div> <!-- /container -->

</body>
</html>