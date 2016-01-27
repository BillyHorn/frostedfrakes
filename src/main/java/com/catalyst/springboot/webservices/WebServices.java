package com.catalyst.springboot.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.UserTesting;

@RestController
public class WebServices {

	
//	@RequestMapping(value="/project/create", method=RequestMethod.POST)
//	public void createProject(@RequestBody Project project){
//		projectService.add(project);
//	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<UserTesting> getUsers() {
		List<UserTesting> stuff = new ArrayList<UserTesting>();
		stuff.add(new UserTesting("Person1", 1));
		stuff.add(new UserTesting("Person2", 2));
		stuff.add(new UserTesting("Person3", 3));
		return stuff;
	}
}
