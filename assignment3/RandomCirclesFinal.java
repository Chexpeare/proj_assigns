package week2;
/*
 * File: RandomCircles.java
 * ------------------------
* This program draws a set of 10 circles with different sizes,
* positions, and colors. Each circle has a randomly chosen
* color, a randomly chosen radius between 5 and 50 pixels,
* and a randomly chosen position on the canvas, subject to
* the condition that the entire circle must fit inside the
* canvas without extending past the edge. 
* 
* acm.util.* package: https://cs.stanford.edu/people/eroberts/jtf/rationale/UtilPackage.html
* 
* */

// import acm.program.GraphicsProgram;
import acm.program.*;
// import java.awt.Color;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class RandomCirclesFinal extends GraphicsProgram {
	private static final double TOTAL_CIRCLES = 10;
	private static final double MIN_RADIUS = 5;
	private static final double MAX_RADIUS = 50;

	private RandomGenerator randgen = RandomGenerator.getInstance();

	public void run() { 
	/*
	 * (x, y) = coordinates for GOval
	 * (r, r) = radius of a circle 	
	 */
		
		for (int i = 1; i <= TOTAL_CIRCLES; i++) {
			double r = randgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
			double x = randgen.nextDouble(0, getWidth() - 2 * r);
			double y = randgen.nextDouble(0, getHeight() - 2 * r);
			
			GOval circle = new GOval(x, y, 2 * r, 2 * r);

			circle.setFilled(true);
			circle.setColor(randgen.nextColor());
			add(circle);
		} 
	}
}
