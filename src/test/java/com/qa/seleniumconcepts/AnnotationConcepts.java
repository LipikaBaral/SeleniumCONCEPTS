package com.qa.seleniumconcepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationConcepts {
	
	@BeforeMethod

	public void setUp() {
		System.out.println("Class starts");
	}
	
	@Test(priority = 1)
	public void test1() {
		System.out.println("Test1");
		
	}
	@Test(priority = 2)
	public void test2() {
		System.out.println("Test2");
	}
	
	@AfterMethod

	public void tearDown() {
		System.out.println("Class ends");
	}
}
