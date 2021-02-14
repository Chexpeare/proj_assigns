package week1;
/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

/* • Karel starts at 1st Avenue and 1st Street, facing east, with an infinite number of beepers.
 * • The columns are exactly four units apart, on 1st, 5th, 9th Avenue, and so forth.
 * • The end of the columns is marked by a wall immediately after the final column. This
 * 	 wall section appears after 13th Avenue in the example, but your program should work
 *   for any number of columns.
 * • The top of the column is marked by a wall, but Karel cannot assume that columns are
 *   always five units high, or even that all columns are the same height.
 * • Some of the corners in the column may already contain beepers representing stones
 *   that are still in place. Your program should not put a second beeper on these corners. 
*/

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
/* 
 * checkStartingLocation: If Karel is not at (1,1), then move him to that position
 * 		- turnAround and check for wall
 * checkPutBeepers: If noBeepers at (1,1), then putBeeper and turn Left (facing North)  
 */
		checkStartingLocation();	// Start > West > check position (1,1) > East
	
		while (frontIsClear() ) {
			checkForBeepers();		//	Check for bottom beeper > North
			repairColumns();		//	Travel up and fill column	
			returnToBottom();		//	Slide back down the column
			moveToNextColumn();		//	Move over to next column
			
		}
		
		if (frontIsBlocked()) {
			checkForBeepers();		//	Check for bottom beeper > North
			repairColumns();		//	Travel up and fill column	
			returnToBottom();		//	Slide back down the column
		}
	}

	// Start > West > check position (1,1) > East
	private void checkStartingLocation() {
		turnAround();
			while (frontIsClear()) {
				move();
			}
		turnAround();
	}
//	Check for bottom beeper > North
	private void checkForBeepers() {
		turnLeft();
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
//	Travel up and fill column	
	private void repairColumns() {
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
//	Slide back down the column
	private void returnToBottom() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
//	Move over to next column
	private void moveToNextColumn() {
		for (int i=0; i<4; i++ ) {
			if (frontIsClear()) {
				move();
			} else {
				turnLeft();
			}
			
		}
	}

// Final bracket 
}
