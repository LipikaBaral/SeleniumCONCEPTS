package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class CheckPositiveOrNegativeNumber {
	
	@Test
	public void PositiveOrNegative() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		
		double num = reader.nextDouble();
		System.out.println("You entered : "+num);
		
		if(num>0.0) {
			System.out.println("Number is positive");
		}
		
		else if(num<0.0) {
			System.out.println("Number is negative");
		}
		
		else {
			System.out.println("Number is 0");
		}
			
	}

}
