<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container w3-center w3-margin-right">
	<div class="w3-container">

		<div
			class="w3-card-4 w3-margin col-md-8 w3-panel w3-border w3-border-blue w3-round-large">


			<header class="w3-container w3-blue w3-text-center">
				<h3>Product Management</h3>
			</header>

			<div class="w3-container col-md-12 ">
				<div class="w3-row">

					<c:if test="${not empty message}">
						<div class="alert alert-success alert-dismissable">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Success!</strong> ${message}
						</div>
					</c:if>
					<c:if test="${not empty messageV}">
						<div class="alert alert-danger alert-dismissable">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Failure!</strong> ${messageV}
						</div>
					</c:if>
					<div class=" col-md-10 col-md-offset-4">

						<div class="w3-margin-top">

							<div class=" ">
								<!-- Form Elements  -->
								<sf:form class="form-horizontal" modelAttribute="product"
									action="${contextRoot}/manage/products" method="post"
									enctype="multipart/form-data">


									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4" for="name">Enter
												Product Name:</label>
											<div class="col-md-8">
												<sf:input type="text" path="name" id="name"
													placeholder="Product Name" class="form-control" />
												<em class="w3-text-blue"> Please Enter Product Name!</em>
												<sf:errors path="name" Class="help-block" element="em" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4" for="brand">Enter
												Brand Name:</label>
											<div class="col-md-8">
												<sf:input type="text" path="brand" id="brand"
													placeholder="Brand Name" class="form-control" />
												<em class="w3-text-blue"> Please Enter Brand Name!</em>
												<sf:errors path="brand" Class="help-block" element="em" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4">Description:</label>
											<div class="col-md-8">
												<sf:textarea path="description" class="form-control"
													placeholder="Enter your description here!" />
												<sf:errors path="description" Class="help-block"
													element="em" />

											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4">Unit Price:</label>
											<div class="col-md-8">
												<sf:input type="number" path="unitPrice"
													class="form-control" placeholder="Enter Unit Price" />
												<sf:errors path="unitPrice" cssClass="help-block"
													element="em" />

											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4">Quantity:</label>
											<div class="col-md-8">
												<sf:input type="number" path="quantity" class="form-control"
													placeholder="Enter Quantity" />
												<sf:errors path="quantity" cssClass="help-block"
													element="em" />

											</div>
										</div>
									</div>


									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4">Upload an
												Image:</label>
											<div class="col-md-8">
												<sf:input type="file" path="file" class="form-control" />
												<sf:errors path="file" cssClass="help-block" element="em" />
											</div>
										</div>
									</div>


									<div class="form-group">
										<div class="row text-right">
											<label class="control-label col-md-4">Category:</label>
											<div class="col-md-8">
												<sf:select path="categoryId" items="${categories}"
													itemLabel="name" itemValue="id" class="form-control" />

												<div class="text-right">
													<br />
													<sf:hidden path="id" />
													<sf:hidden path="code" />
													<sf:hidden path="supplierId" />
													<sf:hidden path="active" />
													<c:if test="${product.id==0}">
														<button type="button" class="btn btn-warning btn-xs"
															data-toggle="modal" data-target="#myCategoryModal">Add
															New Category</button>
													</c:if>
												</div>
											</div>
										</div>

									</div>
									<div class="form-group">
										<div class="row text-right">
											<div class="col-md-offset-4 col-md-8">
												<input type="submit" name="submit" id="submit"
													value="Submit" class="btn btn-success btn-xs" />

											</div>
										</div>
									</div>

								</sf:form>
							</div>

						</div>

					</div>

				</div>
			</div>

			<footer class="w3-container w3-blue">
				<h5></h5>
			</footer>
		</div>
	</div>
<div class="container w3-center w3-margin-right">
	<div
		class="w3-card-4 w3-margin col-md-11  w3-panel w3-border w3-border-green w3-round-large">


		<header class="w3-container w3-green w3-text-center">
			<h3>Availaable Products</h3>
		</header>

		<div class=" w3-responsive col-md-12 ">

			<div class=" col-md-10 col-md-offset-4 ">



				<!--  Product table for admin-->

				<div style="overflow: auto;" class="">
					<table id="adminProductsTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>


					</table>



				</div>

			</div>

		</div>
		<footer class="w3-container w3-green">
			<h5></h5>
		</footer>
	</div>
</div>
	<div class="modal fade " id="myCategoryModal" role="dialog">

		<div class="modal-dialog" role="document">

			<div class="modal-content w3-blue">

				<div class="modal-header">
				<h4 class="modal-title">Add a New Category</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					
				</div>
				<div class="modal-body">
					<!-- Form Elements  -->
					<sf:form class="form-horizontal" modelAttribute="category"
						action="${contextRoot}/manage/category" method="post" id="categoryForm">

						<div class="form-group">
							<div class="row text-right">
								<label class="control-label col-md-4" for="category_name">Enter
									New Category:</label>
								<div class="col-md-8">
									<sf:input type="text" path="name" id="category_name"
										placeholder="New Category Name" class="form-control"
										/>
									<em class="w3-text-blue"> Please Enter Category Name!</em>
									<sf:errors path="name" Class="help-block" element="em" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row text-right">
								<label class="control-label col-md-4"> Category
									Description:</label>
								<div class="col-md-8">
									<sf:textarea rows="5" cols="" path="description"
										class="form-control"
										placeholder="Enter your description here!"
										id="category_description" />
									<sf:errors path="description" Class="help-block" element="em" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row text-right">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" name="submit" id="submit" value="Submit"
										class="btn btn-success btn-xs" />

								</div>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

