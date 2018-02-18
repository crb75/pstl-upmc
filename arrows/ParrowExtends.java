package arrows;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

import nodes.piccolo2d.PiccoloCustomNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class ParrowExtends extends Parrow {
	public ParrowExtends(Point2D from, Point2D to, Point2D virtuaFrom, Point2D virtualTo) {
		super(from, to, virtuaFrom, virtualTo);
		from = virtuaFrom;
		to = virtualTo;
		Triangle head = new Triangle(Color.WHITE);

		PPath line = PPath.createLine(from.getX(), from.getY(), to.getX(), to.getY());

		double theta = Math.atan2(to.getY() - from.getY(), to.getX() - from.getX()) + Math.toRadians(90);
		head.translate(to.getX(), to.getY());
		head.rotate(theta);

		addChild(line);
		addChild(head);

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
