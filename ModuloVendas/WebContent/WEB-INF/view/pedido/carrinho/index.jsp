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
		<h3>Carrinho De Compras</h3>
		<table class="table">

			<tr>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Preço Unitario</th>
				<th>Total</th>
			</tr>
			<c:forEach items="${carrinho.produtos}" var="item">
				<tr>
					<td>${item.nome}</td>
					<td>
					<a class="btn btn-primary btn-sm" href="Adicionar/${item.idProduto}/1">+</a>
						${item.quantidade}
					 <a class="btn btn-primary btn-sm" href="Remover/${item.idProduto}/1">-</a>
					</td>
					<td>R$ <fmt:formatNumber value="${item.precoUnitario}" /></td>
					<td>R$ <fmt:formatNumber value="${item.precoUnitario * item.quantidade}" /></td>
				</tr>

			</c:forEach>
		</table>
	<c:if test="${totalProdutos > 0}">
		<br>
		<h4><b>Total Produtos:</b> R$ <fmt:formatNumber value="${totalProdutos}" />
		
		<c:if test="${carrinho.frete.destinatario == null}">
			<div class="row">
				<div class="col-md-5">
					<form method="post">
						  <h4><b>Total Frete:</b></h4> <input type="text" name="cep" required="required"/> 
							 <input type="submit"  value="Calcular" class="btn btn-success">
					</form>
				</div>
			</div>
		</c:if>
		
		
		<c:if test="${carrinho.frete.destinatario != null}">
		<h4><b>Total Frete:</b> R$ <fmt:formatNumber value="${carrinho.frete.valorTotal}" /> - CEP ${carrinho.frete.destinatario.cep}
		<a href="LimparDestinatario"> (Mudar) </a></h4>
		</c:if>
		<h3>Total R$<fmt:formatNumber value="${carrinho.total}" /></h3>
		<c:if test="${carrinho.frete.destinatario != null}">
		<br> <a href="../Venda/CheckOut" class="btn btn-success"> Continuar > </a>
		</c:if>
		</c:if>
	</div>
</body>

</html>