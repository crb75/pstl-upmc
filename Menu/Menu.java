package Menu;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import org.piccolo2d.PNode;

public class Menu extends PNode {
	  private List<MenuItem> items;

	    public Menu(){
	        items=new ArrayList<>();
	    }

	    public void add(MenuItem item){
	        items.add(item);
	    }

	    public void remove(MenuItem item){
	        items.remove(item);
	        removeChild(item);
	    }

	    public void draw(PNode target){

	        double x= target.getGlobalTranslation().getX()+target.getBounds().getCenterX();
	        double y = target.getGlobalTranslation().getY()+target.getBounds().getCenterY();

	        for(MenuItem m:items) {
	            m.draw(target);

	            m.setTransform(AffineTransform.getTranslateInstance(0,0));

	            m.translate(x,y);
	            addChild(m);
	            y+=m.getHeight();
	        }
	    }
}
