package com.catalyst.springboot.selenium.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {

	/**
	 * Method to populate Text field.
	 * 
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public static void populateField(WebDriver driver, By locator, String value) {
		if (value != null && !value.isEmpty()) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(value);
		}
	}

	/**
	 * Method to select Check-box based on its value.
	 * 
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public static void selectCheckboxes(WebDriver driver, By locator, String value) {

		List<WebElement> abc = driver.findElements(locator);
		List<String> list = new ArrayList<String>(Arrays.asList(value.split(",")));

		for (String check : list) {
			for (WebElement chk : abc) {
				if (chk.getAttribute("value").equalsIgnoreCase(check)) {
					chk.click();
				}
			}
		}

	}

	/**
	 * Method to wait for an Element on a Page until the element is Present.
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitforElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20, 500);
		WebElement Elementfound = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Elementfound.isEnabled();
		return Elementfound;
	}

	/**
	 * Method to navigate to different tabs in the Application.
	 * @param driver
	 * @param Pagename
	 */
	
	public static void navigatetoPage(WebDriver driver,String Pagename, By locator){
		if (Pagename.equalsIgnoreCase("login")){
			driver.findElement(locator).click();
		}else if(Pagename.equalsIgnoreCase("Register")){
			driver.findElement(locator).click();
		}
	}
	
}