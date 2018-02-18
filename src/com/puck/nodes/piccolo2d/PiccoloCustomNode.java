package com.puck.nodes.piccolo2d;



import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.piccolo2d.PCanvas;
import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import com.puck.arrows.Parrow;

public class PiccoloCustomNode extends PNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodeContent content;
	private PPath rect;
	private Collection<PiccoloCustomNode> hiddenchildren;
	private double margin = 10;
	private String idNode;
	private PiccoloCustomNode parent;
	private HashSet<Parrow> outgoing;
	private HashSet<Parrow> ingoing;

	// region getters/setters

	public PPath getRect() {
		return rect;
	}

	public NodeContent getContent() {
		return content;
	}

	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public String getidNode() {
		return idNode;
	}

	public String toString() {
		return ((PText) (content.getChild(0))).getText();
	}

	public boolean isHidden() {
		PNode parent = getParent();
		if (parent == null)
			return true;
		if (parent instanceof PiccoloCustomNode) {
			PiccoloCustomNode PCNparent = (PiccoloCustomNode) parent;
			if (PCNparent.isHidden()) {
				return true;
			}
			if (PCNparent.getChildren().contains(this))
				return false;
			else
				return true;
		} else {
			return false;
		}
	}

	public void setParentNode(PiccoloCustomNode parent) {
		this.parent = parent;
	}

	public PiccoloCustomNode getParentNode() {
		return parent;
	}

	// endregion
	public PiccoloCustomNode() {
		this.ingoing = new HashSet<>();
		this.outgoing = new HashSet<>();
		this.parent = null;
		this.hiddenchildren = new ArrayList<>();
	}

	public PiccoloCustomNode(String textContent, String idNode) {

		this.idNode = idNode;

		hiddenchildren = new ArrayList<>();
		content = new NodeContent(new PText(textContent));

		double width = margin + content.getBounds().getWidth() + margin;
		double height = margin + content.getBounds().getHeight() + margin;

		rect = PPath.createRectangle(0, 0, width, height);
		addChild(rect);
		addChild(content);
		content.translate(margin, margin);
		this.ingoing = new HashSet<>();
		this.outgoing = new HashSet<>();
		this.parent = null;

	}

	public void setChilldren(Collection<PiccoloCustomNode> children) {
		for (PiccoloCustomNode node : children) {
			node.setParentNode(this);
			hiddenchildren.add(node);
		}

		setLayout();
	}

	public Collection<PiccoloCustomNode> getChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		for (Iterator<PNode> childrenIterator = getChildrenIterator(); childrenIterator.hasNext();) {
			PNode child = childrenIterator.next();
			if (child instanceof PiccoloCustomNode) {
				children.add((PiccoloCustomNode) child);
			}
		}
		return children;
	}

	public Collection<PiccoloCustomNode> getAllChildren() {
		Collection<PiccoloCustomNode> out = new ArrayList<>();
		Collection<PiccoloCustomNode> children = getChildren();
		for (PiccoloCustomNode PCN : children)
			out.add(PCN);
		for (PiccoloCustomNode PCN : hiddenchildren)
			out.add(PCN);
		return out;
	}

	public Collection<PiccoloCustomNode> getHierarchy() {
		Collection<PiccoloCustomNode> out = new HashSet<>();
		getHierarchy_Rec(out);
		return out;
	}

	private void getHierarchy_Rec(Collection<PiccoloCustomNode> out) {
		for (PiccoloCustomNode PCN : getAllChildren()) {
			out.add(PCN);
			PCN.getHierarchy_Rec(out);
		}
	}

	public void showChildren() {
		for (PiccoloCustomNode PCN : hiddenchildren) {
			addChild(PCN);
		}
		hiddenchildren.clear();
	}

	public void hideChildren() {
		for (PiccoloCustomNode PCN : getChildren()) {
			hiddenchildren.add(PCN);
		}

		removeAllChildren();

		addChild(rect);
		addChild(content);

	}

//	public void redrawEdges(PCanvas canvas, PiccoloCustomNode clickedNode) {
//		System.out.println("Je suis dans pcustom " + this.getidNode());
//		// juste pour deplacer la fleche quand le noued qui contient la fleche est fermé
//		if (clickedNode.outgoing.size() != 0 && clickedNode.isHidden() == false) {
//			for (Parrow parrow : clickedNode.getOutgoing()) {
//				Collection<Parrow> arrowsCol = (Collection<Parrow>) clickedNode.getOutgoing().clone();
//				canvas.getLayer().removeChild(parrow);
//				clickedNode.getOutgoing().remove(parrow);
//				parrow = parrow.redraw();
//				clickedNode.getOutgoing().add(parrow);
//				canvas.getLayer().addChild(parrow);
//			}
//		}
//		Collection<PiccoloCustomNode> children;
//		if (!hiddenchildren.isEmpty()) {
//			children = hiddenchildren;
//		} else {
//			children = getAllChildren();
//		}
//		if(clickedNode.isHidden() == false) {
//		for (PiccoloCustomNode PCN : children) {
//			Collection<Parrow> arrowsCol = (Collection<Parrow>) PCN.getOutgoing().clone();
//			for (Parrow parrow : arrowsCol) {
//				if (PCN.isHidden()) {
//					canvas.getLayer().removeChild(parrow);
//					 PCN.getOutgoing().remove(parrow);
//					 parrow = parrow.redraw(this);
//					 PCN.getOutgoing().add(parrow);		 
//					 canvas.getLayer().addChild(parrow);
//				}
//				else {
//					 canvas.getLayer().removeChild(parrow);
//					 PCN.getOutgoing().remove(parrow);
//					 parrow = parrow.redraw(PCN);
//					 PCN.getOutgoing().add(parrow);		 
//					 canvas.getLayer().addChild(parrow);
//				}
//			}
//			redrawEdges(canvas, PCN);
//		}
//		}
//	}

	public void toggleChildren() {
		Collection<PiccoloCustomNode> children = getChildren();
		if (children.size() != 0)
			hideChildren();
		else
			showChildren();
	}

	public void setLayout() {
		setGridLayout(3);
	}

	// region avaliable layouts

	public void setGridLayoutH() {
		if (getChildren().size() == 0) {

			double x = 0;
			double y = 0;
			double w = margin + content.getBounds().getWidth() + margin;
			double h = margin + content.getBounds().getHeight() + margin;

			removeChild(rect);
			rect = PPath.createRectangle(x, y, w, h);
			rect = bevelOut(rect, 0);
			addChild(rect);
			addChild(content);

			return;
		}

		NodeContent content = this.content;
		Collection<PiccoloCustomNode> children = getChildren();

		double x = margin;
		double y = margin + content.getBounds().getHeight() + margin;
		double w = margin + content.getBounds().getWidth() + margin;
		double h = margin + content.getBounds().getHeight() + margin;

		PiccoloCustomNode lastChild = children.iterator().next();
		double maxHeight = lastChild.getRect().getHeight();

		// region horizontal layout
		for (PiccoloCustomNode PCN : children) {

			PCN.setTransform(AffineTransform.getTranslateInstance(0, 0));

			PCN.setGridLayoutH();

			PCN.translate(x, y);

			x += PCN.getRect().getWidth() + margin;
			w += PCN.getRect().getWidth() + margin;

			if (PCN.getRect().getHeight() > maxHeight)
				maxHeight = PCN.getRect().getHeight();
		}
		h += maxHeight + margin;
		// endregion

		removeChild(rect);
		rect = PPath.createRectangle(0, 0, w, h);
		rect = bevelIn(rect, 0);
		addChild(rect);
		addChild(content);
		addChildren(children);
	}

	public void setGridLayoutV() {
		if (getChildren().size() == 0) {

			double x = 0;
			double y = 0;
			double w = margin + content.getBounds().getWidth() + margin;
			double h = margin + content.getBounds().getHeight() + margin;

			removeChild(rect);
			rect = PPath.createRectangle(x, y, w, h);
			rect = bevelOut(rect, 0);
			addChild(rect);
			addChild(content);

			return;
		}

		PNode content = this.content;
		Collection<PiccoloCustomNode> children = getChildren();

		double x = margin + content.getBounds().getWidth() + margin;
		double y = 0;
		double w = margin + content.getBounds().getWidth() + margin;
		double h = margin + content.getBounds().getHeight() + margin;

		PiccoloCustomNode lastChild = children.iterator().next();
		double maxWidth = lastChild.getRect().getWidth();

		// region vertical layout
		for (PiccoloCustomNode PCN : children) {

			PCN.setTransform(AffineTransform.getTranslateInstance(0, 0));

			PCN.setGridLayoutV();

			PCN.translate(x, y);

			y += PCN.getRect().getHeight() + margin;
			h += PCN.getRect().getHeight() + margin;

			if (PCN.getRect().getWidth() > maxWidth)
				maxWidth = PCN.getRect().getWidth();

		}
		w += maxWidth + margin;
		// endregion

		removeChild(rect);
		rect = PPath.createRectangle(0, 0, w, h);
		rect = bevelIn(rect, 0);
		addChild(rect);
		addChild(content);
		addChildren(children);
	}

	// TODO this function breaks the layout when ckick on the first child of the
	// last line
	public void setGridLayout(int cap) {

		if (getChildren().size() == 0) {
			double x = 0;
			double y = 0;
			double w = margin + content.getBounds().getWidth() + margin;
			double h = margin + content.getBounds().getHeight() + margin;

			removeChild(rect);
			rect = PPath.createRectangle(x, y, w, h);
			rect = bevelOut(rect, 0);
			addChild(rect);
			addChild(content);
		} else {
			double x = margin;
			double y = margin + content.getHeight() + margin;
			double w = margin + content.getWidth() + margin;
			double h = margin + content.getHeight() + margin;

			PiccoloCustomNode firstChild = getChildren().iterator().next();
			double maxHeight = firstChild.getContent().getHeight();
			double maxWidth = firstChild.getContent().getWidth();
			int i = 0;
			for (PiccoloCustomNode PCN : getChildren()) {
				PCN.setGridLayout(cap);
				if (i == cap) {
					i = 1;
					x = margin;
					y += margin + maxHeight;
					h += margin + PCN.getRect().getHeight();
				} else {
					w = x + PCN.getRect().getWidth() + margin;
					i++;
				}

				if (PCN.getRect().getHeight() > maxHeight)
					maxHeight = PCN.getRect().getHeight();

				if (w > maxWidth)
					maxWidth = w;

				PCN.setTransform(AffineTransform.getTranslateInstance(0, 0));
				PCN.translate(x, y);
				x += PCN.getRect().getWidth() + margin;
			}

			removeChild(rect);
			rect = PPath.createRectangle(x, y, maxWidth, h + maxHeight + margin);
			rect = bevelIn(rect, 0);

			addChild(rect);
			addChild(content);
			addChildren(getChildren());

			// if (outgoing.size() != 0) {
			// for (Parrow parrow : outgoing) {
			// System.out.println(parrow.getFrom().getidNode());
			// System.out.println(parrow.getTo().getidNode());
			//
			// //parrow.redraw(this);
			// }
			// }
		}
	}

	// endregion

	public PPath bevelOut(PPath rectangle, int bevel) {
		double w = rectangle.getWidth();
		double h = rectangle.getHeight();

		PPath background = PPath.createRectangle(0, 0, w, h);
		background.setPaint(Color.WHITE);
		PPath borderTop = PPath.createRectangle(0, 0, w, bevel);
		borderTop.setPaint(Color.LIGHT_GRAY);
		borderTop.setStroke(null);
		background.addChild(borderTop);
		PPath borderLeft = PPath.createRectangle(0, 0, bevel, h);
		borderLeft.setPaint(Color.LIGHT_GRAY);
		borderLeft.setStroke(null);
		background.addChild(borderLeft);
		PPath borderRight = PPath.createRectangle(w - bevel, 0, bevel, h);
		borderRight.setPaint(Color.DARK_GRAY);
		borderRight.setStroke(null);
		background.addChild(borderRight);
		PPath borderBottom = PPath.createRectangle(0, h - bevel, w, bevel);
		borderBottom.setPaint(Color.DARK_GRAY);
		borderBottom.setStroke(null);
		background.addChild(borderBottom);

		return background;
	}

	public PPath bevelIn(PPath rectangle, int bevel) {
		double w = rectangle.getWidth();
		double h = rectangle.getHeight();

		PPath background = PPath.createRectangle(0, 0, w, h);
		background.setPaint(Color.WHITE);
		PPath borderTop = PPath.createRectangle(0, 0, w, bevel);
		borderTop.setPaint(Color.DARK_GRAY);
		borderTop.setStroke(null);
		background.addChild(borderTop);
		PPath borderLeft = PPath.createRectangle(0, 0, bevel, h);
		borderLeft.setPaint(Color.DARK_GRAY);
		borderLeft.setStroke(null);
		background.addChild(borderLeft);
		PPath borderRight = PPath.createRectangle(w - bevel, 0, bevel, h);
		borderRight.setPaint(Color.LIGHT_GRAY);
		borderRight.setStroke(null);
		background.addChild(borderRight);
		PPath borderBottom = PPath.createRectangle(0, h - bevel, w, bevel);
		borderBottom.setPaint(Color.LIGHT_GRAY);
		borderBottom.setStroke(null);
		background.addChild(borderBottom);

		return background;
	}

	public void updateContentBoundingBoxes(boolean debug, PCanvas canvas) {

		updateTextBoundingBoxes(false);

		Point2D GLobalTranslation = content.getGlobalTranslation();

		double x = GLobalTranslation.getX();
		double y = GLobalTranslation.getY();
		double w = content.getBounds().getWidth();
		double h = content.getBounds().getHeight();
		content.setBounds(x, y, w, h);

		if (debug)
			canvas.getLayer().addChild(PPath.createRectangle(x, y, w, h));

		for (PiccoloCustomNode PCN : getChildren())
			PCN.updateContentBoundingBoxes(debug, canvas);
	}

	public void updateTextBoundingBoxes(boolean debug) {

		Point2D globalTranslation = content.getText().getGlobalTranslation();
		Point2D contentGlobalTranslation = content.getGlobalTranslation();

		double x = globalTranslation.getX() - contentGlobalTranslation.getX();
		double y = globalTranslation.getY() - contentGlobalTranslation.getY();
		double w = content.getText().getBounds().getWidth();
		double h = content.getText().getBounds().getHeight();

		content.getText().setBounds(x, y, w, h);

		if (debug)
			content.addChild(PPath.createRectangle(x, y, w, h));

	}

	public void expandAll() {
		if (hiddenchildren.size() != 0) {
			toggleChildren();
		}
		for (PiccoloCustomNode PCN : getChildren())
			PCN.expandAll();
	}

	public void collapseAll() {
		if (hiddenchildren.size() == 0) {
			toggleChildren();
		}
		for (PiccoloCustomNode PCN : getAllChildren())
			PCN.collapseAll();
	}

	public PiccoloCustomNode getHigherParent() {
		if (getParentNode() == null)
			return this;
		if (isHidden())
			return getParentNode().getHigherParent();
		return this;
	}

	public ArrayList<PiccoloCustomNode> getAscendency() {
		ArrayList<PiccoloCustomNode> out = new ArrayList<>();
		getAcendency_REC(out);
		return out;
	}

	private void getAcendency_REC(ArrayList<PiccoloCustomNode> out) {
		if (getParentNode() == null) {
			out.add(this);
			return;
		}
		out.add(this);
		getParentNode().getAcendency_REC(out);
	}

	public void focus() {
		Collection<PiccoloCustomNode> ascendency = getAscendency();
		for (PiccoloCustomNode PCN : ascendency) {
			PCN.showChildren();
		}
	}

	public HashSet<Parrow> getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(HashSet<Parrow> outgoing) {
		this.outgoing = outgoing;
	}

	public HashSet<Parrow> getIngoing() {
		return ingoing;
	}

	public void setIngoing(HashSet<Parrow> ingoing) {
		this.ingoing = ingoing;
	}

}
