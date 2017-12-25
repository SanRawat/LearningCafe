package com.cafebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cafebackend.dao.CartLineDAO;
import com.cafebackend.dao.ProductDAO;
import com.cafebackend.dao.UserDAO;
import com.cafebackend.dto.Cart;
import com.cafebackend.dto.CartLine;
import com.cafebackend.dto.Product;
import com.cafebackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	private Product product;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.cafebackend");
		context.refresh();
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void addCartLine() {

		// 1. fetch user
		user = userDAO.getByEmail("sandy@gmail.com");
		// 2. fetch cart
		cart = user.getCart();

		// 3. fetch the product

		product = productDAO.get(6);

		// 4. create a new cartLine

		cartLine = new CartLine();

		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);

		assertEquals("Something went wrong while inserting a cartline!", true, cartLineDAO.add(cartLine));

		// update the cart

		cart.setGrantTotal(cart.getGrantTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);

		
		assertEquals("Something went wrong while updating a cartline!", true, cartLineDAO.updateCart(cart));

	
	}


}
