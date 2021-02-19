package week1;

/*
* File: KarelDefendsDemocracy.java
* --------------------------------
* Condensed code version of KareldefendsDemocracy.java
* This version take repeating chunks of code and combines
* them into a private void method.
* 
* KarelDefendsDemocracy cleans out the "hanging chad" from the 
* rectangles in a ballot. One column or rectangle represents 
* one voting box. Punching out three holes or beepers represents  
* a vote. Karel's job is to pick up the loose punches or 
* "hanging chad" represented by beepers and clear out the columns. 
* If there is a beeper in the center of the column, Karel 
* must assume that the voter did not intend to cast a vote in 
* that column, so he ignores it and moves on to the next column. 
*/

import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	/* 
	 * Checks for missing beeper at the center of the voting box.
	 * If so, invoke checkCleanUpChad subroutine to check for
	 * "hanging chad" and pick up those beepers.
	 */

	public void run() {
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				checkCleanUpChad();
			}
			move();
		}
	}
	
	// Checks for "hanging chad" in each column and picks up any beepers.

	private void checkCleanUpChad() {
		turnLeft();
		rectangleCornerSweep();
		rectangleCornerSweep();
		turnRight();
	}

	/* Pre-condition: Karel has turned Left 
	 * Proceeding: Moves to corner, checks, and turns around.
	 * Post-condition: Karel has turned around.
	 */ 
	
	private void rectangleCornerSweep() {
		move();
			while (beepersPresent()) {
					pickBeeper();
			}
			turnAround();
			move();
			}

}
