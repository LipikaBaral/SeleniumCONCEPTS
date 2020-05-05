package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Swap2IntegersWithTemp {
	
	@Test
	public void swapIntegers() {
		int x = 10;
		int y = 20;
		System.out.println("Before swapping : "+x+","+y);
		int temp = 0;
		temp = x;
		x = y;
		y = temp;
		System.out.println("After swapping : "+x+","+y);
		
	}
	
	

}
