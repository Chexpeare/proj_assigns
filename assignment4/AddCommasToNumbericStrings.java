package week3;

/* File: AddCommasToNumbericStrings.java
 * -------------------------------------
 * Textbook Ref: The Art & Science of Java (Draft), Chapter 9, p. 254/250-1
 * To make it easier for programmers to display numbers in this fashion, 
 * implement a method private String addCommasToNumericString(String digits) 
 * that takes a string of decimal digits representing a number and returns 
 * the string formed by inserting commas at every third position, starting 
 * on the right.
 */

import acm.program.*;

public class AddCommasToNumbericStrings extends ConsoleProgram {
	
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
