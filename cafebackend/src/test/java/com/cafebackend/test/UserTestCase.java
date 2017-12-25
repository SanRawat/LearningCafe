package com.cafebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cafebackend.dao.UserDAO;
import com.cafebackend.dto.Address;
import com.cafebackend.dto.Cart;
import com.cafebackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.cafebackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*
	 * @Test public void userTest() {
	 * 
	 * user = new User();
	 * 
	 * user.setFirstName("san"); user.setLastName("rawat");
	 * user.setEmail("ersan@gmail.com"); user.setContactNumber("9991332254");
	 * user.setRole("user"); user.setPassword("12345");
	 * 
	 * assertEquals("Something went wrong while inserting a new product!", true,
	 * userDAO.addUser(user));
	 * 
	 * 
	 * address=new Address(); address.setAddressLineOne("abc");
	 * address.setAddressLineTwo("hbashdb"); address.setBilling("bhadh");
	 * address.setCity("sonipat"); address.setCountry("India");
	 * 
	 * address.setPostalCode("131023"); address.setState("Harayana");
	 * address.setShipping(true);
	 * 
	 * address.setUserId(user.getId());
	 * 
	 * assertEquals("Something went wrong while inserting a new product!", true,
	 * userDAO.addAddress(address));
	 * 
	 * cart=new Cart(); cart.setCartLines(3); cart.setGrantTotal(245.0);
	 * cart.setUser(user);
	 * 
	 * assertEquals("Something went wrong while inserting a new product!", true,
	 * userDAO.addCart(cart));
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void userCartTest() {
	 * 
	 * user = new User();
	 * 
	 * user.setFirstName("san"); user.setLastName("rawat");
	 * user.setEmail("ersan@gmail.com"); user.setContactNumber("9991332254");
	 * user.setRole("user"); user.setPassword("12345");
	 * 
	 * if(user.getRole().equals("user")) {
	 * 
	 * cart=new Cart(); cart.setUser(user);
	 * 
	 * user.setCart(cart); }
	 * 
	 * 
	 * assertEquals("Something went wrong while inserting a new product!", true,
	 * userDAO.addUser(user));
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void updateCartTest() {
	 * 
	 * user = userDAO.getByEmail("ersan@gmail.com");
	 * 
	 * cart=user.getCart(); cart.setCartLines(5); cart.setGrantTotal(50000.00);
	 * 
	 * 
	 * assertEquals("Something went wrong while inserting a new product!", true,
	 * userDAO.updateCart(cart));
	 * 
	 * 
	 * 
	 * }
	 */

	/*@Test
	public void getAddressTest() {

		user = new User();

		user.setFirstName("Shiva");
		user.setLastName("GOD");
		user.setEmail("shiva@gmail.com");
		user.setContactNumber("9991332254");
		user.setRole("user");
		user.setPassword("12345");

		assertEquals("Something went wrong while inserting a new product!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("abc");
		address.setAddressLineTwo("hbashdb");
		address.setCity("sonipat");
		address.setCountry("India");

		address.setPostalCode("131023");
		address.setState("Harayana");
		address.setShipping(true);

		address.setUser(user);

		assertEquals("Something went wrong while inserting a new product!", true, userDAO.addAddress(address));

		address = new Address();
		address.setAddressLineOne("billing test");
		address.setAddressLineTwo("billing test line two");
		address.setCity("Geneva");
		address.setCountry("Switzerland");

		address.setPostalCode("88-89-64");
		address.setState("BeautyStree");
		address.setBilling(true);

		address.setUser(user);

		assertEquals("Something went wrong while inserting a new product!", true, userDAO.addAddress(address));

	}
*/

	@Test
	public void getAddressTest() {

		user = userDAO.getByEmail("shiva@gmail.com");

		
		
		assertEquals("Fetch the shipping address of the user!", 1, userDAO.listShippingAddresses(user).size());
		
		assertEquals("Fetch the Billing address of the user!", "Geneva", userDAO.getBillingAddress(user).getCity());
		
	
	}

	
}
