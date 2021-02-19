package week1;
/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	
	public void run() {
		
		markStartingPosition();	// Mark Leftmost Corner		
		markRightCorner();		// Mark Rightmost Corner
		beepTowardsCenter();
		cleanUpBeepers();
		replaceColorWithBeeper();
		
	}
	
// ============================================================
	private void replaceColorWithBeeper() {
		while (frontIsClear()) {
			move();
			if (cornerColorIs(RED)) {
				paintCorner(null);
				putBeeper();
			}
		}
		turnAround();
		while (noBeepersPresent()) {
			move();
		}
		turnAround();
		turnAround();
	}

	
	private void cleanUpBeepers() {
		while (frontIsClear()) {
			move();
			pickBeeper();
		} turnAround();

		while (noBeepersPresent()) {
			move();
		} pickBeeper();
		
		while (frontIsClear()) {
			move();
			pickBeeper();
		} 
		turnAround();
	}

	private void beepTowardsCenter() {
	// Move to outermost beepers on each side and mark
		while (frontIsClear() && noBeepersPresent()) {
			moveToLeftFrontier();
			moveToRightFrontier();
		}
		paintCorner(RED);
	}

	// Move to outermost beeper on the LEFT side
	private void moveToLeftFrontier() {
		move();
		while (frontIsClear() && noBeepersPresent()) {
			move();
		}
		turnAround();
		move();
		if (noBeepersPresent()) {
			putBeeper();
		} else {
			paintCorner(RED);
		}
		move();
	}

// Move to outermost beeper on the RIGHT side
	private void moveToRightFrontier() {
		while (frontIsClear() && noBeepersPresent()) {
			move();
		}
		turnAround();
		move();
		if (noBeepersPresent()) {
			putBeeper();
			move();
		} else {
			paintCorner(RED);
		}
	}

	// Put beeper at Left corner
	private void markStartingPosition() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}


	// Put beeper at Right corner
	private void markRightCorner() {

		while (frontIsClear()) {
				move();
		}
		turnAround();
		if (noBeepersPresent()) {
			putBeeper();
		}
		move();
	}

// Final bracket
}


