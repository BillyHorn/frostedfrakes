package com.catalyst.springboot.selenium.test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.catalyst.springboot.selenium.modal.LoginPage;
import com.catalyst.springboot.selenium.modal.RegisterPage;



public class RegisterTest {
	private WebDriver _driver;
	private RegisterPage _register;
	private LoginPage _login;
	// 
	private static final By _registerlink = By.id("register-form-link");
	@BeforeMethod
	public void setup() {
		System.out.println("_driver");
		File file = new File(
				"C://Users//spallipatt//Desktop//Project2//frostedfrakes//src//main//test//com//catalyst//springboot//selenium//test//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		_driver = new ChromeDriver();
		_driver.get("http://localhost:8080/");
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_driver.manage().window().maximize();

	}
	
	@AfterClass
	public void teardown(){
		_driver.quit();
	}
	
	@Test
	public void invalidRegisterTest() {
		_register = PageFactory.initElements(_driver, RegisterPage.class);
		_driver.findElement(_registerlink).click();
		
		
		
		if(_driver.findElement(By.id("register-form-link")).isDisplayed()){	
			System.out.println("inside if ");
			String username= "testing";
			String password= "test";
			String verifyPassword = "test"; 
			boolean testresult= _register.registerfunctionality(username, password,verifyPassword );
			Assert.assertFalse(testresult);
		}
			
		
		}
	}

