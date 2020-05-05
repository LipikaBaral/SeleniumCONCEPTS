package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
	@Test
	public void handleRightClick() throws InterruptedException {
		
		//Suppress the Timeout warning from console
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/**
		 * Test case:
		 * Go to http://swisnl.github.io/jQuery-contextMenu/demo.html
		 * Right click on right click me
		 * get the all the options in an Array List
		 * 
		 */
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement rightClickElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Thread.sleep(2000);
		//Right Clicked
		action.contextClick(rightClickElement).build().perform();
		
		//Get all the options
		List<WebElement> rightClickOptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li"));
		ArrayList<String> options = new ArrayList<String>();	
		
		for(int i =0;i<rightClickOptions.size();i++) {
			String optionsText = rightClickOptions.get(i).getText();
			options.add(optionsText);
		}
		System.out.println(options);	
  }

}
