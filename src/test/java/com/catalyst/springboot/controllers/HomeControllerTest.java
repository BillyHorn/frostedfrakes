package com.catalyst.springboot.controllers;



import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.security.Principal;

import static org.mockito.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.mail.EmailHandler;
import com.catalyst.springboot.services.DevService;

public class HomeControllerTest {
	private HomeController homeController;
	private EmailHandler emailHandler;
	private DevService devService;
	private Dev testDev;
	
	@Before
	public void setup(){
		homeController = new HomeController();
		emailHandler = mock(EmailHandler.class);
		devService = mock(DevService.class);
		homeController.setEmailHandler(emailHandler);
		homeController.setDevService(devService);
		testDev = mock(Dev.class);
	}
	
	
	
	@Test
	public void indexTest(){
		String url = "/views/index.html";
		
		homeController.index();
		
		assertEquals("/views/index.html", url);
	}
	
	@Test
	public void loginPageTest(){
		String url = "/views/login.html";
		
		homeController.loginPage();
		
		assertEquals("/views/login.html", url);
	}
	
	@Test
	public void authPageTestNewCode(){
		Principal principal = mock(Principal.class);
		when(principal.getName()).thenReturn("anyString()");
		when(devService.getEmployeeByUsername(anyString())).thenReturn(testDev);
		
		when(testDev.getLoginTime()).thenReturn(System.currentTimeMillis()-500000);
		
		homeController.authPage(principal);
		
		verify(devService).loginTotp(testDev);
		
		assertEquals("/views/totpAuth.html", "/views/totpAuth.html");
		
	}
	
	@Test
	public void authPageTestValid(){
		Principal principal = mock(Principal.class);
		when(principal.getName()).thenReturn("anyString()");
		when(devService.getEmployeeByUsername(anyString())).thenReturn(testDev);
		
		when(testDev.getLoginTime()).thenReturn(System.currentTimeMillis());
		
		String expected = homeController.authPage(principal);
		
		
		
		assertEquals("/views/totpAuth.html", expected);
		
	}
	
}














