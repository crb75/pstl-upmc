package arrows;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

import nodes.piccolo2d.PiccoloCustomNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class ParrowExtends extends Parrow {
	/**
	 * 
	 */
	private PiccoloCustomNode from;
	private PiccoloCustomNode to;
	private static final long serialVersionUID = 1L;

	public ParrowExtends(Point2D from, Point2D to) {

		super(from, to);
		double theta = Math.atan2(to.getY() - from.getY(), to.getX() - from.getX()) + Math.toRadians(90);
		Triangle head = new Triangle(Color.WHITE);
		System.out.println(this.to.getidNode());

		PPath line = PPath.createLine(from.getX(), from.getY(), to.getX(), to.getY());
		line.setStrokePaint(Color.green);
		head.translate(to.getX(), to.getY());
		head.rotate(theta);
		addChild(line);
		addChild(head);

	}

	public ParrowExtends(PiccoloCustomNode from, PiccoloCustomNode to) {
		this.from = from;
		this.to = to;
		
		Point2D fromp = new Point((int) from.getRect().getGlobalBounds().getCenter2D().getX(),
				(int) (from.getRect().getGlobalBounds().getCenter2D().getY()
						+ from.getRect().getHeight() / 2));
		Point2D top = new Point((int) to.getRect().getGlobalBounds().getCenter2D().getX(),
				(int) (to.getRect().getGlobalBounds().getCenter2D().getY() + to.getRect().getHeight() / 2));
		// System.out.println(top);
		double theta = Math.atan2(top.getY() - fromp.getY(), top.getX() - fromp.getX()) + Math.toRadians(90);
		Triangle head = new Triangle(Color.WHITE);
		

		PPath line = PPath.createLine(fromp.getX(), fromp.getY(), top.getX(), top.getY());
		line.setStrokePaint(Color.black);
		if (this.to.getidNode().contains("i")) {
			Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
			line.setStroke(dashed);
		}
		head.translate(top.getX(), top.getY());
		head.rotate(theta);
		addChild(line);
		addChild(head);

	}

	@Override
	public Parrow redraw() {
		removeAllChildren();
		return new ParrowExtends(this.from, this.to);
	}

}
