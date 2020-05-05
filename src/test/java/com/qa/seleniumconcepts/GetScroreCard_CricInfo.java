package com.qa.seleniumconcepts;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetScroreCard_CricInfo {
	
	@Test
	public void getScoreCardInfo() throws InterruptedException {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/19832/scorecard/1221310/"
				+ "australia-vs-india-final-sharjah-cup-retrolive-2019-20");
		driver.manage().window().maximize();
		
		
		
		Thread.sleep(3000);
		getScoreInformation(driver, "DS Lehmann");
		runOutByInfo(driver, "RT Ponting");
	}
	
	/**
	 * This method gives the Score card Info for a particular player
	 * @param driver
	 * @param playerName
	 */
	public static void getScoreInformation(WebDriver driver,String playerName) {
		
		List<WebElement> scoreList = driver.findElements(By.xpath("//a[text()='"+playerName+"']//parent::div//following-sibling::div[@class='cell runs']"));
		System.out.println("Size of the score list is : "+scoreList.size());
		ArrayList<String> scoreInfo = new ArrayList<String>();
		for(int i =0;i<scoreList.size();i++) {
			String score = scoreList.get(i).getText();
			scoreInfo.add(score);
		}
		System.out.println("Score Info for "+playerName+" is : "+scoreInfo);
		
	}
	
	public static void runOutByInfo(WebDriver driver,String playerName) {
		
		String runOutBy = driver.findElement(By.xpath("//a[contains(text(),'"+playerName+"')]//parent::div//following-sibling::div[@class='cell commentary']/a")).getText();
		
		System.out.println("Run out by : "+runOutBy);
		
	}
	
	
	

}
