package com.catalyst.springboot.selenium.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	private static final By _createprojectlink = By.xpath("html/body/div[1]/div/div[2]/ul[1]/li[3]/a");

//	private static final By _createprojectlink = By.cssSelector(".nav.navbar-nav>li>a");
	private static final By _projName = By.name("project-name");
	private static final By _techLead = By.name("tech-lead");
	private static final By _user = By.name("user-person");
	private static final By _adduser = By.cssSelector("#create-project>label>button");
	private static final By _create = By.cssSelector("#create-project>button");
	
	private WebDriver _driver;

	final WebElement _techLeadWebEl = _driver.findElement(By.name("tech-lead"));
	final WebElement _userWebEl = _driver.findElement(By.name("user-person"));
	public AdminPage(WebDriver _driver) {
		this._driver = _driver;
	}

	public void clickLink(By locator) {
		System.out.println("5");
		_driver.findElement(locator).click();
		
	}
	public void listTechLead() {
		//final WebElement _techLead = _driver.findElement(By.name("tech-lead"));
		String test= "testing";
		CommonFunctions.selectlistvalue(_techLeadWebEl, test );
	}
	public void listUsers() {
		// final WebElement _user = _driver.findElement(By.name("user-person"));
		String testUser= "sally";
		CommonFunctions.selectlistvalue(_userWebEl, testUser );
	}
 //public void listbox (WebElement El , )
	
	
	
}
