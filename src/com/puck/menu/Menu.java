package com.puck.menu;


import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwing;
import org.piccolo2d.extras.pswing.PSwingCanvas;


public class Menu extends JPopupMenu {
	private List<JMenuItem> items;
	private PSwingCanvas canvas;
	private Point2D point;
	private PNode p;
	public Menu() {
		this.p = new PNode();
	}

	public Menu(List<JMenuItem> items,PSwingCanvas canvas,Point2D point) {
		this.items = items;
		this.canvas = canvas;
		this.point = point;
		this.p = new PNode();
		
	}
	
	public void drawMenu() {
		//canvas.getLayer().removeChild(p);
        p.addChild(new PSwing(this));
        p.setOffset(point);       
        canvas.getLayer().addChild(p);
	}
	public void hideMenu() {
		canvas.getLayer().removeChild(p);
		
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
	
	
	
}
