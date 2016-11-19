<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Voltz Store - Home</title>
<jsp:include page="/WEB-INF/view/template/scripts.jsp"/>
</head>
<body>

	<jsp:include page="/WEB-INF/view/template/menu.jsp"/>
    <!-- Page Content -->
    <div class="container">
        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1><span class="glyphicon glyphicon-flash"></span> Bem Vindo a Voltz Store!</h1>
            <p>Aqui você compra mais por menos! </p>
            </p>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Produtos</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->
        <div class="row text-center">

			<c:forEach items="${produtos}" var="produto">
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://lorempixel.com/400/250/food" alt="">
                    <div class="caption">
                        <h3>${produto.nome}</h3>
                        <h4>R$ ${produto.preco}</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        <p>
                            <a href="Carrinho/Adicionar/${produto.idProduto}/1" class="btn btn-sm btn-primary">Adicionar ao Carrinho</a>
                             <a href="Produto/${produto.idProduto}" class="btn btn-sm btn-default">Ver</a>
                        </p>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Voltz Store 2016</p>
                </div>
            </div>
        </footer>

    </div>


</body>

</html>
