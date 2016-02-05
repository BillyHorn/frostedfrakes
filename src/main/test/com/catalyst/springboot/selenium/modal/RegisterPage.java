package com.catalyst.springboot.selenium.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	private static final By _username = By.id("username");
	private static final By _password = By.id("password");
	private static final By _verifyPassword = By.id("verify-password");
	private static final By _registerlink = By.id("register-form-link");
	private static final By _createBtn = By.id("createbtn");
	private static final By _messages = By.id("messages");
	private static final String message_Passwordverification = "Password Verification Failed";
	private static final String message_sucess = "Regestration Sucess";
	private WebDriver _driver;

	public RegisterPage(WebDriver _driver) {
		this._driver = _driver;
	}

	public boolean registerfunctionality(String username, String password, String verifyPassword) {
		System.out.println("hey inside registration page ");
		
		CommonFunctions.populateField(_driver, _username, username);
		CommonFunctions.populateField(_driver, _password, password);
		CommonFunctions.populateField(_driver, _verifyPassword, verifyPassword);
		_driver.findElement(_createBtn).click();

		boolean returnvalue = validateRegister();
		if (returnvalue) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateRegister() {
		
		if (_driver.findElement(_messages).getAttribute(message_sucess).contentEquals("Regestration Sucess")) {
			return true;
		} else {
			return false;
		}

	}

}
