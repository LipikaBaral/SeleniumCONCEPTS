package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindTotalImages {
	
	@Test
	public void getAllImages() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open the URL
		driver.get("https://www.facebook.com/");
		//Maximize the window
		driver.manage().window().maximize();
		//Store all links in a List
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		//size of the Image list
		System.out.println("Size of the Image list is : "+imageList.size());
		//As it return a List object,so we can use for loop to get the values through index
		for(int i = 0;i<imageList.size();i++) {
			String imageUrl = imageList.get(i).getAttribute("src");
			System.out.println(imageUrl);
			
		}
		
	}

}
