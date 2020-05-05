package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover_Actions {

	
	@Test
	public void handleDropDown() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/**
		 * Test case:
		 * Go to spicejet.com
		 * Mouse hover on Login/Signup
		 * Go to Spice club members
		 * Then click on Signup
		 */
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		Actions action = new Actions(driver);
		WebElement signUpLink = driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"));
		//Explicit wait/webdriver wait
		waitForMenuElement(driver, 10, signUpLink);
		action.moveToElement(signUpLink).build().perform();
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"))).build().perform();
		
		WebElement loginLink = driver.findElement(By.linkText("Member Login"));
		
		waitForMenuElement(driver, 5, loginLink);
		loginLink.click();
				
		
  }
	
	public static void waitForMenuElement(WebDriver driver,int timeout,WebElement element) {
		Wait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}