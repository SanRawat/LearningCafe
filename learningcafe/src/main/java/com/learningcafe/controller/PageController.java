package com.learningcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cafebackend.dao.CategoryDAO;
import com.cafebackend.dto.Category;


@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories", categoryDao.list());

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
		mv.addObject("categories", categoryDao.list());
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	// methods to load all the products based on category

		@RequestMapping(value = { "/show/category/{id}/products" })
		public ModelAndView showCategoryProducts(@PathVariable("id") int id ) {
			ModelAndView mv = new ModelAndView("page");
			// category dao to fetch a single category
			Category category;
			
			category= categoryDao.get(id);	
			// passing all the products
			mv.addObject("categories", categoryDao.list());
			mv.addObject("title", category.getName());
			// passing the single category object
			mv.addObject("category", category);
			mv.addObject("userClickCategoryProducts", true);
			return mv;
		}

}