package Menu;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import arrows.ParrowExtends;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import nodes.piccolo2d.PiccoloCustomNode;
import utilities.piccolo2d.XmlToStructure;

public class CreateExtendsEdges extends JMenuItem{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;

	public CreateExtendsEdges(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes) {
		//super();
		this.setText("extends outgoing");
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		addActionListener();
	}
	public void drawExtendsEdges(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		ParrowExtends arrow = null;
		Node node = listNodes.get(pnode.getidNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		//System.out.println(node.getId());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("isa")) {
				PiccoloCustomNode dest = allPNodes.get(e.getTo());
				Point2D point = new Point((int) pnode.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (pnode.getRect().getGlobalBounds().getCenter2D().getY()
								+ pnode.getRect().getHeight() / 2));
				Point2D point2 = new Point((int) dest.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (dest.getRect().getGlobalBounds().getCenter2D().getY() + dest.getRect().getHeight() / 2));
				
				arrow = new ParrowExtends(pnode, dest);
				canvas.getLayer().addChild(arrow);
				drawExtendsEdges(dest, canvas);
			}
		}
	}
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent arg0) {
            	drawExtendsEdges(pnode,canvas);
            }    
        });
	}

}
