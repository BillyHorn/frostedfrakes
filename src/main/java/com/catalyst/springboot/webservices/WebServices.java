package com.catalyst.springboot.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.services.DevService;

@RestController
public class WebServices {

	@Autowired
	DevService service;
	
	/**
	 * @param service the service to set
	 */
	public void setService(DevService service) {
		this.service = service;
	}

	@RequestMapping(value="/project/create", method=RequestMethod.POST)
	public void createProject(@RequestBody Object project){
		
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<Dev> getUsers() {
//		List<UserTesting> stuff = new ArrayList<UserTesting>();
//		stuff.add(new UserTesting("Person1", 1));
//		stuff.add(new UserTesting("Person2", 2));
//		stuff.add(new UserTesting("Person3", 3));
//		return stuff;
		
		return service.get();
		
	}
	
	
}
