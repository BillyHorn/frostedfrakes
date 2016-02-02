package com.catalyst.springboot.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created a super class that refrences the id's of the login.html fields
 * performs two sepearate checks, login success and failure
 * it sends the login information and clicks the submit button and pulls 
 * the url from the page
 * @author blarsen
 *
 */

public class LoginPage extends PageObject{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		_url = "localhost:8080/loginPage";
		goTo(_url);
	}
	
	private static final By username = By.id("inputUsername");
	private static final By password = By.id("inputPassword");
	private static final By submit = By.id("submitLogin");
	
	/**
	 * sends valid login credentials and compares urls
	 * @return
	 */
	
	public String loginSuccessCheck(){
		sendKeys(username, "brad");
		sendKeys(password, "root");
		
		click(submit);
		sleep(2000);
		return getUrl();
	}
	
	/**
	 * sends invalid login credentials and compares urls
	 * @return
	 */
	
	public String loginFailureCheck(){
		sendKeys(username, "brudson");
		sendKeys(password, "rooted");
		
		click(submit);
		sleep(2000);
		return getUrl();
	}
}
