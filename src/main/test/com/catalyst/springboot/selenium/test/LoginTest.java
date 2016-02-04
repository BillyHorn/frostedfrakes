package com.catalyst.springboot.selenium.test;

import java.io.File;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.catalyst.springboot.selenium.modal.InputbeanList;
import com.catalyst.springboot.selenium.modal.LoginPage;
import com.catalyst.springboot.selenium.modal.XMLReader;

public class LoginTest {

	private WebDriver _driver = null;
	private LoginPage _login;

	@BeforeClass
	public void setup() {

		File file = new File(
				"C://Users//spallipatt//Desktop//frostedfrakes//src//main//test//com//catalyst//springboot//selenium//test//chromedriver.exe");
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
	public void invalidLoginTest() throws InterruptedException {
		// to get current method name
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		XMLReader xmldata = new XMLReader();
		xmldata.readingxml(methodName);

		Collection<InputbeanList> input = XMLReader.XMLdata.values();
		for (InputbeanList indata : input) {
			try {
				_login = PageFactory.initElements(_driver, LoginPage.class);
				String username = indata.getUsername();
				String password = indata.getPassword();
				boolean loginResult = _login.loginTest(username, password);
				Assert.assertFalse(loginResult);
			} catch (Exception error) {
				System.out.println("error" + error);
			}
		}
	}

	@Test
	public void validLoginTest() {
		
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		XMLReader xmldata = new XMLReader();
		
		xmldata.readingxml(methodName);
		
		Collection<InputbeanList> input = XMLReader.XMLdata.values();
		for (InputbeanList indata : input) {
			System.out.println("inside forloop ");
				_login = PageFactory.initElements(_driver, LoginPage.class);
				String username = indata.getUsername();
				String password = indata.getPassword();
				boolean loginResult = _login.loginTest(username, password);
				Assert.assertTrue(loginResult);
			
		}
	}
}
