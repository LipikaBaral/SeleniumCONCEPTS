package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspor.util.ConstantsUtil;
import com.qa.hubspor.util.CredentialsUtil;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	CredentialsUtil userCred;
	
	

	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.properties_init();
		String browser = prop.getProperty("browser");
		
		driver = basepage.driver_init(browser);
		driver.get(prop.getProperty("url"));
		
		loginpage = new LoginPage(driver);
		userCred = new CredentialsUtil(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void getPageTitleTest() throws InterruptedException {
		
		String loginPageTitle = loginpage.getPageTitle();
		Assert.assertEquals(loginPageTitle, ConstantsUtil.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void doLoginTest() {		
		loginpage.doLogin(userCred);
		
	}
	/*For Negative testcase i.e login with wrong username and password
	 * We use here DataProvider annotation
	 * 
	 */
	
	@DataProvider
	public Object[][] getWrongCredential() {
		Object data[][] = {
						   {"test@gmail.com","test1"},
						   {"fgghhh@gmail.com","test1"}, 
						   {"test","test"},
						   {" " , " "}
						   
						  };
		
		return data;
		
	}
	@Test(priority = 3, dataProvider = "getWrongCredential",enabled = false)
	public void doLoginTest_InvalidData(String wrongUser,String wrongPassword) {	
		
		userCred.setAppUsername(wrongUser);
		userCred.setAppPassword(wrongPassword);
		loginpage.doLogin(userCred);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
