package puck.main;

import javax.swing.JFrame;

import puck.gui.window.GenerationToDisplay;

public class MainClass {

	public static void main(String[] args) {
		JFrame frame = new GenerationToDisplay();
		frame.pack();
		frame.setSize(1040, 810);
		frame.setVisible(true);
	}

}
