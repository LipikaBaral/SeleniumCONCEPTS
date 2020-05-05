package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentwaitConcept {
	
	@Test
	public void waitforElementFluentWait() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		By username = By.name("email");
		By password = By.name("pass");
		By loginBtn = By.id("loginbutton");
		//Call the function
		waitWithFluentWait(driver, username).sendKeys("lopa02@gmail.com");
		driver.findElement(password).sendKeys("Lipicardinal@3");
		driver.findElement(loginBtn).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up"));
		
		System.out.println(driver.getTitle());
	}
	
	public static WebElement waitWithFluentWait(WebDriver driver,By locator) {
		
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				   .withTimeout(Duration.ofSeconds(15))
				   .pollingEvery(Duration.ofSeconds(3))
				   .ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		
	}

}
