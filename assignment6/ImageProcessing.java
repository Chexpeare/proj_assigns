package week4;

/**
 * Filename: ImageProcessing.java
 * ------------------------------
 * Assignment: Write a method flipHorizontal that works similarly to the 
 * flipVertical method presented in the chapter (Chapter 11, exercise 12, page 458) 
 * except that it reverses the picture in the horizontal dimension. 
 */

import acm.program.*;
import acm.graphics.*;

public class ImageProcessing extends GraphicsProgram {
	
/**	
 * Coordinates for flipped image: (X_POS, Y_POS) 
 * Coordinates for original image: (0,0) 
 */	
	private static final int X_POS = 340;
	private static final int Y_POS = 0;
	
	public void run() {
		GImage image = new GImage("MeditatingYogi2.jpeg");
		add(image,0,0);
		add(flipHorizontal(image), X_POS, Y_POS);
	}
	
/** 
 * This method reverses the image in the horizontal dimension 
 */
	private GImage flipHorizontal(GImage image) {
		int[][] array = image.getPixelArray();
		//width in pixels of each row of image
		int width = array[0].length;
		//loops through each row of the image
		for (int i = 0; i < array.length; i++) {
			//in each row flip each pixel horizontally
			for (int p1 = 0; p1 < width / 2; p1++) {
				int p2 = width - p1 - 1;
				int temp = array[i][p1];
				array[i][p1] = array[i][p2];
				array[i][p2] = temp;
			}
		}
		return new GImage(array);
	}
}










