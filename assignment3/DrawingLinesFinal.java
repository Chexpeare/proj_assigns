package week2;

/*
 * File: DrawingLinesFinal.java
 * ----------------------------
 * Assignment: Write a GraphicsProgram that allows the user to draw lines on the canvas. 
 * Pressing the mouse button sets the starting point for the line. Dragging the mouse 
 * moves the other endpoint around as the drag proceeds. Releasing the mouse fixes the 
 * line in its current position and gets ready to start a new line. 
 * 
 * Because the original point and the mouse position appear to be joined by some elastic
 * string, this technique is called rubber-banding. 
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

/* 
 * The DrawingLinesFinal class allows users to draw lines on the canvas. Lines appear in 
 * rubberband style until mouse is released and the line is fixed at the ending position.
 * 
 */

public class DrawingLinesFinal extends GraphicsProgram {

	public void run() {
		addMouseListeners();
	}
	
/* Call on mousePressed sets the starting point (sp) for a new line */
	public void mousePressed(MouseEvent sp) {
		double x = sp.getX();
		double y = sp.getY();
		line = new GLine(x, y, x, y);
		add(line);
	}

/* Call on mouseDragged allows for rubber banding effect and sets the ending point (ep) when released */
	public void mouseDragged(MouseEvent ep) {
		double x = ep.getX();
		double y = ep.getY();
		line.setEndPoint(x, y);
	}
	
/* Private instance variables */
	private GLine line;
}

//Path: /Users/chexpeare/Tech Certifications/02_Programming Certifications/Java/Stanford 106A Downloads/Lecture 10/20-section-handout-3.pdf




