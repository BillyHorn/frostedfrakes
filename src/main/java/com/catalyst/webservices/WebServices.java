package com.catalyst.webservices;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServices {

	
	@RequestMapping(value="/project/create", method=RequestMethod.POST)
	public void createProject(@RequestBody Project project){
		projectService.add(project);
	}
}
