package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspor.util.ConstantsUtil;
import com.qa.hubspor.util.ElementUtil;
import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil util;
	
	//1.By locator
	//a[contains(text(),'Contacts')])[1]
	//div[@class='nav-left']//following::a[@id='nav-primary-contacts-branch']
	//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']
	By contactsLink = By.xpath("//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']");
	
	By myProfile = By.xpath("//img[@class=' nav-avatar ']");
	
	By userDetails= By.xpath("//div[@class='user-info-name']");
	
	//2.Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
		
	}
	
	//3.Page Actions
	
	public String verifyHomePageTitle() {
		util.waitForPageTitleToBePresent(ConstantsUtil.HOME_PAGE_TITLE);
		return driver.getTitle();
	}
	
	public void clickOnMyProfile() {
		util.waitForElementToBePresent(myProfile);
		driver.findElement(myProfile).click();
	}
	
	public String getUserDetails() {
		util.waitForElementToBeVisible(userDetails);
		return driver.findElement(userDetails).getText();
	}
	
	public void clickContactsLink() {
		driver.findElement(contactsLink).click();
		
		
	}

}
