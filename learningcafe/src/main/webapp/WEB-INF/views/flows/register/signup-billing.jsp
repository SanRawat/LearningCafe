<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<hr />

<!-- Page Content -->
<div class="container w3-center w3-margin-right">
	<div
		class="w3-card-4 w3-margin col-md-8 w3-panel w3-border w3-border-blue w3-round-large">


		<header class="w3-container w3-blue w3-text-center">
			<h3>Enter Billing Information</h3>
		</header>

		<div class="w3-container col-md-12 ">
			<div class="w3-row">

				<div class=" col-md-10 col-md-offset-4">

					<div class="w3-margin-top">
						<!-- Form Elements  -->
						<sf:form class="form-horizontal" modelAttribute="address"
							method="post" id="addressForm">

							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="addressLineOne">Address
										Line 1:</label>
									<div class="col-md-8">
										<sf:input type="text" path="addressLineOne"
											id="addressLineOne" placeholder=" Enter Address Line One"
											class="form-control" />

										<sf:errors path="addressLineOne" Class="help-block"
											element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="addressLineTwo">Address
										Line 2:</label>
									<div class="col-md-8">
										<sf:input type="text" path="addressLineTwo"
											id="addressLineTwo" placeholder=" Enter Address Line Two"
											class="form-control" />
										<sf:errors path="addressLineTwo" Class="help-block"
											element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="city">City:</label>
									<div class="col-md-8">
										<sf:input type="text" path="city" id="city"
											placeholder="Enter City" class="form-control" />
										<sf:errors path="city" Class="help-block" element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="state">State:</label>
									<div class="col-md-8">
										<sf:input type="text" path="state" id="state"
											placeholder="Enter State" class="form-control" />
										<sf:errors path="state" Class="help-block" element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4"> Country:</label>
									<div class="col-md-8">
										<sf:input type="text" path="country" class="form-control"
											placeholder="Enter Country!" id="country" />
										<sf:errors path="country" Class="help-block" element="em" />

									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="password">Postal
										Code:</label>
									<div class="col-md-8">
										<sf:input type="text" path="postalCode" id="postalCode"
											placeholder="Enter Postal Code" class="form-control" />

										<sf:errors path="postalCode" Class="help-block" element="em" />
									</div>
								</div>
							</div>

							<div class="form-group w3-right">
								<div class="row w3-center  ">
									<div class="col-md-12">
										<button type="submit" name="_eventId_personal" id="billing"
											class="btn btn-success btn-xs">

											<span><i class="fa fa-chevron-left" aria-hidden="true"></i>Previous
												Personal </span>
										</button>
										&#160;
										<button type="submit" name="_eventId_confirm" id="billing"
											class="btn btn-success btn-xs w3-margin-top-2px">

											Next Confirm<span><i class="fa fa-chevron-right"
												aria-hidden="true"></i></span>
										</button>
									</div>
								</div>
							</div>
						</sf:form>


					</div>

				</div>

			</div>
		</div>


		<footer class="w3-container w3-blue">
			<h5></h5>
		</footer>
	</div>
</div>


<%@include file="../shared/flows-footer.jsp"%>



