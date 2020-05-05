package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class PrintIntegerEnteredByUser {
	
	@Test
	public void printInteger() {
		
		//Using Scanner class,user can enter an integer at run time
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		
		int num = reader.nextInt();
		System.out.println("You entered : "+num);

	}

}
