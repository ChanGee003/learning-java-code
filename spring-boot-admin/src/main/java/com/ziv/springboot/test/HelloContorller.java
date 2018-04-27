package com.ziv.springboot.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloContorller {

	private static Logger logger = Logger.getLogger(HelloContorller.class);
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		logger.info("Hello");
		model.addAttribute("name",name);
		return "hello";
	}
}
