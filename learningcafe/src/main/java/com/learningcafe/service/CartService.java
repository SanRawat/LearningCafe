package com.learningcafe.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafebackend.dao.CartLineDAO;
import com.cafebackend.dto.Cart;
import com.cafebackend.dto.CartLine;
import com.cafebackend.dto.Product;
import com.learningcafe.model.UserModel;

@Service("cartService")
public class CartService {
	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession session;

	// return cart of the user has logged in
	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public List<CartLine> getCartLines() {
		Cart cart = this.getCart();

		return cartLineDAO.list(cart.getId());

	}

	public String updateCartLine(int cartLineId, int count) {

		CartLine cartLine = cartLineDAO.get(cartLineId);
		if (cartLine == null) {
			return "result=error";
		} else {
			Product product = cartLine.getProduct();

			double oldTotal = cartLine.getTotal();
			if (product.getQuantity() <= count) {
				count = product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);

			cartLineDAO.update(cartLine);

			Cart cart = this.getCart();

			cart.setGrantTotal(cart.getGrantTotal() - oldTotal + cartLine.getTotal());

			cartLineDAO.updateCart(cart);

			return "result=updated";
		}

	}

}
