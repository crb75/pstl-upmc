package Menu;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import java.awt.*;


public class MenuItem extends PNode {
    private PPath rect;
    private PText text;

    private int margin=5;

    private MenuItemEventHandler e;

    //region getters/setters
        public double getHeight(){
            return rect.getHeight();
        }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }
    //endregion

    public MenuItem(String name){
        this.e=e;
        text=new PText(name);
        rect=PPath.createRectangle(0,0,margin+text.getWidth()+margin,margin+text.getHeight()+margin);
        text.translate(margin,margin);
        rect.setPaint(Color.WHITE);
        addChild(rect);
        addChild(text);
       // this.addInputEventListener(e);
    }
    public void draw(PNode target){
        e.setTarget(target);
        //addChild(rect);
        //addChild(text);
    }

    @Override
    public String toString(){
        return text.getText();
    }
}
