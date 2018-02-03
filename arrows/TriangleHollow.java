package arrows;
import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

public class TriangleHollow extends PNode{
    public TriangleHollow(){
        PPath t = new PPath.Float();
        t.moveTo(0,0);
        t.lineTo(-10,10);
        t.moveTo(0,0);
        t.lineTo(10,10);
        this.setBounds(0,0,0,0);
        addChild(t);
    }
}
