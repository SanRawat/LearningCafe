$(function() {
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

	var $table = $('productListTable');
	if ($table.length) {
		alert('iam here in the table');
	}

});



// execute the code where we have this table 'listProducttable'



$(document)
		.ready(
				function() {
					
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
													width: "40%", 
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
													width: "30%", 
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
															str += '<a href="javascript:void(0);" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></span></a>';

														} else {
															str += '<a href="'
																	+ window.contextRoot
																	+ '/cart/add/'
																	+ data
																	+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></span></a>';

														}
														return str
													}

												}

										]

									});
				});
