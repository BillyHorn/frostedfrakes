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
	 * @param authenticationFacade the authenticationFacade to set
	 */
	public void setAuthenticationFacade(AuthenticationFacade authenticationFacade) {
		this.authenticationFacade = authenticationFacade;
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
		System.out.println(totpCode+ "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  Authy");
		Authentication authentication = authenticationFacade.getAuthentication();
		if (authentication == null){
			System.out.println("I am a stupid little gnoll");
		}
		System.out.println(authentication.getName());
		System.out.println(authentication);
		System.out.println(authentication.getDetails().toString());
        Dev dev = devdao.getDevByUsername(authentication.getName());
        System.out.println("After getDev");
		System.out.println(dev.getAuthCode() + " Their auth code !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if(dev.getAuthCode().equals(totpCode)){
			System.out.println("AUTHORIZED");
		}
		else{
			System.out.println("FAILURE");
		}
		
		return dev;
	}
	
	
}












