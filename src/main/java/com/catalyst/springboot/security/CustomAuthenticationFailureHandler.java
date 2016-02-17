package com.catalyst.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * A custom AuthenticationFailureHandler to handle failed login attempts.
 * 
 * @author kmatthiesen
 *
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

 /**
  * Sends a 403 error response when a user fails to login.
  * 
  * @param request The request
  * @param response The response
  * @param exception The exception
  */
public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
   AuthenticationException exception) throws IOException, ServletException {
  
  response.sendError(403);
 
 }

}