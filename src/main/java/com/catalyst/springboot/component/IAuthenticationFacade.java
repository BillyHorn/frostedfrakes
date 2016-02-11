package com.catalyst.springboot.component;

import org.springframework.security.core.Authentication;

/**
 * interface for class to access spring security to get currently logged in user
 * @author mKness
 *
 */
public interface IAuthenticationFacade {
	Authentication getAuthentication();

}
