package puck2.main;

import javax.swing.JFrame;

import puck2.gui.startmenu.DisplayMenu;

public class MainClass {

	public static void main(String[] args) {
		JFrame frame = new DisplayMenu();
		frame.pack();
		frame.setSize(1040, 810);
		frame.setVisible(true);
		
	}
}
