package com.ziv.wx.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServerController {

	@RequestMapping("/")
	@ResponseBody
	public String def(){
		return "Server OK.";
		
	}
	
	
}
