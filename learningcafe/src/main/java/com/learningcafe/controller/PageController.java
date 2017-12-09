package com.learningcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cafebackend.dao.CategoryDAO;
import com.cafebackend.dao.ProductDAO;
import com.cafebackend.dto.Category;
import com.cafebackend.dto.Product;
import com.learningcafe.exception.ProductNotFoundException;


@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
	mv.addObject("categories", categoryDAO.list());

		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// methods to load all the products based on category

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	// methods to load all the products based on category

		/*
		 * Viewing a single product
		 * */
	
	
	@RequestMapping(value = {"/show/category/{id}/products"}) // do not use ${}
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}	
	
	// show single product
	
	@RequestMapping(value = {"/show/{id}/product"}) // do not use ${}
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException{		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		
		
		 Product product = productDAO.get(id);
		 if(product == null) throw new ProductNotFoundException();
		//updating the views count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		
		mv.addObject("title",product.getName());
		
		// passing the single product object
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct",true);
		return mv;				
	}	
	
	
	

}
