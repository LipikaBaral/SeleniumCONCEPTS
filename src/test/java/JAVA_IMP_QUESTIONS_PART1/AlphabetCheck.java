package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class AlphabetCheck {
	
	@Test
	public void characterIsAlphabetOrNot() {
		char ch = '&';
		
		if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
			System.out.println("It is an Alphabet");
		}
		
		else
			System.out.println("Not Alphabet");
	}

}
