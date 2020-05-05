package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrameConcept {
	
	
	@Test
	public void handleFrame() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.manage().window().maximize();
		//Here the Title bar is inside a frame
		//So first switch to frame
		int frameCount = driver.findElements(By.tagName("Frame")).size();
		System.out.println("No of frames available: "+frameCount);
//		driver.switchTo().frame("main");//main-->frame name
//		//Spy the element(title bar) and right click--> copy the CSS selector
//		WebElement frameElement = driver.findElement(By.cssSelector("body > h2"));
//		System.out.println(frameElement.getText());
//		driver.quit();
		
	}

}
