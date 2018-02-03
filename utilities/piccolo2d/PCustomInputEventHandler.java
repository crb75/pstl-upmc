package utilities.piccolo2d;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.piccolo2d.PCanvas;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;

import arrows.ParrowExtends;
import arrows.ParrowUses;
import nodes.piccolo2d.CustomPNode;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;

public class PCustomInputEventHandler extends PBasicInputEventHandler {
	private CustomPNode pnode;
	private PCanvas canvas;
	HashMap<String, CustomPNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);

	public PCustomInputEventHandler(CustomPNode pnode, PCanvas canvas, HashMap<String, CustomPNode> allPNodes) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
		this.canvas = canvas;
		this.allPNodes = allPNodes;
	}

	public PCustomInputEventHandler(CustomPNode pnode) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;

	}

	public void mousePressed(PInputEvent aEvent) {
		// System.out.println(aEvent.getPickedNode().getBounds().getHeight());
		// System.out.println(pnode.getRect().getBounds().getHeight());
		// System.out.println(pnode.getName());
		try {
			if (aEvent.getClickCount() == 2) {
				if (aEvent.isLeftMouseButton() && (aEvent.getPickedNode().getBounds().getHeight() == pnode.getRect()
						.getBounds().getHeight())) {
					System.out.println(pnode.getIdNode());
					pnode.setCollapsedGridLayout();
					CustomPNode node = pnode;
					while (!pnode.getParent().getName().equals("root")) {
						pnode.getParent().expandChildren();
						pnode = pnode.getParent();
					}
					pnode = node;

				}
				if (aEvent.isRightMouseButton()) {
					pnode.expandChildren();

				}
			}
			if (aEvent.getClickCount() == 1) {
				if (aEvent.isLeftMouseButton() && (aEvent.getPickedNode().getBounds().getHeight() == pnode.getRect()
						.getBounds().getHeight())) {
					System.out.println(pnode.getIdNode());
					createExtendsEdges(pnode, canvas);
				}
				if (aEvent.isRightMouseButton() && (aEvent.getPickedNode().getBounds().getHeight() == pnode.getRect()
						.getBounds().getHeight())) {
					System.out.println(pnode.getIdNode());
					createUsesEdges(pnode, canvas);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createExtendsEdges(CustomPNode pnode, PCanvas canvas) {
		ParrowExtends arrow = null;
		Node node = listNodes.get(pnode.getIdNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		System.out.println(node.getId());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("isa")) {
				CustomPNode dest = allPNodes.get(e.getTo());
				Point2D point =  new Point((int)pnode.getRect().getGlobalBounds().getCenter2D().getX(),(int)(pnode.getRect().getGlobalBounds().getCenter2D().getY() + pnode.getRect().getHeight()/2));
				Point2D point2 =  new Point((int)dest.getRect().getGlobalBounds().getCenter2D().getX(),(int)(dest.getRect().getGlobalBounds().getCenter2D().getY() + dest.getRect().getHeight()/2));

				arrow = new ParrowExtends(point,point2);
				canvas.getLayer().addChild(arrow);
				createExtendsEdges(dest, canvas);
			}
		}
	}
	public void createUsesEdges(CustomPNode pnode, PCanvas canvas) {
		ParrowUses arrow = null;
		Node node = listNodes.get(pnode.getIdNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		System.out.println(node.getId());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("uses") ) {
				CustomPNode dest = allPNodes.get(e.getTo());
				Point2D point =  new Point((int)pnode.getRect().getGlobalBounds().getCenter2D().getX(),(int)(pnode.getRect().getGlobalBounds().getCenter2D().getY() + pnode.getRect().getHeight()/2));
				Point2D point2 =  new Point((int)dest.getRect().getGlobalBounds().getCenter2D().getX(),(int)(dest.getRect().getGlobalBounds().getCenter2D().getY() + dest.getRect().getHeight()/2));

				arrow = new ParrowUses(point,point2);
				canvas.getLayer().addChild(arrow);
				createUsesEdges(dest, canvas);
			}
		}
	}
}