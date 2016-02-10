package com.catalyst.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalyst.springboot.component.AuthenticationFacade;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.mail.EmailHandler;
import com.catalyst.springboot.services.DevService;

@Controller
public class HomeController {
	
	@Autowired 
	private EmailHandler emailHandler;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@Autowired
	private DevService devService;
	
	/**
	 * @param authenticationFacade the authenticationFacade to set
	 */
	public void setAuthenticationFacade(AuthenticationFacade authenticationFacade) {
		this.authenticationFacade = authenticationFacade;
	}

	/**
	 * @param devService the devService to set
	 */
	public void setDevService(DevService devService) {
		this.devService = devService;
	}

	/**
	 * @param emailHandler the emailHandler to set
	 */
	public void setEmailHandler(EmailHandler emailHandler) {
		this.emailHandler = emailHandler;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/views/index.html";
	}
	
	/*@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "/views/partials/home.html";
	}*/
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(){
		System.out.println("request mapping to login");
		return "/views/login.html";	
	}
	
	@RequestMapping(value = "/totpAuthentication", method = RequestMethod.GET)
	public String authPage(){
		Authentication authentication = authenticationFacade.getAuthentication();
        Dev dev = devService.getEmployeeByUsername(authentication.getName());
		dev.setLoginTime(System.currentTimeMillis());
		dev.setAuthCode(emailHandler.totpAuthentication());
		devService.loginTotp(dev);
		
		return "/views/totpAuth.html";
	}
	
	
	
/*	@RequestMapping(value ="/loginPage", method = RequestMethod.POST)
	public String loginRequest(@RequestParam("username") String username, @RequestParam("password"), String password){
		System.out.println("request mapping to login");
		return "/views/partials/login.html";
	}*/
}
