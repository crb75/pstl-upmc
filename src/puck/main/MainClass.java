package puck.main;

import javax.swing.JFrame;

import puck.gui.startMenu.GenrationToDisplayMain;

public class MainClass {

	public static void main(String[] args) {
		JFrame frame = new GenrationToDisplayMain();
		frame.pack();
		frame.setSize(1040, 810);
		frame.setVisible(true);
	}

}
