<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">
		<h3>Minhas Compras</h3>
		<table class="table">
			<tr>
				<th>Data</th>
				<th>Status</th>
				<th>Total</th>
			</tr>
			<c:forEach items="${compras}" var="compra">
				<tr>
					<td>${compra.date}</td>
					<td>${compra.status}</td>
					<td>${compra.total}</td>
				</tr>

			</c:forEach>
		</table>

		<br>

		
	</div>
</body>

</html>