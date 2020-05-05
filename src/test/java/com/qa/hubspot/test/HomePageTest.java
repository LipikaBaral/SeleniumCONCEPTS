package com.qa.hubspot.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspor.util.ConstantsUtil;
import com.qa.hubspor.util.CredentialsUtil;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	CredentialsUtil userCred;
	

	@BeforeTest
	public void setUp() throws InterruptedException {
		//Create object of Base page
		basepage = new BasePage();
		//Properties initialisation
		prop = basepage.properties_init();
		//get the browser name
		String browserName = prop.getProperty("browser");
		//driver initialisation
		driver = basepage.driver_init(browserName);
		//Open URL
		driver.get(prop.getProperty("url"));
		//Object of loginpage
		loginpage = new LoginPage(driver);
		userCred = new CredentialsUtil(prop.getProperty("username"), prop.getProperty("password"));
		//login to hubspot
		homepage = loginpage.doLogin(userCred);
		
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, ConstantsUtil.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void clickOnMyProfileTest() throws InterruptedException {
		homepage.clickOnMyProfile();
		String userDetails = homepage.getUserDetails();
		//System.out.println(userDetails);
		Assert.assertEquals(userDetails,ConstantsUtil.USER_NAME);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
