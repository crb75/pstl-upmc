package Menu;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import arrows.ParrowUses;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import nodes.piccolo2d.PiccoloCustomNode;
import utilities.piccolo2d.XmlToStructure;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

public class CreateUsesEdges extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;

	public CreateUsesEdges(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,Menu menu) {
		//super();
		this.setText("uses outgoing");
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		addActionListener();
	}

	public void DrawEdges(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		ParrowUses arrow = null;
		Node node = listNodes.get(pnode.getidNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
	//	System.out.println(node.getId());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("uses")) {
				PiccoloCustomNode dest = allPNodes.get(e.getTo());
				Point2D point = new Point((int) pnode.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (pnode.getRect().getGlobalBounds().getCenter2D().getY()
								+ pnode.getRect().getHeight() / 2));
				Point2D point2 = new Point((int) dest.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (dest.getRect().getGlobalBounds().getCenter2D().getY() + dest.getRect().getHeight() / 2));

				arrow = new ParrowUses(point, point2);
				canvas.getLayer().addChild(arrow);
				DrawEdges(dest, canvas);
			}
		}
		this.menu.hideMenu();
	}
	
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent arg0) {
            	DrawEdges(pnode,canvas);
            }    
        });
	}
}
