package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSS_SelectorConcept {
	
	@Test
	public void locator_CSSselector() {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/");
		
		driver.manage().window().maximize();
		
		//CSS selector for Search button
		
	    /**Using id-->
	     * 1)#id
	     * 2)htmltag#id
	     * 3)htmltag[prop = '<prop value>']
	     * 4)htmltag[prop1 = '<prop value1>'][prop2 = '<prop value2>']
	     * 
	     */
		/**Using Class-->
		 * 1).class(e.g: .bookbtn)
		 * 
		 * suppose the class name is as below:
		 * class = "travel-icon GST-Invoice"
		 * This has 2 classes-->
		 * 1.travel-icon  
		 * 2.GST-Invoice
		 * There is a space between 2 classes
		 * So here CSS selector will be as below:
		 * .travel-icon.GST-Invoice(Replace the space with dot(.))
		 * 
		 */
		By searchBtn = By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit");
		ElementUtil util = new ElementUtil(driver);
		util.getElement(searchBtn);
	}

}
