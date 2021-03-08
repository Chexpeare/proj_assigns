package week4;

/**
 *  File: MTProb5_RemoveDoubleLetters.java
 * --------------------------------------
 * Write a method, removeDoubledLetters() that takes a string as its argument and 
 * returns a new string with all doubled letters in the string replaced by a 
 * single letter. 
 */

import acm.program.ConsoleProgram;

public class MTProb5_RemoveDoubleLetters extends ConsoleProgram {

	public void run() {
		while (true) {
			println(removeDoubledLetters(readLine("Enter a word with double letters:")));
		}
	}

	public String removeDoubledLetters(String str) {
		String textInput = "";
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (i == 0 || ch != str.charAt(i - 1)) {
				textInput += ch;
			}
		}
		return textInput;
	}
}
