package puck2.gui.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import puck2.gui.contentFrame.MenuList;


// Listener for Pnode click 
public class MousePopupListener extends MouseAdapter {
	

	private MenuList menu;
	
	public MousePopupListener(MenuList menu) {
		this.menu = menu;
	}

	
    public void mousePressed(MouseEvent e) {
    	System.out.println("j'ai detecte click press");
      checkPopup(e);
    }

    public void mouseClicked(MouseEvent e) {
    	System.out.println("j'ai detecte click click");
      checkPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
      checkPopup(e);
    }

    private void checkPopup(MouseEvent e) {
      if (e.isPopupTrigger()) {
	    	System.out.println("popuptrigger");

    	 if (menu.isHidden()) {
    		System.out.println("menu hidden");
    		 menu.show();
		 }else {
			 menu.hide();
		 }
    		 
	
      }
    }
  }