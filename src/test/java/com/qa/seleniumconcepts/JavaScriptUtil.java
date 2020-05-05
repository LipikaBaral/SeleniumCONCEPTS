package com.qa.seleniumconcepts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	/**
	 * 
	 * JavascriptExecutor is an Interface.
	 * We are type casting driver to JavascriptExecutor.
	 * executeScript is a method.
	 * document-->Object of DOM.
	 * 
	 */

	//1. Get the page title
	public String getPageTitlebyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	//2.Get Page inner text
	
	public String getPageInnerTextbyJS(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String pageText = js.executeScript("return document.documentElement.innerText;").toString();
			return pageText;
					
	}
	
	//3. Generate Alert
		public void generateLAertbyJS(WebDriver driver,String message) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("alert('"+message+"')");
		
		}
	//4.Refresh browser 
		public void refreshBrowserbyJS(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("history.go(0)");
		
		}
	//5.Sendkeys 
		public void senKeysWithIdbyJS(WebDriver driver,String id,String value) {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("document.getElementById('"+ id +"').value = '"+value+"'");
				
		}
	//6.Click on a specific element
		
		public void clickOnElementbyJS(WebDriver driver,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		
		}
		
	//7.Draw border
		
		public void drawBorderbyJS(WebDriver driver,WebElement element) {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].style.border = '3px solid red'", element);
				
		}
		
	//8.Scroll down till bottom
		
		public void scrollPageEndbyJS(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		}
	//8.Scroll to a particular element
		
		public void scrollToElementbyJS(WebDriver driver,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		}
				
		
	//9.Flash/highlight a specific element
		/* No need to remember the code
		 * 
		 */
		public void highlightElementbyJS(WebDriver driver,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String bgcolor = element.getCssValue("backgroundColor");
			for(int i =0;i<20;i++) {
				changeColor("rgb(0,200,0)",driver,element);
				changeColor(bgcolor,driver,element);
				
			}			
		
		}

	private void changeColor(String color, WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
	}
		
	
	
	
}
