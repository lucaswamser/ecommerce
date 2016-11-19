
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

      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <c:if test="${erro != null}">
        <p>${erro}</p>
        </c:if>
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input type="text" id="inputEmail" class="form-control" name="usuario" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" id="inputPassword" name="senha" class="form-control" placeholder="Senha" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      </form>

</div> <!-- /container -->

</body>
</html>