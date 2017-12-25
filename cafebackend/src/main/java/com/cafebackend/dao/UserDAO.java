package com.cafebackend.dao;

import java.util.List;

import com.cafebackend.dto.Address;
import com.cafebackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User  user);

	boolean addAddress(Address address);
	
	
}
