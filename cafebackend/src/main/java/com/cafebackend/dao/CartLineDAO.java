package com.cafebackend.dao;

import java.util.List;

import com.cafebackend.dto.Cart;
import com.cafebackend.dto.CartLine;

public interface CartLineDAO {
	
	public CartLine get(int id);
	public boolean add(CartLine cartline);
	public boolean update(CartLine cartline);
	public boolean delete(CartLine cartline);
	public List<CartLine> list(int cartId);
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	boolean updateCart(Cart cart);
}
