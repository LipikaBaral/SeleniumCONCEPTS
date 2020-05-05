package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUsingUtil {
	
	@Test
	public void testUtil() {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		By emailid = By.id("email");
		
		//Create the Object of Util class
		ElementUtil util = new ElementUtil(driver);
		//explicit wait
		util.waitForElementToPresent(emailid, 15);
		//get the element
		WebElement email = util.getElement(emailid);
		email.sendKeys("test@123.com");
				

  }

}
