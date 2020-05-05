package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class MultiplicationTable {
	
	@Test
	public void getMultiplicationTable() {
		
		int num =4;
		
		int output = 1;
		for(int i =1;i<=10;i++) {
			
			output = num*i;
			
			System.out.println(output);
			
		}
		
	}

}
