package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindowPopup {
	
	@Test
	public void handleWindowPopup() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open the URL
		driver.get("http://www.popuptest.com/goodpopups.html");
		//Maximize the window
		driver.manage().window().maximize();
		//Click the link to open the popup
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]")).click();
		//Get the window handles
		Set<String> handles = driver.getWindowHandles();
		/*Get window handles returns Set of Strings and 
		 * Set is collection in Java which doesn't store the value on the basis of indexes,it
		 * stores the values in key,value format and it always contain unique values
		 */
		Iterator<String> it = handles.iterator();
		//Get Parent window handle
		String parentWindowHandle = it.next();
		System.out.println("Parent window ID is: "+parentWindowHandle);
		//Get Child Window handle
		String childWindowHandle = it.next();
		System.out.println("Parent window ID is: "+childWindowHandle);
		//Now take the control to Child window
		driver.switchTo().window(childWindowHandle);
		System.out.println("Child window title is : "+driver.getTitle());
		//Close the child window
		driver.close();
		//Take the driver back to the Parent
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Parent window title is : "+driver.getTitle());
		//Close the Child window
		driver.close();
		//Quit 
		driver.quit();
		
		
		
	
		
		
	}

}
