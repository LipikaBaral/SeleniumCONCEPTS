package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysAndClickWithActions {
	
	@Test
	public void sendkeysClickUsingActionsClass() throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement searchBtn = driver.findElement(By.name("btnK"));
		
		Actions action = new Actions(driver);
		//sendkeys using Actions reference var.
		Thread.sleep(2000);
		action.sendKeys(searchBox, "Selenium").build().perform();
		
		//click the search button
		action.click(searchBtn).build().perform();
		
		
	}

}
