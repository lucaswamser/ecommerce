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
<div class="error">
        <h3 class="font-bold">Seu pagamento foi recusado..</h3>

        <div class="error-desc">
          Sentimentos muito, mas a operadora não aprovou o pagamento, tente novamente!
            <div>
                <a class=" login-detail-panel-button btn" href=" ${pageContext.request.contextPath}/Venda/CheckOut">
                        <i class="fa fa-arrow-left"></i>
                       Ir Para o CheckOut e tentar novamente                
                    </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>