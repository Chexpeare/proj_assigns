package week5;

/**
 * File: BoxDiagram.java
 * ---------------------
 * Week 5 Assignment #7: Using interactors (Event Driven Programming)
 * Build a framework for an interactive design tool that allows the user to arrange boxes with 
 * labels on the window. The starting configuration for the program presents an empty graphics 
 * canvas and a control bar containing a JLabel, a JTextField, and three JButtons. 
 * 
 * The most important operation in the program is to be able to add a new box to the screen, 
 * which you do by typing the name of the box in the JTextField and clicking the Add button. 
 * Doing so creates a new labeled box with that name in the center of the window.
 * 
 * For this simple version of the application, you may assume that the box always has constant 
 * dimensions, as specified by the following constant definitions:
 *       private static final double BOX_WIDTH = 120;
 *       private static final double BOX_HEIGHT = 50;
 * Once you have created a labeled box, your program should allow you to move the box as a unit 
 * by dragging it with the mouse. Because the outline and the label must move together, it makes 
 * sense to combine the GRect and GLabel into a GCompound and then use code similar to that in 
 * Figure 10-4 TASOJ, p. 359: (Program to drag objects on the canvas) in the book to implement 
 * the dragging operation.
 * 
 * The ability to create new boxes and drag them to new positions makes it possible to draw box 
 * diagrams containing an arbitrary number of labeled boxes. For example, you could add three 
 * more boxes with names GraphicsProgram, ConsoleProgram, and DialogProgram respectively, and 
 * drag them around to create a diagram of the Program class hierarchy.
 * 
 * The other two buttons in the control strip are Remove and Clear. The Remove button should 
 * delete the box whose name appears in the JTextField; the Clear button should remove all of 
 * the boxes. Note that you do not need to worry about the user trying to create multiple boxes 
 * with the same name–you can assume that all box names are unique. 
 * 
 */

import acm.program.*;
import acm.graphics.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*; // generates buttons 

public class BoxDiagram extends GraphicsProgram {

	/* Private constants */
	private static final int MAX_TEXT = 25;
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	/* Private instance variables */
	private HashMap<String, GObject> textEntries;
	private GObject currentObject;
	private GPoint newPoint;
	private JTextField nameField;
	private JButton addButton;
	private JButton removeButton;
	private JButton clearButton;

	/*
	 * Initialization code: needs to be executed before the program starts.
	 */
	public void init() {
		textEntries = new HashMap<String, GObject>();
		createDialogBox();
		addActionListeners();
		addMouseListeners();
	}

	/* Text Field and Buttons */
	private void createDialogBox() {
		nameField = new JTextField(MAX_TEXT);
		nameField.addActionListener(this);
		
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		clearButton = new JButton("Clear");
		
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
	}

	/* Generates a box with the given name at the center of the window */
	private void addBox(String name) {
		GCompound box = new GCompound();
		GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel label = new GLabel(name);
		box.add(outline, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
		box.add(label, -label.getWidth() / 2, label.getAscent() / 2);
		add(box, getWidth() / 2, getHeight() / 2);
		textEntries.put(name, box);
	}

	/* Removes selected box */
	private void removeBox(String name) {
		GObject obj = textEntries.get(name);
		if (obj != null) {
			remove(obj);
		}
	}

	/* Removes all boxes in the textEntries table */
	private void removeContents() {
		Iterator<String> iterator = textEntries.keySet().iterator();
		while (iterator.hasNext()) {
			removeBox(iterator.next());
		}
		textEntries.clear();
	}

	/* TASOJ, p. 363-4: Response to actions called after clicking on a button */ 
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == addButton || source == nameField) {
			addBox(nameField.getText());
		} else if (source == removeButton) {
			removeBox(nameField.getText());
		} else if (source == clearButton) {
			removeContents();
		}
	}

	/* Records the coordinates of the mouse click */ 
	public void mousePressed(MouseEvent e) {
		newPoint = new GPoint(e.getPoint());
		currentObject = getElementAt(newPoint);
	}

	/* Repositions the rectangle */ 
	public void mouseDragged(MouseEvent e) {
		if (currentObject != null) {
			currentObject.move(e.getX() - newPoint.getX(), e.getY() - newPoint.getY());
			newPoint = new GPoint(e.getPoint());
		}
	}

	/* Selection: Sends the clicked object to the front */ 
	public void mouseClicked(MouseEvent e) {
		if (currentObject != null)
			currentObject.sendToFront();
	}

}










