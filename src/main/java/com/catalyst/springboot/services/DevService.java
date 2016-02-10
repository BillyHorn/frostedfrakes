package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.component.AuthenticationFacade;
import com.catalyst.springboot.dao.DevDao;
import com.catalyst.springboot.entities.Dev;

/**
 * Holds services relevant to devs 
 * @author kmatthiesen
 *
 */
@Service
public class DevService {
	
	@Autowired 
	private DevDao devdao;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;

	/**
	 * @param devdao the devdao to set
	 */
	public void setDevdao(DevDao devdao) {
		this.devdao = devdao;
	}
	
	
	/**
	 * Gets all devs from the database
	 * 
	 * @return The list of all devs
	 */
	public List<Dev> get(){
		return devdao.get();
	}
	
	/**
	 * Get Dev by username
	 * 
	 * @param username the username to get
	 * @return 
	 */
	public Dev getEmployeeByUsername(String username) {
		return devdao.getDevByUsername(username);

	}


	public Dev checkUserName(String email) {
		return devdao.getDevByUsername(email);
	}


	public void register(Dev dev) {
		// TODO Auto-generated method stub
		devdao.register(dev);
	}
	
	
	/**
	 * @param dev
	 * @return
	 * @author blarsen
	 */
	public Dev loginTotp(Dev dev){
		return devdao.loginTotp(dev);
	}
	
	public Dev totpAuth(String totpCode){
		Authentication authentication = authenticationFacade.getAuthentication();
        Dev dev = devdao.getDevByUsername(authentication.getName());
		
		if(dev.getAuthCode().equals(totpCode)){
			System.out.println("AUTHORIZED");
		}
		else{
			System.out.println("FAILURE");
		}
		
		return dev;
	}
	
	
}












