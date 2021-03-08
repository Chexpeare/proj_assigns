package week4;

/**
 * In the arcade game Frogger, this is a frog that "hops" along the screen.
 * A full game is beyond the scope of an exam problem, but it is relatively 
 * straightforward to write the code that: 
 * 		(1) puts an image of the frog on the screen 
 * 		(2) gets the frog to jump when the user clicks the mouse. 
 * 
 * The frog should jump one square position in the direction—up, down, left, 
 * or right—that corresponds most closely to the direction from the center 
 * of the frog to the mouse position.
 * 
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class MTProb4_Frogger extends GraphicsProgram {
	private static final int SQSIZE = 75;
	private static final int NCOLS = 7;
	private static final int NROWS = 3;

	private GImage frog;
	private double frog_X;
	private double frog_Y;

	/*
	 * You may assume NCOLS is odd so that there is a center square, and you may
	 * also assume that APPLICATION_WIDTH and APPLICATION_HEIGHT have been set so
	 * the NCOLS & NROWS squares fill the window.
	 */
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;

	/*
	 * Sets the frog at the bottom-center of the Applet and adds addMouseListeners()
	 */
	public void run() {
		frog = new GImage("frog1c.png");
//		frog = new GImage("frog1c.png");
		frog_X = (NCOLS / 2 + 0.5) * SQSIZE;
		frog_Y = (NROWS - 0.5) * SQSIZE;
		add(frog, frog_X - frog.getWidth() / 2, frog_Y - frog.getHeight() / 2);
		addMouseListeners();
	}

	/* On mouseclick, return mouse coordinates (x,y). If the mouse position is  */
	public void mouseClicked(MouseEvent e) {
		double mouse_X = e.getX();
		double mouse_Y = e.getY();
		
	/* The absolute value determines distance for final leap frog location. 
	 * Relative mouse coordinates (mouse_X,mouse_Y) versus relative frog coordinates
	 * (frog_X,frog_Y), determine the vector (direction of leap).
	 * negative points as coordinates, but we can move in a negative direction.   
	 */
		if (Math.abs(mouse_X - frog_X) > Math.abs(mouse_Y - frog_Y)) {
			if (mouse_X > frog_X) {
				leapFrog(SQSIZE, 0);
			} else {
				leapFrog(-SQSIZE, 0);
			}
		} else {
			if (mouse_Y > frog_Y) {
				leapFrog(0, SQSIZE);
			} else {
				leapFrog(0, -SQSIZE);
			}
		}
	}

	private void leapFrog(double leapFrog_X, double leapFrog_Y) {
		if (frogsPerspective(frog_X + leapFrog_X, frog_Y + leapFrog_Y)) {
			frog_X += leapFrog_X;
			frog_Y += leapFrog_Y;
			frog.move(leapFrog_X, leapFrog_Y);	// moves the frog to the new coordinates
		}
	}
	/* Keeps the frog within the boundaries of the [NCOLS x NROWS] grid */
	private boolean frogsPerspective(double x, double y) {
		return (x >= 0 && x <= NCOLS * SQSIZE && y >= 0 && y <= NROWS * SQSIZE);
	}
}
