package display.piccolo2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.piccolo2d.PCanvas;
import org.piccolo2d.PNode;
import org.piccolo2d.extras.PFrame;
import org.piccolo2d.nodes.PPath;

import arrows.ParrowExtends;
import arrows.AbstractBezierExample;
import nodes.piccolo2d.CustomPNode;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import utilities.piccolo2d.PCustomInputEventHandler;
import utilities.piccolo2d.XmlToStructure;

public class NewDisplayDG extends PFrame {
	 private HashMap<String, CustomPNode> allPNodes = new HashMap<>();
	 private Map<String, Node> m = new XmlToStructure().parseNode();
	 private	HashMap<String, Node> listNodes = new HashMap<>(m);
	 private static final double EPSILON = 0.001;
	 private static final int ARROW_DIM = 20;
	 protected static final int DIAM = 25;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NewDisplayDG() {
		CustomPNode pnode = null ;
		for (CustomPNode node : getPackageNodes()) {
			PCustomInputEventHandler eventHandler = new  PCustomInputEventHandler(node,getCanvas(),allPNodes);
			node.addInputEventListener(eventHandler);
			getCanvas().getLayer().addChild(node);
			pnode = node ;
			//createExtendsEdges(node, getCanvas());
		}
		ArrayList<CustomPNode> list = new ArrayList<>(pnode.getChildren());

//		ParrowExtends arrow = new ParrowExtends(list.get(0).getRect().getGlobalBounds().getCenter2D(),allPNodes.get("p01").getRect().getGlobalBounds().getCenter2D());
//		Point2D piint = new Point(100,100);
//		Point2D piint2 = new Point(0,0);
//		//ParrowExtends arrow = new ParrowExtends(piint,piint2);
//		System.out.println(list.get(0).getRect().getGlobalBounds());
//        getCanvas().getLayer().addChild(arrow);
		this.setBounds(0, 0, 1024, 762);
	}

	public Collection<CustomPNode> getPackageNodes() {
		Collection<CustomPNode> listePNode = new ArrayList<>();
		Map<String, Node> m = new XmlToStructure().parseNode();
		HashMap<String, Node> listNodes = new HashMap<>(m);

		CustomPNode root = new CustomPNode();
		for (Entry<String, Node> entry : listNodes.entrySet()) {
			String key = entry.getKey();
			Node n = entry.getValue();
			if (n.getType().equals("package")) {
				Node packag = listNodes.get(key);
				CustomPNode p = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, packag.getName(),
						packag.getId());
				allPNodes.put(p.getIdNode(), p);
				p.setName(packag.getName());
				// les relation contain du package
				HashMap<String, Edge> relation = new HashMap<>(packag.getRelation());
				// collection des classes du package
				Collection<CustomPNode> children = new ArrayList<>();
				for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
					Edge e = edgeEntry.getValue();
					Node node = listNodes.get(e.getTo());
					CustomPNode pnode = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, node.getName(),
							node.getId());
					allPNodes.put(pnode.getIdNode(), pnode);
					pnode = structureToPiccolo(node, pnode);
					pnode.setName(node.getName());
					pnode.setParent(p);
					PCustomInputEventHandler eventHandler = new  PCustomInputEventHandler(pnode,getCanvas(),allPNodes);
					pnode.addInputEventListener(eventHandler);
					children.add(pnode);
					//p.addChild(pnode);				
				}			
				p.setChildren(children);
				p.setGridLayout(3);
				p.setExpandGridLayout();
				p.setParent(root);
				// p.getParent().setGridLayoutV();	
				listePNode.add(p);
			}
		}
		root.addChildren(listePNode);
		root.setChildren(listePNode);
		root.setText("root");
		root.setName("root");
		root.setGridLayout(3);
		root.setGridLayoutV();
		return root.getChildren();
	}

	
	public CustomPNode structureToPiccolo(Node node, CustomPNode pnode){	
		PCustomInputEventHandler eventHandler;
		if (pnode.getIdNode() == null) {	
			pnode = new CustomPNode(PPath.createRectangle(0, 0, 100, 100),
					null, 10, node.getName(), node.getId());
			pnode.setName(node.getName());
		}
		Collection<CustomPNode> children = new ArrayList<>();
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("contains")) {
				Node n = listNodes.get(e.getTo());
				CustomPNode pnodeBis = new CustomPNode(PPath.createRectangle(0,
						0, 100, 100), null, 10, n.getName(), n.getId());
				pnodeBis.setName(n.getName());
				pnodeBis.setParent(pnode);
				allPNodes.put(pnodeBis.getIdNode(), pnodeBis);
				eventHandler = new PCustomInputEventHandler(pnodeBis,getCanvas(),allPNodes);
				pnodeBis.addInputEventListener(eventHandler);
				children.add(pnodeBis);
				structureToPiccolo(n,pnodeBis);
			}
		}
		eventHandler = new PCustomInputEventHandler(
				pnode,getCanvas(),allPNodes);
		pnode.addInputEventListener(eventHandler);
	//	System.out.println(pnode.getIdNode());
		pnode.setChildren(children);
		pnode.setGridLayout(3);
		pnode.setExpandGridLayout();
		return pnode;			
	}
	
	public void createExtendsEdges(CustomPNode pnode, PCanvas canvas) {
		ParrowExtends arrow = null;
		for (CustomPNode custom : pnode.getChildren()) {
			Node node = listNodes.get(custom.getIdNode());
			HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("isa")) {
				System.out.println(e.getId());
				CustomPNode dest = allPNodes.get(e.getTo());
			 arrow = new ParrowExtends(custom.getRect().getGlobalBounds().getCenter2D(),dest.getRect().getGlobalBounds().getCenter2D());
			 canvas.getLayer().addChild(arrow);
			 createExtendsEdges(dest, canvas);
			}
		}
		}
	}
	public static void main(String[] args) {
		new NewDisplayDG();

	}

}