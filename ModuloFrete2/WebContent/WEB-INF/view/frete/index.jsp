<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fretes</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp"/>
	<div class="container">
		<h3>Fretes Contratados</h3>
		<table class="table">

			<tr>
				<th>Id</th>
				<th>Status</th>
				<th>Valor Total</th>
				<th>Data Contratação</th>
				<th></th>
			</tr>
			<c:forEach items="${fretes}" var="frete">
				<tr>
					<td>${frete.idFrete}</td>
					<td>${frete.status}</td>
					<td>R$ <fmt:formatNumber value="${frete.valorTotal}" /></td>
					<td>${frete.data}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>

</html>