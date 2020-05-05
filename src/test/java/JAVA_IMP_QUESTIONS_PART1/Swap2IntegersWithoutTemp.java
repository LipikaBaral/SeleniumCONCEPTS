package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Swap2IntegersWithoutTemp {
	@Test
	public void swapIntegers() {
		int x = 10;
		int y = 20;
		System.out.println("Before swapping x and y are : "+x+","+y);
		x = (x+y)-x;
		y = (x+y)-y;
		System.out.println("After swapping x and y are : "+x+","+y);
	}
	
}
