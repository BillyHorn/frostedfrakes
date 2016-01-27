package com.catalyst.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/views/index.html";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "/views/partials/home.html";
	}
	
}
