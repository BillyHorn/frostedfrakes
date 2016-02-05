package com.catalyst.springboot.selenium.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.catalyst.springboot.selenium.modal.AdminPage;
import com.catalyst.springboot.selenium.modal.CommonFunctions;
import com.catalyst.springboot.selenium.modal.LoginPage;

public class AdminTest {

	private WebDriver _driver = null;
	private AdminPage _admin;
	private LoginPage _login;
	private LoginTest _loginTest;
	private static final By _projName = By.name("project-name");

	@BeforeClass
	public void setup() {

		File file = new File(
				"C://Users//spallipatt//Desktop//frostedfrakes//src//main//test//com//catalyst//springboot//selenium//test//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		_driver = new ChromeDriver();
		_driver.get("http://localhost:8080/");
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_driver.manage().window().maximize();

		_loginTest = PageFactory.initElements(_driver, LoginTest.class);
		_loginTest.validLoginTest();
	}

	@Test
	public void CreateProjectvalidation() {
		_admin.clickCreate();
		if (_driver.findElement(_projName).isDisplayed()) {
			String TestProject= "testProject" ;
			CommonFunctions.populateField(_driver, _projName, TestProject);
			
			
		}
	}
}