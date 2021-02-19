package week1;
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	public void run() {
		
		while (frontIsClear()) {
			putEastCheckers();
			putWestCheckers();
		}
	}

	/* -------------------------------------------------------------------------
	 * Karel runs two tests before deciding to move up a row:
	 * 		1. a double-blocked corner test 
	 * 		2. a test to make sure that checkers are not double-up on the next row
	 */
		private void moveUpOneRowEast() {
			while (facingEast()) {
				
				if (frontIsBlocked()) {
					turnLeft(); 
					
					if (frontIsBlocked()) {
						facingNorth();
					
					} else {
				
						if (beepersPresent()) {
							turnRight();
							turnAround();
							move();
							turnRight();
							move();
							turnLeft();
					
						} else {
							move();
							turnLeft();
						}
					}
				}
			}
		}

/* -------------------------------------------------------------------------
 * Karel runs two tests before deciding to move up a row:
 * 		1. a double-blocked corner test 
 * 		2. a test to make sure that checkers are not double-up on the next row
 */
		private void moveUpOneRowWest() {
			while (facingWest()) {
				
				if (frontIsBlocked()) {
					turnRight(); 
					
					if (frontIsBlocked()) {
						facingNorth();
					
					} else {
				
						if (beepersPresent()) {
							turnLeft();
							turnAround();
							move();
							turnLeft();
							move();
							turnRight();
					
						} else {
							move();
							turnRight();
						}
					}
				}
			}
		}
// -----------------------------------------------------------------
	/* 
	 * Starting at (1,1): 
	 * Karel begins facing East, moves two Avenues East and deposits
	 * a beeper/checker on that spot. Once he reaches the wall, 
	 * Karel runs a double-blocked corner test in moveUpOneRowEast()
	 * before moving up one row and heading West.
	 */
		private void putEastCheckers() {
	
			while (facingEast()) {
					
					if (frontIsBlocked()) {
						moveUpOneRowEast();	
					} else {
	
						if (noBeepersPresent()) {
							putBeeper();
						}
						
						if (frontIsClear()) {
							move();
						}
						
						if (frontIsClear()) {
							move();
						} else {
							moveUpOneRowEast();
						}
						if (noBeepersPresent()) {
							putBeeper();
						}
					  }
					}		 
				}
// -----------------------------------------------------------------
	/* 
	 * After reaching the Eastern wall and passing a double-blocked
	 * corner test in moveUpOneRowEast(), Karel moves up a row and 
	 * faces West. Now moving two Avenues West and depositing
	 * a beeper/checker on that spot. Once he reaches the wall, 
	 * Karel runs a double-blocked corner test in moveUpOneRowWest()
	 * before moving up one row and heading East once again.
	 */

		private void putWestCheckers() {
				
			while (facingWest()) {
				
				if (frontIsBlocked()) {
					moveUpOneRowWest();	
				} else {
					
					if (noBeepersPresent()) {
						putBeeper();
					}
					
					if (frontIsClear()) {
						move();
					}
					
					if (frontIsClear()) {
						move();
					} else {
						moveUpOneRowWest();
					}
				}
			}		 
		}
	
// Final Bracket
}
