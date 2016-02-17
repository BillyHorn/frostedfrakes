package com.catalyst.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.services.DevService;

@Component
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	@Autowired
	private DevService devService;
	
	/**
	 * @param devService the devService to set
	 */
	public void setDevService(DevService devService) {
		this.devService = devService;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		Dev dev = devService.getEmployeeByUsername(authentication.getName());
		dev.setLoginTime((long) 0);
		dev.setIsvalid(false);
		devService.loginTotp(dev);
        super.onLogoutSuccess(request, response, authentication);
    }

}
