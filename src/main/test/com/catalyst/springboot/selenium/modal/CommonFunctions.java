package com.catalyst.springboot.selenium.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	/**
	 * Method to check for the page to Load.
	 * @param driver
	 * @return
	 */		
	public static void waitforPageLoad(WebDriver driver){
		System.out.println("waitforPageLoad");
		WebDriverWait wait = new WebDriverWait(driver,20,500);
		Boolean Pageloading = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
		if (Pageloading){
			System.out.println("The loading mask on the page disappeared and the page loaded successfully");						
		}else
			System.out.println("The loading mask on the page appeared and the page was not loaded successfully,Kindly increase the time-out");
	}
	/**
	 * Method to select the value from a list box using its value.
	 * 
	 * @param elementname
	 * @param value
	 */
	public static void selectlistvalue(WebElement elementname, String value) {
		if (value != null && !value.isEmpty()) {
			Select sel = new Select(elementname);
			sel.selectByValue(value);
		} else {
			System.out.println("The value for the Webelement" + elementname + "is" + value);
		}
	}

	/**
	 * Method to verify a particular text exists in a page.
	 * 
	 * @param driver
	 * @param textToVerify
	 * @return
	 */
	public static boolean isTextPresent(WebDriver driver, String textToVerify) {
		textToVerify = textToVerify.replace(" ", "\\s*");
		String pageSource = driver.getPageSource();
		String[] pageSourceLines = pageSource.trim().split("\\n");
		String pageSourceWithoutNewlines = "";
		for (String pageSourceLine : pageSourceLines) {
			pageSourceWithoutNewlines += pageSourceLine + " ";
		}

		pageSourceWithoutNewlines = pageSourceWithoutNewlines.trim();

		Pattern p = Pattern.compile(textToVerify);
		Matcher m = p.matcher(pageSourceWithoutNewlines);
		if (m.find())
			return true;

		return false;
	}

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
	 * 
	 * @param driver
	 * @param Pagename
	 */

	public static void navigatetoPage(WebDriver driver, String Pagename, By locator) {
		if (Pagename.equalsIgnoreCase("login")) {
			driver.findElement(locator).click();
		} else if (Pagename.equalsIgnoreCase("Register")) {
			driver.findElement(locator).click();
		}
	}

}