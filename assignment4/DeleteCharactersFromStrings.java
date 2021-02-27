package week3;

/* File: DeleteCharactersFromStrings.java
 * -------------------------------------- 
 * Write a method public String removeAllOccurrences(String str, char ch)
 * that removes all occurrences of the character ch from the string str. 
 */

import acm.program.*;

public class DeleteCharactersFromStrings extends ConsoleProgram {

	public void run() {

		while (true) {
			String userstring = readLine("Enter a string: ");
			/* Checks for null entry. If null, then break, else get character. */
			if (userstring.equals("")) {
				breakingpoint();
				break;
			} else {
				String deletechar = readLine("Delete character: ");
				/* Checks for null entry. If null, then break and end program. */
				if (deletechar.equals("")) {
					breakingpoint();
					break;
				} else {
					char ch = deletechar.charAt(0);
					println(removeAllOccurrences(userstring, ch));
				}
			}
		} 
	}
	/* Remove the designated character from the string. */
	private String removeAllOccurrences(String str, char ch) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) != ch) {
				result += str.charAt(i);
			}
		}
		return result;
	}
	/* Program end message before break command. */
	private void breakingpoint() {
		println("");
		println("Program has ended.");
		println("Goodbye!"); 
	}


}
