package arrows;

import org.piccolo2d.PNode;

import nodes.piccolo2d.PiccoloCustomNode;

import java.awt.geom.Point2D;

public abstract class Parrow extends PNode{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Parrow() {}
	public Parrow(Point2D from, Point2D to){
    }

    protected PiccoloCustomNode from;
    protected PiccoloCustomNode to;

    public PiccoloCustomNode getFrom() {
        return from;
    }

    public PiccoloCustomNode getTo() {
        return to;
    }

    public void setFrom(PiccoloCustomNode from){
        this.from=from;
    }

    public void setTo(PiccoloCustomNode to){
        this.to=to;
    }

    public Parrow(PiccoloCustomNode from,PiccoloCustomNode to){
        this(from.getBounds().getCenter2D(),to.getBounds().getCenter2D());
        this.from=from;
        this.to=to;
    }

    public abstract Parrow redraw();

    @Override
    public boolean equals(Object arrow){
        if(!(arrow instanceof Parrow))
            return false;
        return this.from==((Parrow) arrow).getFrom()
                &&this.to==((Parrow) arrow).getTo();
    }
    
    @Override
    public int hashCode() {
    		return super.hashCode();
    }
}
