package Menu;


import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;

import java.awt.event.InputEvent;

public abstract class MenuItemEventHandler extends PBasicInputEventHandler {

    protected PNode target;

    public MenuItemEventHandler(){
        setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK));
    }

    @Override
    public abstract void mouseClicked(PInputEvent e);

    public void setTarget(PNode target){
        this.target=target;
    }
}
