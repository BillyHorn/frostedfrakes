package com.catalyst.springboot.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * implmentation of the interface to access spring security to get the currently logged in user
 * @author mKness
 *
 */

@Component 
public class AuthenticationFacade implements IAuthenticationFacade{

	//@Override
	public Authentication getAuthentication() {

		return SecurityContextHolder.getContext().getAuthentication();
	}

}
 