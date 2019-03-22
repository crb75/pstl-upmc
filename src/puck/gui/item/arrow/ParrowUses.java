package puck.gui.item.arrow;


import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.geom.Point2D;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import puck.modele.*;
import puck.gui.item.node.PiccoloCustomNode;

public class ParrowUses extends Parrow{

    private double spacing;
    private PPath line;
    
    public ParrowUses(Point2D from, Point2D to, double spacing,Point2D virtuaFrom,Point2D virtualTo){
    	super(from, to, virtuaFrom, virtualTo);
		from = virtuaFrom;
		to = virtualTo;
		TriangleHollow head = new TriangleHollow();	
		line = PPath.createLine(from.getX(), from.getY(), to.getX(), to.getY());
		line.setStroke(new BasicStroke(2));
		double theta = Math.atan2(to.getY() - from.getY(), to.getX() - from.getX()) + Math.toRadians(90);
		head.translate(to.getX(), to.getY());
		head.rotate(theta);
		addChild(line);
		addChild(head);	
    }

    public ParrowUses(PNode from, PNode to,double spacing,PNode virtualForm,PNode virtualTo){
        this(((PiccoloCustomNode)from).getRect().getGlobalBounds().getCenter2D(),
        		((PiccoloCustomNode)to).getRect().getGlobalBounds().getCenter2D(),
        		spacing,
        		((PiccoloCustomNode)virtualForm).getRect().getGlobalBounds().getCenter2D(),
        		((PiccoloCustomNode)virtualTo).getRect().getGlobalBounds().getCenter2D());
        this.from=from;
        this.to=to;
        this.virtualFrom = virtualForm;
        this.virtualto = virtualTo;
    }

    @Override
    public Parrow redraw() {
        removeAllChildren();
        return new ParrowUses(from,to,spacing,from,to);
    }

	@Override
	public Parrow redraw(PNode virtuaFrom) {
		
		removeAllChildren();
        return new ParrowUses(from,to,spacing,virtuaFrom,virtualto);
	}
	@Override
	public Parrow redrawTo(PNode virtualTo) {
		removeAllChildren();
        return new ParrowUses(from,to,spacing,virtualFrom,virtualTo);
	}
	
	public void addCard(int from, int to) {
		System.out.println("j'ajoute la cardinalité ");
		PText text= new PText("<"+from+","+to+">");
		text.setFont(new Font("Courier New", Font.BOLD, 18));
		text.setBounds(line.getGlobalFullBounds().getCenterX(),line.getGlobalFullBounds().getCenterY() , text.getWidth(), text.getHeight());
		addChild(text);
	}
	
}

