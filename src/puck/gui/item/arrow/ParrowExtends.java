package puck.gui.item.arrow;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Point2D;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import puck.gui.item.node.PiccoloCustomNode;

public class ParrowExtends extends Parrow {
    final static float dash1[] = {10.0f};
	final static BasicStroke dashed =
            new BasicStroke(2.0f,
                            BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_MITER,
                            10.0f, dash1, 0.0f);
	public ParrowExtends(Point2D from, Point2D to, Point2D virtuaFrom, Point2D virtualTo) {
		super(from, to, virtuaFrom, virtualTo);
		from = virtuaFrom;
		to = virtualTo;
		Triangle head = new Triangle(Color.WHITE);

		PPath line = PPath.createLine(from.getX(), from.getY(), to.getX(), to.getY());
		line.setStroke(dashed);
		double theta = Math.atan2(to.getY() - from.getY(), to.getX() - from.getX()) + Math.toRadians(90);
		head.translate(to.getX(), to.getY());
		head.rotate(theta);

		addChild(line);
		addChild(head);
		
		PText text= new PText("arrowExtends");
		text.setBounds((from.getX()+to.getX())/2, (from.getY()+to.getY())/2, text.getWidth(), text.getHeight());
		text.rotateInPlace(line.getGlobalRotation());
		addChild(text);

	}

	public ParrowExtends(PNode from, PNode to, PNode virtualForm, PNode virtualTo) {
		this(((PiccoloCustomNode) from).getRect().getGlobalBounds().getCenter2D(),
				((PiccoloCustomNode) to).getRect().getGlobalBounds().getCenter2D(),
				((PiccoloCustomNode) virtualForm).getRect().getGlobalBounds().getCenter2D(),
				((PiccoloCustomNode) virtualTo).getRect().getGlobalBounds().getCenter2D());
		this.from = from;
		this.to = to;
		this.virtualFrom = virtualForm;
		this.virtualto = virtualTo;
	}

	@Override
	public Parrow redraw() {
		removeAllChildren();
		return new ParrowExtends(from, to, from, to);
	}

	@Override
	public Parrow redraw(PNode virtuaFrom) {
		removeAllChildren();
		return new ParrowExtends(from, to, virtuaFrom, to);
	}

	@Override
	public Parrow redrawTo(PNode virtualTo) {
		removeAllChildren();
		return new ParrowExtends(from, to, virtualFrom, virtualTo);
	}

}
