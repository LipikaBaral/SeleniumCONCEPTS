package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElements_Links {
		
		@Test
		public void getAllLinks() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			//Open the URL
			driver.get("https://www.facebook.com/");
			//Maximize the window
			driver.manage().window().maximize();
			//Store all links in a List
			List<WebElement> linksList = driver.findElements(By.tagName("a"));
			//size of the List
			System.out.println("Size of the List is : "+linksList.size());
			//As it return a List object,so we can use for loop to get the values through index
			for(int i = 0;i<linksList.size();i++) {
				String linkName = linksList.get(i).getText();
				//Print the link names which are not blank. 
				    if(!linkName.isBlank())
					System.out.println("Link name is : "+linkName);
			}
		}
}
