<div class="container">
	<div class="content">
		<div class="row">
			<!--   to display side bar -->

			<div class="col-md-3">
				<%@include file="./shared/sidebar.jsp"%>

			</div>

			<!--   to display actual products -->

			<div class="col-md-9 w3-responsive">
				<!-- added breadcrumb component -->
				<div class="row">

					<div class="col-lg-12">
						<c:if test="${userClickAllProducts == true}">
							<script>
								window.categoryId = '';
							</script>
							<ul class="breadcrumb">
								<li><a href="${contextRoot}/home">Home </a></li>
								<li class="active">All Products</li>

							</ul>
						</c:if>
						<c:if test="${userClickCategoryProducts == true}">
							<script>
								window.categoryId = '${category.id}';
							</script>

							<ul class="breadcrumb">
								<li><a href="${contextRoot}/home">Home </a></li>
								<li class="active">Category</li>
								<li class="active">${category.name}</li>
							</ul>
						</c:if>

					</div>

					<!-- to display the actual products -->

					<div style="overflow: auto;" >

						<div class="col-xs-12 ">

							
								<div >
									<table id="productListTable"
										class="table table-striped table-borderd">
										<thead>
											<tr>
												<th></th>
												<th>Name</th>
												<th>Brand</th>
												<th>Price</th>
												<th>Qty. Available</th>
												<th></th>
											</tr>

										</thead>

									</table>

								</div>

							</div>


					</div>






				</div>






			</div>


		</div>


	</div>