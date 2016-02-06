package com.catalyst.springboot.selenium.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private static final By _loginlink = By.id("login-form-link");
	private static final By _registerlink = By.id("register-form-link");
	
	private static final By _username = By.id("inputUsername");
	private static final By _password = By.id("inputPassword");
	private static final By _submitBtn = By.id("submitLogin");
	private static final By _homepagetitle = By.id("Expense Reports");  
	
	private  WebDriver _driver;
	String register="Register";
	String login= "Login";
	
	public LoginPage(WebDriver _driver){
		System.out.println("3");
		this._driver=_driver;
		System.out.println(_driver);
	}
	/**
	 *checking ogin with invalid credencials  
	 */
	public boolean loginTest(String username, String password){
		System.out.println("4");
		System.out.println (_driver + ":" + username  );
		CommonFunctions.populateField(_driver, _username, username);
		CommonFunctions.populateField(_driver, _password, password);
		_driver.findElement(_submitBtn).click();
		
		boolean returnvalue = validateLogin();
		if (returnvalue){
			return true;
		}
		else{
			return false;
		}
		
	}
	public boolean validateLogin(){
		System.out.println("5");
		if(_driver.getTitle().equalsIgnoreCase("Expense Reports")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * click Register link
	 */
	public void clickRegisterpage(){
		CommonFunctions.navigatetoPage(_driver, register, _registerlink);	
		//_driver.switchTo().frame(_driver.findElement(By.id("register-form")));
	}
	/**
	 * click Loginpage
	 */
	public void clickLoginpage(){
		CommonFunctions.navigatetoPage(_driver, login, _loginlink);	
	}
	 
	
}
