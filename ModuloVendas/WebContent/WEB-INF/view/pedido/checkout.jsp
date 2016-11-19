<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Venda - Check Out</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp" />
<link href="${pageContext.request.contextPath}/plugin/steeps.css"
	rel="stylesheet">
</head>
<body class="main">
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div class="container">

		<div class="row marketing">
			<div class="col-lg-6">
				<h4>
					<b>Check Out</b>
				</h4>
				<hr />

				<form:form class="form-horizontal" commandName="pedido">


					<p>
						<b>Detalhes Do Frete</b>
					</p>

					<div class="form-group">
						<div class="col-sm-6">
							<form:input type="text" placeholder="Nome" class="form-control"
								path="frete.destinatario.nome" required="required"/>
						</div>
						<div class="col-sm-6">
							<form:input type="text" placeholder="Telefone"
								class="form-control" path="frete.destinatario.telefone" required="required" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-8">
							<form:input type="text" placeholder="Endereço de Entrega"
								class="form-control" path="frete.destinatario.rua" required="required" />
						</div>
						<div class="col-sm-2">
							<form:input type="text" placeholder="Numero" class="form-control"
								path="frete.destinatario.numero"  required="required"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-4">
							<form:input type="text" placeholder="Estado" class="form-control"
								path="frete.destinatario.estado" required="required" />
						</div>
						<div class="col-sm-4">
							<form:input type="text" placeholder="Cidade" class="form-control"
								path="frete.destinatario.cidade" required="required"/>
						</div>

						<div class="col-sm-4">
							<form:input type="text" placeholder="CEP" class="form-control"
								path="frete.destinatario.cep" required="required" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6">
							<form:input type="text" placeholder="CPF / CNPJ" class="form-control" path="frete.destinatario.cpfCnpj" required="required" />
						</div>
					</div>
					

					<div class="panel panel-default">
						<div class="panel-heading">Pagamento</div>

						<div class="panel-body">
							<div class="form-group">
								<label for="cardNumber">Numero Do Cartão</label>
								<div class="input-group">
									<form:input data-mask="(00) 0000-0000" data-mask-selectonfocus="true" pattern="[0-9]{13,16}" type="text" class="form-control" id="cardNumber"
										placeholder="XXXX XXXX XXXX XXXX"
										path="pagamento.cartaoDeCredito.numero" required="required"/>
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label for="expityMonth">Data de Expiração</label> <br />

										<div class="col-xs-6 col-lg-6 pl-ziro">
											<form:input type="number" class="form-control" id="expityMonth"
												placeholder="MM"
												path="pagamento.cartaoDeCredito.dataVencimentoMes" required="required" />
										</div>
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<form:input type="number" class="form-control" id="expityYear"
												placeholder="YY"
												path="pagamento.cartaoDeCredito.dataVencimentoAno" required="required"/>
										</div>
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label for="cvCode">CVV</label>
										<form:input type="password" class="form-control" id="cvCode"
											placeholder="XXX" path="pagamento.cartaoDeCredito.ccv" required="required"/>
									</div>
								</div>
							</div>
						</div>

					</div>
					<input type="submit" class="btn btn-success btn-lg btn-block"
						value="Confirmar Pedido" />
				</form:form>
			</div>


			<div class="col-lg-6">

				<div class="panel panel-default">
					<div class="panel-heading">Resumo</div>
					<div class="panel-body">
						<table class="table">

							<tr>
								<th>Produto</th>
								<th>Quantidade</th>
								<th>Total</th>
							</tr>
							<c:forEach items="${carrinho.produtos}" var="item">
								<tr>
									<td>${item.nome}</td>
									<td>${item.quantidade}</td>
									<td>R$ <fmt:formatNumber
											value="${item.precoUnitario * item.quantidade}" /></td>
								</tr>

							</c:forEach>
						</table>
						<br>
						<h6>
							Frete: R$
							<fmt:formatNumber value="${carrinho.frete.valorTotal}" />
						</h6>
						<h4>
							Total: R$
							<fmt:formatNumber value="${carrinho.total}" />
						</h4>
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>