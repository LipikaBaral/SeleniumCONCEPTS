package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {
	
	@Test
	public void handleDropDown() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		WebElement year = driver.findElement(By.id("year"));
		
		getAllValuesFromDropDown(year);
		getDropDownValue(year, "1989");
		
		driver.quit();
		
	}
	/**
	 * This method is used to get a particular value from the drop down
	 * @param element
	 * @param value
	 */
	public void getDropDownValue(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void getAllValuesFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		System.out.println("Size of the drop down is : "+options.size());
		for(int i =0;i< options.size();i++) {
			String optionValue = options.get(i).getText();
			System.out.println(optionValue);
		}
	}

}
