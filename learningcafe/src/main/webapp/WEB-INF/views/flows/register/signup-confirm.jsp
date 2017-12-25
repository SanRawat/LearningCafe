
<%@include file="../shared/flows-header.jsp"%>
<hr />

<!-- Page Content -->

<div class="content">

	<div class="container col-md-12 w3-margin">
		<div
			class="row w3-card-4 w3-margin col-md-11  w3-panel w3-border w3-border-green w3-round-large display-inline">

			<div class="col-md-6">
				<header class="w3-container w3-green w3-center">
					<h3>SignUp Personal Details</h3>
				</header>

				<div class="w3-container col-md-12 w3-margin">

					<div class=" col-md-10 col-md-offset-4 w3-center">
						<h4>${registerModel.user.firstName}
							${registerModel.user.lastName}</h4>
						<h5>Email: ${registerModel.user.email}</h5>
						<h5>Contact: ${registerModel.user.contactNumber}</h5>
						<h5>Role: ${registerModel.user.role}</h5>

						<hr />
						<div class="w3-center">


							<a href="${flowExecutionUrl}&_eventId_personal"
								class="btn btn-warning">Edit</a>



						</div>
					</div>


				</div>
			</div>

			<div class="col-md-6">
				<header class="w3-container w3-green w3-center">
					<h3>SignUp Billing Details</h3>
				</header>


				<div class="w3-container col-md-12 w3-margin">

					<div class=" col-md-10 col-md-offset-4">
						 <h4>${registerModel.address.addressLineOne}
							${registerModel.address.addressLineTwo}</h4>
						<h5>City: ${registerModel.address.city}</h5>
						<h5>State: ${registerModel.address.state}</h5>
						<h5>Country: ${registerModel.address.country}</h5>
						<h5>Postal Code: ${registerModel.address.postalCode}</h5>
						<hr /> 
						<div class="w3-center">


							<a href="${flowExecutionUrl}&_eventId_billing"
								class="btn btn-warning">edit</a>



						</div>

					</div>


				</div>

			</div>

			<div class="row container col-md-12 w3-margin w3-center">

				<div class="container col-md-12 col-md-offset-3 w3-margin">
					<div class="w3-center">


						<a href="${flowExecutionUrl}&_eventId_submit"
							class="btn btn-info">Confirm</a>



					</div>
				</div>
			</div>

			<footer class="container w3-green">
				<h5></h5>
			</footer>
		</div>

	</div>

</div>


<%@include file="../shared/flows-footer.jsp"%>