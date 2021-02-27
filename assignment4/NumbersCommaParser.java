package week3;

/* File: AddCommasToNumberStrings.java
 * -----------------------------------
 * Textbook Ref: The Art & Science of Java, Chapter 9, p. 255/250
 * 
 */

import acm.program.*;

public class NumbersCommaParser extends ConsoleProgram {
	
	public void run() {

		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) {
				println("");
				println("Program has ended.");
				println("Goodbye!");
				break;
			}
			println(addCommasToNumberString(digits));
		}
	}
	
	private String addCommasToNumberString(String digits) { 
		
		String newstring= "";

		int length = digits.length();
		int putComma = 0;

		/* Begin at the rightmost number and go to the left */
		for (int i = length - 1; i >= 0; i--) { 
			newstring = digits.charAt(i) + newstring; 
			putComma++;
			
			if (((putComma % 3) == 0) && (i > 0)) {
				newstring = "," + newstring;
			}
		}
		return newstring;
	}

}
