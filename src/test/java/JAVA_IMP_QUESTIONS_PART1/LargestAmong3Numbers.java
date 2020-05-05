package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class LargestAmong3Numbers {
	@Test
	public void LargestAmong3Nums() {
		
		int x = 51;
		int y = 87;
		int z = 6;
		
		if(x>y && x>z) {
			System.out.println("The largest num is x = "+x);
			
		}
		
		else if(y>z) {
			System.out.println("The largest num is y = "+y);
		}
		else
			System.out.println("The largest num is z = "+z);

	}
}
