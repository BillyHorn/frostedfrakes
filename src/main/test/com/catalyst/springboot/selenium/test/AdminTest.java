package com.catalyst.springboot.selenium.test;

import java.io.File;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.catalyst.springboot.selenium.modal.AdminPage;
import com.catalyst.springboot.selenium.modal.CommonFunctions;
import com.catalyst.springboot.selenium.modal.LoginPage;
import com.catalyst.springboot.selenium.modal.XMLReader;

import com.catalyst.springboot.selenium.modal.InputbeanList;

public class AdminTest {
	static Logger slf4jLogger = LoggerFactory.getLogger(AdminTest.class);
	private WebDriver _driver;
	private AdminPage _admin;
	private LoginPage _login;
	private LoginTest _loginTestA;
	private static final By _projName = By.name("project-name"); // .//*[@id='create-project']/label[1]/input
	private static final By _cretaeProj = By.xpath("html/body/div[1]/div/div[2]/ul[1]/li[3]/a");

	@BeforeMethod
	public void setup() {

		String classname = this.getClass().getSimpleName();
		XMLReader xmldata = new XMLReader();
		xmldata.readingxml(classname);

		 File file = new File(
				  "C://Users//spallipatt//Desktop//frostedfrakes//src//main//test//com//catalyst//springboot//selenium//test//chromedriver.exe"
				  ); System.setProperty("webdriver.chrome.driver",
				  file.getAbsolutePath()); _driver = new ChromeDriver();
				  _driver.get("http://localhost:8080/");
				  _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  _driver.manage().window().maximize(); 
				 
	}

	@Test	
	public void CreateProjectvalidation() {
       

		Collection<InputbeanList> input = XMLReader.XMLdata.values();
		for (InputbeanList indata : input) {
			try {
			
				_login = PageFactory.initElements(_driver, LoginPage.class);
				_admin = PageFactory.initElements(_driver, AdminPage.class);
				String username = indata.getUsername();
				String password = indata.getPassword();
				
				boolean loginresults = _login.loginTest(username, password);
				
				//Assert.assertTrue(loginresults);
				System.out.println("7");
				//CommonFunctions.waitforPageLoad(_driver);
				
				 _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				 boolean a = _driver.findElement(_cretaeProj).isDisplayed();
				System.out.println(  a +" _projName display ??? ");
	
				 _admin.clickLink( _cretaeProj );
				 System.out.println("9");
				 String projectname = "testProject";
				 CommonFunctions.populateField(_driver, _projName, projectname);
				 
			} catch (Exception e) {
				slf4jLogger.error("The error message is {}", e.getMessage());
			}
			/*
			 * System.out.println("ccccccccc"); _admin.clickCreate();
			 * System.out.println(_driver.findElement(_projName).isDisplayed() +
			 * " _projName display ??? "); if
			  (_driver.findElement(_projName).isDisplayed()) { String
			  TestProject= "testProject" ;
			  CommonFunctions.populateField(_driver, _projName, TestProject);
			 * 
			 * 
			 * }
			 */
		}
	}
}