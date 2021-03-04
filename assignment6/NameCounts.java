package week4;

/**
 * File: NameCounts.java
 * --------------------- 
 * This program uses a HashMap. 
 * Assignment: Write a program that asks the user for a list of names (one per line) 
 * until the user enters a blank line (i.e., just hits return when asked for a name). 
 * At that point the program should print out how many times each name in the list 
 * was entered. You may find that using a HashMap to keep track of the information 
 * entered by user may greatly simplify this problem. 
*/

import acm.program.*;
import java.util.*;

public class NameCounts extends ConsoleProgram {

	public void run() {
		HashMap<String, Integer> namesEntered = new HashMap<String, Integer>();
		readNames(namesEntered);
		printMap(namesEntered);
	}

	/*
	 * Data Entry: User enters name + return. Names are stored in the HashMap.
	 * Counts number of times that each name appears in the HashMap. 
	 */
	private void readNames(Map<String,Integer> NameMap) { 
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			
			/* IF name is already in the map, then update the count.
			 * ELSE start a new count if it is the first occurrence. 
			 */
			Integer count = NameMap.get(name);
			if (count == null) {
				count = new Integer(1);
			} else {
					count = new Integer(count + 1);
			}
			NameMap.put(name, count);
		}
	}

	/* Output: list of names and total count for each one.
	 */
	private void printMap(Map<String,Integer> NameMap) { 
		Iterator<String> iter = NameMap.keySet().iterator(); 
		println("\n---------------------------------");
		
		while (iter.hasNext()) {
			String key = iter.next();
			int count = NameMap.get(key);
			println("Entry [" + key + "] has count " + count);
		} 
	}
}










