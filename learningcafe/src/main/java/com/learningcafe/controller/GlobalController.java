package com.learningcafe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cafebackend.dao.UserDAO;
import com.cafebackend.dto.User;
import com.learningcafe.model.UserModel;


@ControllerAdvice
public class GlobalController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private HttpSession  session ;
	private UserModel userModel=null;
	
	@ModelAttribute("userModel")
	public  UserModel getUserModel() {
		
		
		if (session. getAttribute("userModel")==null){
			//add the user Model
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			
			User user=userDAO.getByEmail(authentication.getName());
			if(user!=null) {
				userModel=new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				
				if(user.getRole().equals("USER")) {
					userModel.setCart(user.getCart());
				}
				
				session.setAttribute("userModel", userModel); 
				return  userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
		
	}
	
}
