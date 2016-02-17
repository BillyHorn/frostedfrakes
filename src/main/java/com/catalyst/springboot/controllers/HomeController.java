package com.catalyst.springboot.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catalyst.springboot.component.AuthenticationFacade;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.mail.EmailHandler;
import com.catalyst.springboot.services.DevService;

@Controller
public class HomeController {
	
	@Autowired 
	private EmailHandler emailHandler;
	
	@Autowired
	private DevService devService;

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
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(){
		return "/views/login.html";	
	}
	
	@RequestMapping(value = "/totpAuthentication", method = RequestMethod.GET)
	public String authPage(Principal principal){
        Dev dev = devService.getEmployeeByUsername(principal.getName());
        if ((System.currentTimeMillis() - dev.getLoginTime()) > 200000){
        	dev.setLoginTime(System.currentTimeMillis());
    		dev.setAuthCode(emailHandler.totpAuthentication());
    		devService.loginTotp(dev);
        }
		return "/views/totpAuth.html";
	}
}
