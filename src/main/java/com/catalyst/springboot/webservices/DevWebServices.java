package com.catalyst.springboot.webservices;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.protocol.HTTP;
import org.openqa.selenium.remote.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.component.AuthenticationFacade;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.services.DevService;

@RestController
public class DevWebServices {

	@Autowired
	DevService devService;
	
	/**
	 * @param service the service to set
	 */
	public void setService(DevService service) {
		this.devService = service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Dev addNewUser(@RequestBody Dev dev) {
		String email = dev.getEmail();	
		Dev value = devService.checkUserName(email);	

		if (value != null) {
			return null; 
		} else {
			devService.register(dev);
			return  dev;			
		}
	}
	
	/**
	 * API used to get all users.
	 * 
	 * @return The list of all users in the database.
	 */
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<Dev> getUsers() {		
		return devService.get();
	}
	
	/**
	 * Gets the current users information
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value="/security/current", method = RequestMethod.GET)
	public Dev currentUser(Principal principal) {
		return devService.getEmployeeByUsername(principal.getName());
	}
	
	@RequestMapping(value="/users/validate", method = RequestMethod.POST)
	public void totpAuth(@RequestBody String authCode, HttpServletResponse response, Principal principal){
		devService.totpAuth(authCode, response, principal);
		
	}
}














