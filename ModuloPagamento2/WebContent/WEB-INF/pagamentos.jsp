<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagamentos</title>
</head>
<body>

	<table class="table">

			<tr>
				<th>Valor</th>
				<th>Aceito</th>
				<th>Data</th>
			</tr>
			<c:forEach items="${pagamentos}" var="pagamento">
				<tr>
					<td>${pagamento.valorPagamento}</td>
					<td>${pagamento.aceito}</td>
					<td>${pagamento.data}</td>
				</tr>

			</c:forEach>
		</table>
</body>
</html>