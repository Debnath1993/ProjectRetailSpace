<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/rs/images" />
<spring:url var="customcs" value="/rs/css" />
<spring:url var="custumjs" value="/rs/js" />
<spring:url var="jquery" value="/rs/vendor/jquery" />
<spring:url var="bootcs" value="/rs/vendor/bootstrap/css" />
<spring:url var="bootjs" value="/rs/vendor/bootstrap/js" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Online shopping website">
<meta name="author" content="Debabrato Ghosh">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${bootcs}/bootstrap.min.css" rel="stylesheet">


<link href="${customcs}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap DataTable -->
<link href="${customcs}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${customcs}/myStyle.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/nav.jsp"%>

		<div class="content">
			<!-- Home Content -->
			<c:if test="${ClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Contact Us Content -->
			<c:if test="${ClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- About Us Content -->
			<c:if test="${ClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts == true  or  userClickCategoryProducts == true }">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<c:if test="${userClickSingleProduct == true  }">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<c:if test="${userClickManageProduct == true  }">
				<%@include file="manageProduct.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowCart == true  }">
				<%@include file="cart.jsp"%>
			</c:if>

		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- JQuery core JavaScript -->
		<script src="${jquery}/jquery.min.js"></script>
		
		<!--  JQuery Validate Plugin -->
		<script src="${custumjs}/jquery.validate.js"></script>
		
		<!-- Bootstrap core JavaScript -->
		<script src="${bootjs}/bootstrap.min.js"></script>

		<!-- Bootstrap DataTable Plugin -->
		<script src="${custumjs}/jquery.dataTables.js"></script>

		<script src="${custumjs}/dataTables.bootstrap.js"></script>
		
		<script src="${custumjs}/bootbox.min.js"></script>

		<!-- Custom JavaScript -->
		<script src="${custumjs}/myscript.js"></script>

	</div>
</body>

</html>
