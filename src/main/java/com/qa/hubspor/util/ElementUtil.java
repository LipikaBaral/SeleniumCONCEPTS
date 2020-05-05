package com.qa.hubspor.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, ConstantsUtil.DEFAULT_TIMEOUT);
	}
	//1.Get WebElement
	public WebElement getElement(By locator) {
		
		WebElement element = null;
		
		element = driver.findElement(locator);
//		if(highlightElement) {
//			jsUtil.highlightElementbyJS(driver, element);
//		}
		
		return element;
	}
	//2.Get the page title
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	//3.Click on Webelement
		public void doClick(By locator) {
			WebElement element = getElement(locator);
			element.click();
			
		}
	//4.Click on Webelement
		public void doSendkeys(By locator,String value) {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
			
		}
	//5.Click on Webelement
		public boolean doIsDisplayed(By locator) {
			WebElement element = getElement(locator);
			return element.isDisplayed();
			
		}

	//****************************Explicit waits***************************************
	
	//1.presenceOfElementLocated
		
	public boolean waitForElementToBePresent(By locator) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));//element is present in the DOM
		return true;
		
	}
	
	//2.visibilityOfElementLocated
		public boolean waitForElementToBeVisible(By locator) {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));//element is present in the DOM and page
			return true;
			
		}
	
	
	//3.Webdriver wait for title
	public Boolean waitForPageTitleToBePresent(String pageTitle) {
		
		wait.until(ExpectedConditions.titleIs(pageTitle));
		return true;
		
	}
	

}
