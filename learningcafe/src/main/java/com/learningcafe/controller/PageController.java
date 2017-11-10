package com.learningcafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = {"/tutorials"})
	public ModelAndView tutorials() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Tutorials");
		mv.addObject("userClickTutorials", true);
		return mv;
	}
	
	  
}
