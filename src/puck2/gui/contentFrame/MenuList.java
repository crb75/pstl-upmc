package puck2.gui.contentFrame;

import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwing;
import org.piccolo2d.extras.pswing.PSwingCanvas;


//MEENU GENERE QUAND ON FAIT CLICK DROIT

@SuppressWarnings("serial")
public class MenuList extends JPopupMenu{

	private List<JMenuItem> items;
	private PSwingCanvas canvas;
	private Point2D point;
	private PNode p;
	private boolean hidden;
	
	public MenuList() {
		this.p = new PNode();
		hidden = true;	
	}
	
	

	public void drawMenu() {
		if (point != null && canvas != null) {
			p.addChild(new PSwing(this));
			p.setOffset(point);
			hidden = false;
			canvas.getLayer().addChild(p);
			System.err.println("canvas menu "+System.identityHashCode(canvas));

		}
	}

	public void hideMenu() {
		this.removeAll();
		if (canvas != null) {
			canvas.getLayer().removeChild(p);
		}
		hidden = true;
	}

	public PSwingCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(PSwingCanvas canvas) {
		this.canvas = canvas;
	}

	public List<JMenuItem> getItems() {
		return items;
	}

	public void setItems(List<JMenuItem> items) {
		this.items = items;
	}

	public Point2D getPoint() {
		return point;
	}

	public void setPoint(Point2D point) {
		this.point = point;
	}

	public PNode getP() {
		return p;
	}

	public void setP(PNode p) {
		this.p = p;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	// An inner class to show when popup events occur
	
	@Override
	public void show() {
		drawMenu();
	}

	@Override
	public void hide() {
		hideMenu();
	}
	
}
