
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark w3-cyan fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}">LearningCAFE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item" id="home"><a class="nav-link"
					href="${contextRoot}">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>

				<li class="nav-item" id="listProducts"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Products</a></li>
					
				<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item" id="manageProducts"><a class="nav-link"
						href="${contextRoot}/manage/products">Manage Products</a></li>
				</security:authorize>
				
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
			</ul>

			<ul class=" nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="register"><a class="nav-link"
						href="${contextRoot}/register">Sign Up</a></li>

					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>
			</ul>
			<security:authorize access="isAuthenticated()">
				<div class="dropdown">
					<button type="button" class="btn btn-info dropdown-toggle"
						data-toggle="dropdown">${userModel.fullName}</button>
					<div class="dropdown-menu">
						<security:authorize access="hasAuthority('USER')">
							<a href="${contextRoot}/cart/show"> <span
								class="glyphicon glyphicon-shopping-cart w3-margin"><i
									class="fa fa-cart-arrow-down" aria-hidden="true"></i></span><span
								class="badge badge-light">${userModel.cart.cartLines}</span> -
								&#8377; ${userModel.cart.grantTotal}
								<div class="dropdown-divider"></div>
							</a>
						</security:authorize>
						<a href="${contextRoot}/perform-logout" class="w3-margin">Logout</a>
					</div>

				</div>
			</security:authorize>
		</div>
	</div>
</nav>

<script>
window.userRole='${userModel.role}';

</script>