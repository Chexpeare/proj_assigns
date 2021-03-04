package week4;

/**
 * File: UniqueNames.java
 * ----------------------
 * Assignment: Write a program that asks the user for a list of names 
 * (one per line) until the user enters a blank line (i.e., just hits 
 * return when asked for a name). At that point the program should print 
 * out the list of names entered, where each name is listed only once 
 * (i.e., uniquely) no matter how many times the user entered the name 
 * in the program. You may find that using an ArrayList to keep track 
 * of the names entered by user may greatly simplify this problem. 
 */

import acm.program.*;
import java.util.*;

	public class UniqueNames extends ConsoleProgram {
		
		public void run() {
			
		ArrayList<String> listOfNames = new ArrayList<String>(); 

		while (true) {
			String name = readLine("Enter name: "); 
			if (name.equals("")) break; 
			if (!listOfNames.contains(name)) {
				listOfNames.add(name);
			}
		}
		println("\nUnique name list contains:");
		printList(listOfNames);
	}

/* 
 * Outputs the contents of ArrayList<String>, one unique name on each line.  
 */ 
	private void printList(ArrayList list) {
		
		for(int i = 0; i < list.size(); i++) {
			println(list.get(i));
		}
	}
}
	
	
	
	
	
	
	
	
	