package com.qa.seleniumconcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class JavaScript_ALERT {

	public static void main(String[] args) {
		//Java Script alerts/pop-ups are the small pop-ups appear on the page
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriver driver = new ChromeDriver();
		
		driver.get("");
		//For Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();//Accept
		alert.dismiss();//cancels
		alert.sendKeys("test");//Enters a value
		alert.getText();//Get the text
		
	}

}
