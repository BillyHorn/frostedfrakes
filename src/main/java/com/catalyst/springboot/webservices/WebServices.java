package com.catalyst.springboot.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Dev;


@RestController
public class WebServices {

	@Autowired
	private ProjectDao dao;

	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(ProjectDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Dev addNewUser(@RequestBody Dev dev) {
		String email = dev.getEmail();	
		Dev value = dao.checkUserName(email);	

		if (value != null) {			 
			String message= "User Name Exists";
			System.out.println("----------->webservice message "+message);
			return null; 
		} else {
			dao.register(dev);
			String message= "Regestration Sucess";
			System.out.println("--------->webservice "+message);
			return  dev;			
		}
	}
}
