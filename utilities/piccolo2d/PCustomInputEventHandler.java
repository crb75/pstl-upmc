package utilities.piccolo2d;

import java.awt.Color;
import java.awt.event.InputEvent;

import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;

import modals.piccolo2d.CustomPNode;

public class PCustomInputEventHandler extends PBasicInputEventHandler {
	private CustomPNode pnode;

	public PCustomInputEventHandler(CustomPNode pnode) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
	}

	public void mousePressed(PInputEvent aEvent) {
		if (aEvent.isLeftMouseButton()) {
			System.out.println(pnode.getIdNode());
			pnode.setCollapsedGridLayout();
		}
		if (aEvent.isRightMouseButton()) {
			pnode.expandChildren();
			
		}
		
	}
}
