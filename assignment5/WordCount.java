package week4;
/*
 * File: WordCount.java
 * --------------------
 * Counts the characters, words, and lines in a text file.
 * Prompts user for a file name and throws an exception for invalid or non-existent files. 
 *  
 * Assignment: Write a program WordCount that reads a file and reports how many lines, words, 
 * and characters appear in it. Suppose, for example, that the file lear.txt contains the
 * following passage from Shakespeare’s King Lear:
 * Poor naked wretches, wheresoe'er you are,
 * That bide the pelting of this pitiless storm,
 * How shall your houseless heads and unfed sides,
 * Your loop'd and window'd raggedness, defend you
 * From seasons such as these? O, I have ta'en
 * Too little care of this! 
 * 
 */

import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram {

	public void run() {
		int lines = 0;
		int words = 0;
		int chars = 0;
		setFont("Courier-24");

		BufferedReader rd = new BufferedReader(openFileReader("Enter Path/Filename: ")); 
				
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				println(line);
				
				lines++;
				words += countWords(line);
				chars += line.length();
			}
			rd.close();
		}	catch (IOException ex) {
				println("An I/O exception has occurred");
			}
			println("-----------------------------------------------");
			println("\nANALYSIS");
			println("Lines = " + lines);
			println("Words = " + words);
			println("Chars = " + chars);
	}
/**
 * Prompts the user for the name of a file. Returns BufferedReader attached to its contents. 
 * Throws exception if the file does not exist.The user is once again prompted for a filename. 
 */
	private BufferedReader openFileReader(String prompt) { 

		String name = readLine(prompt);
		
		// Start Formatting
		println("\nThe file" + " [" + name + "] " + "contains the following text:");
		println("-----------------------------------------------");
		// End formatting
		
		BufferedReader rd = null;		
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(name)); 
//				println(rd); //<----- Checkpoint status of rd: (java.io.BufferedReader@77fb92c)
				} catch (IOException ex) {
				println("Can't open that file. Please try again."); }
		}
		return rd; 
	}

/**
 * Read each line and count the words (consecutive strings of letters and/or digits) 
 * in the input line.
 */
	private int countWords(String line) {
		boolean inWord = false;
		int words = 0;
		
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord) words++;
				inWord = false;
			}
		}
			if (inWord) words++;
			return words;
		} 
}











