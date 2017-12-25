
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}|LearningCafe</title>
<script>
	window.menu = '${titile}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- w3.css -->
<link href="${css}/w3.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 -->
<!-- fontawesome -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Jquery DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.css" />



<!-- Custom styles for this template -->
<link href="${css }/myapp.css" rel="stylesheet">

</head>


<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">LearningCafe</a>
				</div>
			</div>

		</nav>

		<!-- Page Content -->
		<div class="container">
			<c:if test="${not empty logout}">
				<div class="alert alert-success">${logout}</div>


			</c:if>
			<c:if test="${not empty message}">
				<div class="alert alert-danger">${message}</div>


			</c:if>
			<div
				class="w3-card-4 w3-margin w3-center col-md-8 w3-panel w3-border w3-border-blue w3-round-large ">


				<header class="w3-container w3-blue">
					<h3>Login</h3>
				</header>

				<div class="w3-margin-top ">

					<div class=" ">
						<!-- Form Elements  -->
						<form class="form-horizontal" action="${contextRoot}/login"
							method="post" id="loginForm">


							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="username">UserName:
									</label>
									<div class="col-md-8">
										<input type="text" name="email" id="email"
											placeholder="Enter email" class="form-control" /> <em
											class="w3-text-red"></em>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="password">Password:</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password"
											placeholder="Password" class="form-control" /> <em
											class="w3-text-red"></em>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="row text-right">
									<div class="col-md-offset-4 col-md-8">
										<input type="submit" name="submit" id="submit" value="Login"
											class="btn btn-success btn-xs" /> <input type="hidden"
											name="${_csrf.parameterName}" value="${_csrf.token}" />
									</div>
								</div>
							</div>

						</form>
					</div>
				</div>

			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Jquery core JavaScript -->
		<script src="${js}/jquery-3.2.1.min.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>



		<!-- Custom coded JavaScript -->
		<script src="${js}/custom.js"></script>

	</div>
</body>

</html>
