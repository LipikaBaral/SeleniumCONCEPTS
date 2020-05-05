		package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	public static boolean highlightElement;
	
	public WebDriver driver_init(String browserName) {
		
		//To highlight a particular element
		highlightElement = prop.getProperty("highlight").equals("yes")? true: false;
		
		System.out.println("The browser is : "+browserName);
		if(browserName.equals("chrome")) {
			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			WebDriverManager.chromedriver().setup();
			
			if(prop.getProperty("headless").equals("yes")) {
				System.out.println("Running in headless mode!!");
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			}
			
			else {
				System.out.println("Running in normal mode!!");
				driver = new ChromeDriver();
			}
						
		}
		
		else if(browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			if(prop.getProperty("headless").equals("yes")) {
				System.out.println("Running in headless mode!!");
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			}
			else {
				System.out.println("Running in normal mode!!");
				driver = new FirefoxDriver();
			}
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("Safari")) {
			
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public Properties properties_init() {
		
		FileInputStream fis;
		prop = new Properties();
		
		String configPath = null;
		String env = null;
		//We get the value of the environment variable here and we execute from command line/terminal
		try {
			env = System.getProperty("env");
			
			if(env == null) {
				
				configPath = "./src/main/java/com/qa/hubspot/config/config.properties";
						}
		
			else {
				switch (env) {
				case "qa":
					configPath = "./src/main/java/com/qa/hubspot/config/QA_config.properties";
					break;
				case "stg":
					configPath = "./src/main/java/com/qa/hubspot/config/STG_config.properties";
					break;
				case "prod":
					configPath = "./src/main/java/com/qa/hubspot/config/config.properties";
					break;
				default:
					System.out.println("no env is passed");
					break;
							}
			
				}
		

		fis = new FileInputStream(configPath);
		prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
		
	}
	
	/**
	 * take screenshot util
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
