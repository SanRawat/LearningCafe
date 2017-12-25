$(document).ready(function() {
	// solving the active menu problem

	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

});

// execute the code where we have this table 'listProducttable'

$(document)
		.ready(
				function() {

					// to tackle csrf tokens

					var token = $('meta[name="_csrf"]').attr('content');
					var header = $('meta[name="_csrf_header"]').attr('content');

					if (token.length > 0 && header.length > 0) {
						// set the token header for ajax requests

						$(document).ajaxSend(function(e, xhr, options) {

							xhr.setRequestHeader(header, token);

						})
					}

					var jsonURL = '';
					if (window.categoryId == '') {
						jsonURL = window.contextRoot
								+ '/json/data/all/products';
					} else {
						jsonURL = window.contextRoot + '/json/data/category/'
								+ window.categoryId + '/products';
					}

					$('#productListTable')
							.DataTable(
									{
										lengthMenu : [
												[ 3, 5, 10, -1 ],
												[ '3 Records', '5 Records',
														'10 Records', 'All' ] ],
										pageLength : 5,

										// ... skipped other options ...
										ajax : {
											url : jsonURL,
											dataSrc : ''
										},
										columns : [
												{
													data : "code",
													mRender : function(data,
															type, row) {

														return '<img height="70px" src="'
																+ window.contextRoot
																+ '/resources/images/'
																+ data
																+ '.jpg"  />';
													}

												},
												{
													width : "40%",
													data : "name"
												},
												{
													data : "brand"
												},
												{
													data : "unitPrice",
													mRender : function(data,
															type, row) {

														return '&#8377; '
																+ data
													}

												},
												{
													width : "20%",
													data : "quantity",
													mRender : function(data,
															type, row) {

														if (data < 1) {

															return '<span style="color:red">Out Of Stock</span>';
														}

														return data;
													}

												},
												{
													width : "25%",
													data : "id",
													mRender : function(data,
															type, row) {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/show/'
																+ data
																+ '/product" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"><i class="fa fa-eye" aria-hidden="true"></i></span></a>&#160;';
														if (row.quantity < 1) {

															if (userRole == 'ADMIN') {

																str += '<a href="'
																		+ window.contextRoot
																		+ '/manage/'
																		+ data
																		+ '/product" class="btn btn-warning">';
																str += '<span><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span></a>';
															} else {

																str += '<a href="javascript:void(0);" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></span></a>';

															}

														} else {

															if (userRole == 'ADMIN') {

																str += '<a href="'
																		+ window.contextRoot
																		+ '/manage/'
																		+ data
																		+ '/product" class="btn btn-warning">';
																str += '<span><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span></a>';

															} else {
																str += '<a href="'
																		+ window.contextRoot
																		+ '/cart/add/'
																		+ data
																		+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></span></a>';

															}

														}
														return str
													}

												}

										]

									});
				});

// dismissing product submission alert after 3 sec

$(document)
		.ready(
				function() {

					var $alert = $('.alert');
					if ($alert.length) {
						setTimeout(function() {

							$alert.fadeOut('slow');

						}, 3000)
					}

					// --------------------
					//
					// Table for admin
					// /
					// ---------------------

					var jsonURL = window.contextRoot
							+ '/json/data/admin/all/products';

					$('#adminProductsTable')
							.dataTable(
									{
										lengthMenu : [
												[ 30, 50, 100, -1 ],
												[ '30 Records', '50 Records',
														'100 Records', 'All' ] ],
										pageLength : 5,

										// ... skipped other options ...
										ajax : {
											url : jsonURL,
											dataSrc : ''
										},
										columns : [
												{
													data : "id",
												},
												{
													data : "code",
													bsortable : false,
													mRender : function(data,
															type, row) {

														return '<img class="adminDataTableImg" src="'
																+ window.contextRoot
																+ '/resources/images/'
																+ data
																+ '.jpg"/>';
													}

												},
												{
													width : "40%",
													data : "name"
												},
												{
													data : "brand"
												},
												{
													width : "",
													data : "quantity",
													mRender : function(data,
															type, row) {

														if (data < 1) {
															return '<span style="color:red">Out Of Stock</span>';
														}

														return data;
													}

												},

												{
													data : "unitPrice",
													mRender : function(data,
															type, row) {

														return '&#8377; '
																+ data
													}

												},

												{
													data : "active",
													bsortable : false,
													mRender : function(data,
															type, row) {
														var str = '';
														str += '<label class="switch">';
														if (data) {
															str += '<input type="checkbox" checked="checked" value="'
																	+ row.id
																	+ '">';
														} else {
															str += '<input type="checkbox"  value="'
																	+ row.id
																	+ '">';

														}
														str += '<div class="slider round"></div></label>';
														return str;
													}

												},
												{
													width : "10%",
													data : "id",
													bsortable : false,
													mRender : function(data,
															type, row) {
														var str = '';

														str += '<a href="'
																+ window.contextRoot
																+ '/manage/'
																+ data
																+ '/product" class="btn btn-warning">';
														str += '<span><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span></a>';

														return str
													}

												}

										],
										// --------------------toogle
										// switch-----------//

										initComplete : function() {
											var api = this.api();
											api
													.$(
															'.switch input[type="checkbox"]')
													.on(
															'change',
															function() {

																var checkbox = $(this);
																var checked = checkbox
																		.prop('checked');
																var dMsg = (checked) ? '<p class="w3-green">You want to activate the product?</p>'
																		: '<p class="w3-red">You want to deactivate the product?</p>'

																var value = checkbox
																		.prop('value');
																var title = '<span style="background-color: blue;">Product Activation and Deactivation</div>';
																bootbox
																		.confirm({

																			size : "large",
																			title : title,
																			message : dMsg,
																			buttons : {
																				confirm : {
																					label : 'Update',
																					className : 'btn-success'
																				},
																				cancel : {
																					label : 'Cancel',
																					className : 'btn-danger'
																				}
																			},
																			callback : function(
																					confirmed) {

																				if (confirmed) {
																					console
																							.log(value)

																					var activationURL = window.contextRoot
																							+ '/manage/product/'
																							+ value
																							+ '/activation';
																					$
																							.post(
																									activationURL,
																									function(
																											data) {

																										bootbox
																												.alert({
																													closeButton : false,
																													size : "medium",
																													title : "Information",
																													message : data
																												});
																									});

																				} else {
																					checkbox
																							.prop(
																									"checked",
																									!checked)
																				}

																			}
																		})
															})
										}

									});

					// validaion for category

					var $categoryForm = $('#categoryForm');

					$('#categoryForm')
							.validate(
									{

										rules : {
											name : {
												required : true,
												minlength : 4
											},
											description : {
												required : true,
												minlength : 4
											}
										},

										messages : {
											name : {
												required : 'Please Enter a Category Name!',
												minlength : "Required length for Name is min. 4."
											},
											description : {
												required : 'Please Provide description for the category!',
												minlength : "Required length for Description is min. 10."
											}
										},

										errorElement : 'em',
										errorPlacement : function(error,
												element) {
											// add the class of help-block
											error.addClass('help-block');
											// add the error after the input
											// element
											error.insertAfter(element);

										}
									})

					$('#loginForm')
							.validate(
									{

										rules : {
											email : {
												required : true,
												minlength : 4
											},
											password : {
												required : true,
												minlength : 4
											}
										},

										messages : {
											email : {
												required : 'Please Provide Your Email!',
												minlength : "Required length for email is min. 4."
											},
											password : {
												required : 'Please Provide Password!',
												minlength : "Required length for Description is min.4"
											}
										},

										errorElement : 'em',
										errorPlacement : function(error,
												element) {
											// add the class of help-block
											error.addClass('help-block');
											// add the error after the input
											// element
											error.insertAfter(element);

										}

									})

					// click event of refresh cart button

					$('button[name="refreshCart"]')
							.click(
									function() {

										// fetch the cart line item

										var cartLineId = $(this).attr('value');
										var countElement = $('#count_'
												+ cartLineId);

										var originalCount = countElement
												.attr('value');

										var currentCount = countElement.val();

										// refresh work only when count change
										if (currentCount !== originalCount) {
											console.log('currentCount'
													+ currentCount);
											console.log('originalCount'
													+ originalCount);
											if (currentCount < 1
													|| currentCount > 3) {

												countElement.val(originalCount);

												bootbox
														.alert({

															size : 'medium',
															title : 'error',
															message : 'Product count should be in the range 1-3'

														});
											} else {
												var updateUrl = window.contextRoot
														+ '/cart/'
														+ cartLineId
														+ '/update?count='
														+ currentCount;
												// forward it to the controller
												console.log(updateUrl);
												window.location.href = updateUrl;
											}
										}

									});

				});