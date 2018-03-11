package com.puck.menu;

import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwing;
import org.piccolo2d.extras.pswing.PSwingCanvas;

public class Menu extends JPopupMenu {
	private List<JMenuItem> items;
	private PSwingCanvas canvas;
	private Point2D point;
	private PNode p;
	private boolean hidden;

	public Menu() {
		this.p = new PNode();
		hidden = true;
		
	}

	// public Menu(List<JMenuItem> items,PSwingCanvas canvas,Point2D point) {
	// System.out.println("je suis la ");
	// this.items = items;
	// this.canvas = canvas;
	// this.point = point;
	// this.p = new PNode();
	// p.addChild(new PSwing(this));
	// p.setOffset(point);
	// hidden = true ;
	//
	// }

	public void drawMenu() {
		if (point != null && canvas != null) {
			p.addChild(new PSwing(this));
			p.setOffset(point);
			hidden = false;
			canvas.getLayer().addChild(p);
		}
	}

	public void hideMenu() {
		this.removeAll();
		canvas.getLayer().removeChild(p);
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
