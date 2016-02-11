package com.catalyst.springboot.services;

import java.security.Principal;
import java.util.List;

import org.openqa.selenium.remote.http.HttpResponse;
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
		List<Dev> devs = devdao.getDevByCode(totpCode);
		if (!devs.isEmpty()){
			Dev dev = devs.get(0);
			System.out.println(dev.getAuthCode() + " Their auth code !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			if(dev.getAuthCode().equals(totpCode) && (System.currentTimeMillis() - dev.getLoginTime() <= 200000)){
				System.out.println("I passed the test!!!!!!!!!!!!!!!!!!!!!!!!");
				return dev;
			}
			else{
				System.out.println("I failed the test!!!!!!!!!!!!!!!!!!!!!!!!");
				return null;
			}
		}
		
		return null;
		
		
		
		
		
	}
	
	
}












