<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<hr />

<!-- Page Content -->
<div class="container w3-center w3-margin-right">

	<div
		class="w3-card-4 w3-margin col-md-8 w3-panel w3-border w3-border-blue w3-round-large">


		<header class="w3-container w3-blue w3-text-center">
			<h3>New User Registeration</h3>
		</header>

		<div class="w3-container col-md-12 w3-margin-bottom ">
			<div class="w3-row">

				<div class=" col-md-10 col-md-offset-4 w3-margin">

					<div class="w3-margin-top">
						<!-- Form Elements  -->
						<sf:form class="form-horizontal" modelAttribute="user"
							method="post" id="registerForm">

							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="first_name">Enter
										First Name:</label>
									<div class="col-md-8">
										<sf:input type="text" path="firstName" id="first_name"
											placeholder="First Name" class="form-control" />

										<sf:errors path="firstName" Class="help-block" element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="last_name">Enter
										Last Name:</label>
									<div class="col-md-8">
										<sf:input type="text" path="lastName" id="last_name"
											placeholder="Last Name" class="form-control" />
										<sf:errors path="firstName" Class="help-block" element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="contactNumber">Contact
										Number :</label>
									<div class="col-md-8">
										<sf:input type="text" path="contactNumber" id="contactNumber"
											placeholder="Contact Number" class="form-control" />

										<sf:errors path="contactNumber" Class="help-block"
											element="em" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4"> Email:</label>
									<div class="col-md-8">
										<sf:input type="text" path="email" class="form-control"
											placeholder="Enter your email here!" id="email" />
										<sf:errors path="email" Class="help-block" element="em" />

									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="password">Enter
										Password:</label>
									<div class="col-md-8">
										<sf:input type="password" path="password" id="password "
											placeholder="Password" class="form-control" />

										<sf:errors path="password" Class="help-block" element="em" />
									</div>
								</div>
							</div>
						 <div class="form-group">
					<div class="row text-right">
						<label class="control-label col-md-4" for="password">Re-Enter
							Password:</label>
						<div class="col-md-8">
							<sf:input type="text" path="confirmPassword" id="password "
								placeholder="Confirm Password" class="form-control" />
							<em class="w3-text-blue"> Please Re-Enter Password !</em>
							<sf:errors path="confirmPassword" Class="help-block" element="em" />
						</div>
					</div>
				</div> 
							<div class="form-group">
								<div class="row text-right">
									<label class="control-label col-md-4" for="role">Select
										Role:</label>
									<div class="col-md-8">
										<label class="radio-inline"> <sf:radiobutton
												path="role" value="SUPPLIER" />Supplier
										</label> <label class="radio-inline"> <sf:radiobutton
												path="role" value="USER" checked="checked" />User
										</label>

									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row  w3-right ">
									<div class="col-md-offset-4 col-md-8">
										<button type="submit" name="_eventId_billing" id="personal"
											class="btn btn-success btn-xs">

											Next Billing <span><i class="fa fa-chevron-right"
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



