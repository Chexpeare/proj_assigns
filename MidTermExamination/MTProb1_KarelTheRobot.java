package week4;

/**
 * File: MTProb1_KarelTheRobot.java
 * --------------------------------
 * Midterm Problem 1: Karel the Robot 
 * Write a Karel program that will create an inside border around the world. 
 * Each location that is part of the border should have ONE (and only one) 
 * beeper on it and the border should be inset by one square from the outer 
 * walls of the world.
 * 
 * In solving this problem, you can count on the following facts about the world:
 * 1.	You may assume that the world is at least 3x3 squares. The correct solution  
 * 		for a 3x3 square world is to place a single beeper in the center square. 
 * 
 * 2.	Karel starts off facing East at the corner of 1st Street and 1st Avenue with 
 * 		an infinite number of beepers in its beeper bag. 
 * 
 * 3.	We do not care about Karel’s final location or heading.
 * 
 * 4.	You do not need to worry about efficiency.
 * 
 * 5.	You are limited to the instructions in the Karel booklet—the only variables 
 * 		allowed are loop control variables used within the control section of the for loop.
 */

import stanford.karel.*;

public class MTProb1_KarelTheRobot extends SuperKarel {

	public void run() {
				
		move();
		if(noBeepersPresent()) {
				turnLeft();
				move();
				turnRight();
		} else {
			resetStartPosition();
		}

		for(int i = 0; i < 4; i++) {
			putRowOfBeepers();
		}
		resetStartPosition();
	}

	private void putRowOfBeepers() {
		
		while(frontIsClear()) {
			if(noBeepersPresent()) {
				putBeeper();
			}
			move();	// <----- Puts Karel in front of a wall
		}

		while(frontIsBlocked()) {
			turnAround();
			move();
			turnRight();
		}
		 
		if(noBeepersPresent()) {
			move();
		}
	}
	
	private void resetStartPosition() {
		turnAround(); 
		move(); 
		turnAround();
	}
}









