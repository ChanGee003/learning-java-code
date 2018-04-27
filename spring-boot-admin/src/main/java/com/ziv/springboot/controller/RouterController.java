package com.ziv.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {

	@RequestMapping("/organizational_manage")
	public ModelAndView organizational_manage(ModelAndView modelAndView){
		modelAndView.setViewName("user/manager");
		return modelAndView;
	}
	
	

	
	@RequestMapping("/business_manage")
	public ModelAndView business_manage(ModelAndView modelAndView){
		modelAndView.setViewName("business/manager");
		return modelAndView;
	}
	
	
	
}
