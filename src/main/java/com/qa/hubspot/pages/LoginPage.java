package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspor.util.ConstantsUtil;
import com.qa.hubspor.util.CredentialsUtil;
import com.qa.hubspor.util.ElementUtil;
import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil util;
	
	//1.Locators
	
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.xpath("//i18n-string[text()='Log in']");
	
	//2.Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;	
		util = new ElementUtil(driver);
		
	}
	
	//3.Page Actions
	public String getPageTitle() {
		util.waitForPageTitleToBePresent(ConstantsUtil.LOGIN_PAGE_TITLE);
		return util.getPageTitle();
		
	}
	
	public HomePage doLogin(CredentialsUtil userCred) {
		
		util.waitForElementToBePresent(username);
		util.doSendkeys(username, userCred.getAppUsername());
		util.doSendkeys(password, userCred.getAppPassword());
		util.doClick(loginBtn);
		
		return new HomePage(driver);
	}

}
