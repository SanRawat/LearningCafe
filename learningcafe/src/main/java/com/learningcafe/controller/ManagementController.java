package com.learningcafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cafebackend.dao.CategoryDAO;
import com.cafebackend.dao.ProductDAO;
import com.cafebackend.dto.Category;
import com.cafebackend.dto.Product;
import com.learningcafe.utility.FileUploadUtility;
import com.learningcafe.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public ModelAndView showProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "ManageProducts");
		mv.addObject("userClickManageProducts", true);

		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else  if (operation.equals("category")) {
				mv.addObject("message", "New Category Submitted Successfully!");
			}
		}
		return mv;
	}

	// handling product submission
	@RequestMapping(value = { "/products" }, method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		// check if there are any error

		if (mProduct.getId() == 0) 
		{
			new ProductValidator().validate(mProduct, results);
		}
		if (!mProduct.getFile().getOriginalFilename().equals("")) 
		{
			new ProductValidator().validate(mProduct, results);
		}
		
		if (results.hasErrors()) {

			model.addAttribute("title", "ManageProducts");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("messageV", "Validation Failed for product Submission");
			return "page";
		}

		logger.info(mProduct.toString());
		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {
			productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}

	// returning categories for all the request mapping

	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	}

	@RequestMapping(value = { "/product/{id}/activation" }, method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {

		Product product = productDAO.get(id);

		boolean isActive = product.isActive();
		product.setActive(!product.isActive());

		productDAO.update(product);

		return (isActive) ? "You have deactivated the product with id: " + product.getId() + " Successfully!"
				: "You have activated the product with id: " + product.getId() + " Successfully!";
	}

	@RequestMapping(value = { "/{id}/product" }, method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "ManageProducts");
		mv.addObject("userClickManageProducts", true);

		// fetch products from database
		Product nProduct = productDAO.get(id);
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		// set product in html using spring
		mv.addObject("product", nProduct);

		return mv;
	}
	
	
	@RequestMapping(value = { "/category" }, method = RequestMethod.POST)
	public String addNewCategory( @ModelAttribute Category category) {
		
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
		
		}
	
	
	@ModelAttribute("category")
	public Category getCategory() {

		return new Category();
	}

}
