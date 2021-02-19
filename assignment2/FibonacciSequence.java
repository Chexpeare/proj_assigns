package week2;

/*
 * File: FibonacciSolution.java
 * --------------------
 * Assignment: Write a program that displays the terms in the Fibonacci sequence,
 * starting with Fib(0) and continuing as long as the terms are less than 10,000.
 * 
 * SENTINEL = 10000 <---- The maximum value constant
 * 
 * Fibonacci: The first two terms in this sequence, Fib(0) and Fib(1), are 0 and 1,
 * and every subsequent term is the sum of the preceding two. Thus, the first several terms
 * in the Fibonacci sequence look like this:
 * 
 * fib(0) = 0
 * fib(1) = 1
 * fib(2) = 1 (0 + 1)
 * fib(3) = 2 (1 + 1)
 * fib(4) = 3 (1 + 2)
 * fib(5) = 5 (2 + 3)
 * 
 */

import acm.program.*;

public class FibonacciSequence extends ConsoleProgram {

	private static final int MAX_TERM_VALUE = 10000; 	
	
	public void run() {
		int fib1 = 0;
		int fib2 = 1;
		int check = 0;
		
		println("   " + "This program lists the Fibonacci series up to 10,000");
		println("   " + fib1);
		println("   " + fib2);

		while (check <= MAX_TERM_VALUE) {
			int fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
			check = fib2;

// Breaks once check exceeds MAX_TERM_VALUE 
			if (check <= MAX_TERM_VALUE) {
			println("   " + fib3);
			} else {
				break;
			}
		}
	}
}

/* Path: /Users/chexpeare/Tech Certifications/02_Programming Certifications/Java/Stanford106AAssignments/bin/week2/FibonacciSequence.class */


