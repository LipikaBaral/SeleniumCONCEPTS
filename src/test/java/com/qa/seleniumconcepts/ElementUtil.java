package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		
	}
	/**
	 * GET WEB ELEMENT
	 * @param locator
	 * @return
	 */
	
	public WebElement getElement(By locator) {
		
		WebElement element = null;
		try {
			element = driver.findElement(locator);			
		}
		
		catch(Exception e) {
			System.out.println("Some exception while creating the web element!!");
			e.printStackTrace();
		}
		
		return element;
	}
	/**
	 * SENDKEYS
	 * @param locator
	 * @param value
	 */
	
	public void doSendkeys(By locator,String value) {
		
		try {
		getElement(locator).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("Some error occured while entering the value...");
			e.printStackTrace();
		}
	}
	/**
	 * CLICK
	 * @param locator
	 * @param value
	 */
	public void doClick(By locator,String value) {
		
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("Some error occured while clicking on the element...");
			e.printStackTrace();
		}
	}
	/**
	 * EXPLICIT WAIT FOR WEB ELEMENT TO BE PRESENT IN THE DOM
	 * @param locator
	 * @param value
	 */
	
	public void waitForElementToPresent(By locator,int timeout) {
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		catch(Exception e) {
			System.out.println("Element is not found and timed out..");
			e.printStackTrace();
		}
	}
	/**
	 * EXPLICIT WAIT FOR TITLE
	 * @param locator
	 * @param timeout
	 * @return 
	 */
	public void waitForTitleToPresent(int timeout,String title) {
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e) {
			System.out.println("Element is not found and timed out..");
			e.printStackTrace();
		}
	}
	
	/**
	 * EXPLICIT WAIT FOR ELEMENT TO BE VISIBLE ON THE PAGE
	 * Sometimes element is visible inside the DOM but it takes few more seconds to be present on the page
	 * Fot that we use here VisibilityOf(element)-->it ensures element is visible on the page with height and width>0
	 * @param locator
	 * @param timeout
	 * @return 
	 */
	public void waitForTitleToPresentOnPage(By locator,int timeout) {
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			System.out.println("Element is not found and timed out..");
			e.printStackTrace();
		}
	}
	/**
	 * CLICK WHEN THE ELEMENT IS READY
	 * @param locator
	 * @param timeout
	 */
	public void clickWhenReady(By locator,int timeout) {
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("Element is not clickable..");
			e.printStackTrace();
		}
	}
	/**
	 * ACTION SENDKEYS
	 * @param locator
	 * @param timeout
	 */
	public void actionSendkeys(By locator,String value) {
		
		try {
		WebElement element = getElement(locator);	
		Actions action = new Actions(driver);
		action.sendKeys(element, value).build().perform();
		}
		catch(Exception e) {
			System.out.println("Error occurred while entering the value....");
			e.printStackTrace();
		}
	}
	/**
	 * ACTION CLICK
	 * @param locator
	 * @param value
	 */
	public void actionClick(By locator) {
		
		try {
		WebElement element = getElement(locator);	
		Actions action = new Actions(driver);
		action.click(element).build().perform();
		}
		catch(Exception e) {
			System.out.println("Error occurred while clicking the element....");
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param locator
	 */
	public void SelectValueFromDropdown(By locator,String value) {
		
		try {
		WebElement element = getElement(locator);	
		Actions action = new Actions(driver);
		action.click(element).build().perform();
		}
		catch(Exception e) {
			System.out.println("Error occurred while clicking the element....");
			e.printStackTrace();
		}
	}
	
	
	
}
