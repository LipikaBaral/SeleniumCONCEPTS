package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Quotient_Remainder {
	@Test
	public void Calculate_QuotientRemainder() {
		
		int dividend = 20;
		int divisor = 3;
		int quotient = dividend/divisor;
		int remainder = dividend%divisor;
		System.out.println("Quotient and Remainder are : "+quotient+ ","+remainder);
		

	}
}
