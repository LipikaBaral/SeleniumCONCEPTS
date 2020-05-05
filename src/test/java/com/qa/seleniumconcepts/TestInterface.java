package com.qa.seleniumconcepts;

public interface TestInterface {

	int i =100;//static and final
	public void method1();//By default abstract method
	
	/*
	 * After JDK 1.8 the following methods with body are allowed
	 */
	
	//Method with body-->abstract access modifier
	default void method2() {
		
		System.out.println("Method with default access modifier!!");
		
	}
	
	//Method with body-->static keyword
	public static void method3() {
		
		System.out.println("Method with static keyword!!");
	}
	//We cant create the object of an Interface
}
