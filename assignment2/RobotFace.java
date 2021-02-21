package week2;

/*
 * FileName: RobotFace.java
 * ------------------------
 * getWidth();	-----> Applet Width: 754
 * getHeight();	-----> Applet Height: 492
 * 
 * Draw a robot-looking face consisting of four parts: a head, two eyes, 
 * and a mouth—which are arranged as follows:
 * 
 * • HEAD: The head is a big rectangle whose dimensions are given by the named
 * constants HEAD_WIDTH and HEAD_HEIGHT. The interior of the head is gray, although it
 * should be framed in black.
 * 
 * • EYES: The eyes should be cricles whose radius in pixels is given by the named
 * constant EYE_RADIUS. The centers of the eyes should be set horizontally a quarter of
 * the width of the head in from either edge, and one quarter of the distance down from
 * the top of the head. The eyes are yellow.
 * 
 * • MOUTH: The mouth should be centered with respect to the head in the x-dimension
 * and one quarter of the distance up from the bottom of the head in the y-dimension.
 * 
 * The dimensions of the mouth are given by the named constants:
 * MOUTH_WIDTH and MOUTH_HEIGHT. The mouth is white.
 * 
 * Finally, the robot face should be centered in the graphics window
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	private static final int HEAD_WIDTH = 100;
	private static final int HEAD_HEIGHT = 150;
	private static final int MOUTH_WIDTH = 60;
	private static final int MOUTH_HEIGHT = 20;
	private static final int EYE_RADIUS = 10;

	public void run() {
		double cx = getWidth()/2;
		double cy = getHeight()/2;

		// Calculates x,y for the top Left point of Head
		double hx = cx - HEAD_WIDTH / 2;
		double hy = cy - HEAD_HEIGHT / 2;
		drawHead(hx, hy);

		// Calculates x,y for the top Left point of Mouth
		double mx = cx - MOUTH_WIDTH / 2;
		double my = cy + MOUTH_HEIGHT;
		drawMouth(mx, my);

		// Calculate x,y for the center point of Left Eye
		double lex = cx - HEAD_WIDTH / 4;
		double ley = cy - HEAD_HEIGHT / 4;
		drawLeftEye(lex, ley);

		// Calculate x,y for the center point of Right Eye
		double rex = cx + HEAD_WIDTH / 4;
		double rey = cy - HEAD_HEIGHT / 4;
		drawRightEye(rex, rey);
	}
	
	private void drawHead(double hx, double hy) {
		GRect head = new GRect(hx, hy, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		add(head);
	}

	private void drawMouth(double mx, double my) {
		GRect mouth = new GRect(mx, my, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}

	private void drawLeftEye(double lex, double ley) {
		double x = lex - EYE_RADIUS;
		double y = ley - EYE_RADIUS;

		GOval lefteye = new GOval(x, y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		lefteye.setFilled(true);
		lefteye.setColor(Color.YELLOW);
		add(lefteye);
	}

	private void drawRightEye(double rex, double rey) {
		double x = rex - EYE_RADIUS;
		double y = rey - EYE_RADIUS;

		GOval righteye = new GOval(x, y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		righteye.setFilled(true);
		righteye.setColor(Color.YELLOW);
		add(righteye);
	}

}
