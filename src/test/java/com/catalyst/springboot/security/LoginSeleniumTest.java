package com.catalyst.springboot.security;

import org.aspectj.lang.annotation.After;
import org.testng.annotations.Test;

import com.catalyst.springboot.selenium.LoginPage;
import com.catalyst.springboot.selenium.LoginPage;
import com.catalyst.springboot.selenium.PageObjectTest;

import junit.framework.Assert;

public class LoginSeleniumTest extends PageObjectTest{
	
/*	@Test
	public void LoginPageTest(){
		LoginPage loginPage = new LoginPage(getDriver());
		
		String expectedUrl = "http://localhost:8080/loginPage";
		String actualUrl = loginPage.getUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	public void LoginSuccess(){
		LoginPage loginPage = new LoginPage(getDriver());
		
		String expectedUrl = "http://localhost:8080/#/home";
		String actualUrl = loginPage.loginSuccessCheck();
		
		Assert.assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	public void LoginFailure(){
		LoginPage loginPage = new LoginPage(getDriver());
		
		String expectedUrl = "http://localhost:8080/loginPage";
		String actualUrl = loginPage.loginFailureCheck();
		
		Assert.assertEquals(expectedUrl, actualUrl);
	}*/
}
