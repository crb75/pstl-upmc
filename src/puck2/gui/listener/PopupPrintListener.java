package puck2.gui.listener;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class PopupPrintListener implements PopupMenuListener {

	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		System.out.println("Popup menu will be visible!");
	}

	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		System.out.println("Popup menu will be invisible!");
	}

	public void popupMenuCanceled(PopupMenuEvent e) {
		System.out.println("Popup menu is hidden!");
	}

}
