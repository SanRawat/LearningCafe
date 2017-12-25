package com.learningcafe.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cafebackend.dao.UserDAO;
import com.cafebackend.dto.Address;
import com.cafebackend.dto.Cart;
import com.cafebackend.dto.User;
import com.learningcafe.model.RegisterModel;

@Component
public class RegisterHandler 	 {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
   	
	@Autowired
	private UserDAO userDAO;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registermodel, User user) {

		registermodel.setUser(user);
	}

	public void addAddress(RegisterModel registermodel, Address address) {

		registermodel.setAddress(address);
	}

	public String validateUser(User user, MessageContext error) {
     
		String transitionValue = "success";
     
		//MessageBuilder mb=new MessageBuilder();
				
		if (!(user.getConfirmPassword().equals(user.getPassword()))) {
			 error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password doesnot Match the confirm password").build());

			
			transitionValue = "failure";
		}

		if (userDAO.getByEmail(user.getEmail()) != null) {

			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email already Exists").build());
			transitionValue = "failure";
		}

		return transitionValue;
	}

	public String saveAll(RegisterModel registermodel) {
		String transitionValue = "success";

		User user = registermodel.getUser();

		if (user.getRole().equals("USER")) {

			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		// before adding the user encode the password
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userDAO.addUser(user);

		Address address = registermodel.getAddress();

		address.setUserId(user.getId());
		address.setBilling(true);

		userDAO.addAddress(address);

		return transitionValue;
	}

}
