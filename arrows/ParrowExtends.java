package arrows;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

import java.awt.*;
import java.awt.geom.Point2D;

public class ParrowExtends extends Parrow{
    public ParrowExtends(Point2D from, Point2D to){
        super(from,to);
        double theta = Math.atan2(to.getY()-from.getY(),to.getX()-from.getX())+Math.toRadians(90);
        Triangle head=new Triangle(Color.WHITE);

        PPath line=PPath.createLine(from.getX(),from.getY(),to.getX(),to.getY());
        line.setStrokePaint(Color.green);
        if (from.getY() == to.getY()) {
        	theta=Math.atan2(to.getY()-from.getY(),to.getX()-from.getX())+Math.toRadians(140);
            double distance = from.distance(to);
        	line.curveTo(to.getX(), to.getY(), (float) from.getX()-distance/2, (float) from.getY()+distance,from.getX(), from.getY());
		}
      
        head.translate(to.getX(),to.getY());
        head.rotate(theta);
        addChild(line);
        addChild(head);

    }

    public ParrowExtends(PNode from, PNode to){
        this(from.getBounds().getCenter2D(),to.getBounds().getCenter2D());
        this.from=from;
        this.to=to;
    }

    @Override
    public Parrow redraw() {
        removeAllChildren();
        return new ParrowExtends(from,to);
    }
    
   
}
