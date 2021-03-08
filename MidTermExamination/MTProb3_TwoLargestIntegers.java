package week4;

/**
 * File: MTProb3_TwoLargestIntegers.java 
 * -------------------------------------
 * Write a program that finds the largest and the second-largest integer. 
 * Use 0 as a SENTINEL to indicate the end of the input list. To reduce 
 * the number of special cases, you may make the following assumptions: 
 * 		1.	The user must enter at least two values before the sentinel. 
 * 		2.	All input values are positive integers. 
 * 		3.	If the largest value appears more than once, that value should 
 * 			be listed as both the largest and second-largest value, 
 */

import acm.program.*;

public class MTProb3_TwoLargestIntegers extends ConsoleProgram {

	private static final int SENTINEL = 0;

	public void run() {
		println("This program finds the two largest integers in a\n" 
				+ "list. Enter values, one per line, using a "
				+ SENTINEL + " to\n" + "signal the end of the list.");

		int largest = 0;
		int secondLargest = 0;

		while (true) {
			int dataEntry = readInt(" ? ");
			
			if (dataEntry == SENTINEL)
				break;
			
			if (dataEntry > largest) {
				secondLargest = largest;
				largest = dataEntry;
			} else if (dataEntry > secondLargest) {
				secondLargest = dataEntry;
			}
		}
		println("The largest value is " + largest);
		println("The second largest is " + secondLargest);
	}
}









