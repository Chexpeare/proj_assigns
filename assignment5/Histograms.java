package week4;

/**
 * File: Histograms.java
 * ---------------------
 * Assignment5/2: Write a program that reads a list of exam scores from the file 
 * MidtermScores.txt (which contains one score per line) and then displays a 
 * histogram of those numbers, divided into the ranges 0–9, 10–19, 20–29, and 
 * so forth, up to the range containing only the value 100. 
 * 
 * Chexpeare Note: Use the 'switch' statement (cf. TASOJDV, p.82/78)
 * 
 */

import acm.program.*;
import acm.util.*;
import java.io.*;

public class Histograms extends ConsoleProgram {

/* Private instance variables */
	private int[] histogramArray;
///* Name of the data file */
//	private static final String DATA_FILE = "MidtermScores.txt";

	public void run() {
		setUpHistoArray();
		readScoresIntoHistogram();
		printHistogram();
	}
	
	/**
	 * Initializes histogram array containing 11 lines divided into the ranges:  
	 * 0–9, 10–19, 20–29, 30-39, 40-49, 50-59, 60-69, 70-79, 80-89, 909-99, 100 
	 */ 
	private void setUpHistoArray() {
		histogramArray = new int[11]; 
		for (int i = 0; i <= 10; i++) {
			histogramArray[i] = 0;
		}
	}
   
	/* Opens the text file, reads each entry, updates the histogram */ 
	private void readScoresIntoHistogram() {
		try {
			BufferedReader rd = new BufferedReader(openFileReader("Enter Path/Filename: ")); 
			
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
		//Debugging:
		//Start: Print-check file contents				
		//println("Confirm data read: " + line);
		//End: Print-check file contents				
				int score = Integer.parseInt(line);
				if (score < 0 || score > 100) {
					throw new ErrorException("That score is out of range"); 
					} else {
						int range = score / 10;
						histogramArray[range]++;
					}
			}
		}	catch (IOException ex) {
				throw new ErrorException(ex);
			}
}

/**
 * Prompts the user for the name of a file. Returns BufferedReader rd attached to its contents. 
 * Throws exception if the file does not exist.The user is once again prompted for a filename. 
 */
	private BufferedReader openFileReader(String prompt) { 

		String name = readLine(prompt);
		
		// Start Formatting
		println("\nHistogram for" + "[" + name + "]:");
		println("-----------------------------------------------");
		// End formatting
		
		BufferedReader rd = null;		
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(name)); 
//Debugging: 
//<----- Checkpoint status of rd: (java.io.BufferedReader@77fb92c)				
//println("File has been read: " +rd); 

			} catch (IOException ex) {
				println("Can't open that file. Please try again."); }
		}
		return rd; 
	}
	
/**
 * Create the histogram: 
 *  - Case 0 & 10 set first & last ranges. 
 *  - Default sets the middle ranges according to formula. 
 */
	private void printHistogram() {
		for (int range = 0; range <= 10; range++) {
			String label;
			switch (range) {
				case  0: label = "00-09"; 
				break;
				case 10: label = "  100"; 
				break;
				default: label = (10 * range) + "-" + (10 * range + 9);
				break; 
			}
			String stars = createStars(histogramArray[range]);
			println(label + ": " + stars);
		}
	}
	
/* Adds a string of stars corresponding to the total in each box of the array. */ 
	private String createStars(int n) {
		String stars = "";
		for (int i = 0; i < n; i++) {
			stars += "*";
		}
		return stars;
	}
}









