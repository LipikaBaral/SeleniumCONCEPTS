package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class TestEvenOdd {
	@Test
	public void EvenOdd() {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a num: ");
		int num = reader.nextInt();
		int remainder = num%2;
		if(remainder == 0) {
			System.out.println(num+" is an even number!");
			
		}
		else
			System.out.println(num+" is an odd number!");
		

	}

}
