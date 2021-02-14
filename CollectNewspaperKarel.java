package week1;
/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {

		moveToNewsPaper();
		pickUpNewspaper();
		backStartingPoint();
	}

	private void moveToNewsPaper() {
		while(frontIsClear()) {
			move();
		}	
			turnRight();
			move();
			turnLeft();
			move();
    }
 /*
 * If there is no beeper then put a beeper down, 
 * otherwise pick up the beeper.
 */	        
	private void pickUpNewspaper() {
        if (beepersPresent()) {
        	pickBeeper();
        }   turnAround();
	}
/*
 * Begin the journey back to the starting point.
 */ 
	
	private void backStartingPoint() {
		while(frontIsClear()) {
			move();
		}
			turnRight();
			move();
			turnRight();
	}

	
}
