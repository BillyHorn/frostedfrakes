package com.catalyst.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(){
		System.out.println("request mapping to login");
		return "/views/login.html";	
	}
	
/*	@RequestMapping(value ="/loginPage", method = RequestMethod.POST)
	public String loginRequest(@RequestParam("username") String username, @RequestParam("password"), String password){
		System.out.println("request mapping to login");
		return "/views/partials/login.html";
	}*/
}
