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

public class XpathAxesConcept {
	
	/**
	 * TestCase:
	 * Go to hubspot.com
	 * Login and click on Contacts Menu
	 * Then go to Contacts sub menu
	 * Now click on the respective check box of lipika b
	 * @throws InterruptedException 
	 */
	
	@Test
	public void xPathAxes() throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/");
		driver.manage().window().maximize();
		
	    By username = By.id("username");
	    By password = By.id("password");
	    By loginBtn = By.xpath("//button[@type='submit']");
	    
	    ElementUtil util = new ElementUtil(driver);
	    util.waitForElementToPresent(username, 15);
	    
	    util.getElement(username).sendKeys("lopa02@gmail.com");
	    util.getElement(password).sendKeys("Stayhomestaysafe@2020");
	    util.getElement(loginBtn).click();
	    
	    By contactsLink = By.id("nav-primary-contacts-branch");
	    
	    util.waitForElementToPresent(contactsLink, 10);
	    
	    util.getElement(contactsLink).click();
	    
	    By contactsSubMenu = By.xpath("(//div[contains(text(),'Contacts')])[1]");
	    WebElement contacts = util.getElement(contactsSubMenu);
	    Actions action = new Actions(driver);
	    action.moveToElement(contacts).build().perform();
	    contacts.click();
	    
	   //Xpath axes******************
	   /**
	    * I want to click the checkbox corresponding to--> lipika b
	    * -->So first inspect and take the xpath of lipika b
	    * -->Then go to the column where lipika b is present i.e the htmsl tag = td
	    * -->Now from this column--> go to the column where check boxes are present
	    */
	  /**
	   * 1.//span[text()='lipika b']-->xpath of lipika b
	   * 2.//span[text()='lipika b']//ancestor::td-->Go to the ancestor(old parent)-->It represents the column
	   * 3.//span[text()='lipika b']//ancestor::td//preceding-sibling::td-->This jumps to the sibling column where the
	   * checkboxes are present
	   * 4.//span[text()='lipika b']//ancestor::td//preceding-sibling::td//span-->This the corresponding checkbox
	   */
	    
	    Thread.sleep(3000);
	    selectContactHubSpot(action, driver, "himanshi");
	    selectContactHubSpot(action, driver, "asim riaz");

	}
	
	public static void selectContactHubSpot(Actions action,WebDriver driver,String contactName) {
		
		By checkBox = By.xpath("//span[text()= '"+contactName+"']//ancestor::td//preceding-sibling::td//span");
	    WebElement chkbox = driver.findElement(checkBox);
	    action.click(chkbox).build().perform();

		
	}
}
