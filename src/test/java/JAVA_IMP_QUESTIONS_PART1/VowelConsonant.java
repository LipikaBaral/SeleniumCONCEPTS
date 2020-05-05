package JAVA_IMP_QUESTIONS_PART1;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class VowelConsonant {
	
	@Test
	public void VowelandConsonant() {
		
		char ch = 'k';
		if(ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u') {
			System.out.println(ch+" is a vowel");
		}
		
		else
			System.out.println(ch+" is a consonant");

	}

}
