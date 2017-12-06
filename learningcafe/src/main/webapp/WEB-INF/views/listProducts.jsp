<div class="container">
	<div class="content">
		<div class="row">
			<!--   to display side bar -->

			<div class="col-md-3">
				<%@include file="./shared/sidebar.jsp"%>

			</div>

			<!--   to display products -->

			<div class="col-md-9">
				<!-- added breadcrumb component -->
				<div class="row">

					<div class="col-lg-12">
						<c:if test="${userClickAllProducts == true}">
							<ul class="breadcrumb">
								<li><a href="${contextRoot}/home">Home </a></li>
								<li class="active"> All Products</li>

							</ul>
						</c:if>
						<c:if test="${userClickCategoryProducts == true}">
						
							<ul class="breadcrumb">
								<li><a href="${contextRoot}/home">Home </a></li>
								<li class="active">Category</li>
								<li class="active">${category.name}</li>
							</ul>
						</c:if>

					</div>


				</div>


			</div>


		</div>
	</div>
</div>

