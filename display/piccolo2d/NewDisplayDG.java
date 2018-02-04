package display.piccolo2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.piccolo2d.PCanvas;
import org.piccolo2d.extras.PFrame;
import org.piccolo2d.nodes.PPath;

import arrows.ParrowExtends;
import nodes.piccolo2d.CustomPNode;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import sun.awt.EventListenerAggregate;
import utilities.piccolo2d.PCustomInputEventHandler;
import utilities.piccolo2d.XmlToStructure;

public class NewDisplayDG extends PFrame {
	private HashMap<String, CustomPNode> allPNodes = new HashMap<>();
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewDisplayDG() {
		addEventListnerToNodes(getPackageNodes());
		for (CustomPNode node : getPackageNodes().getChildren()) {
			 PCustomInputEventHandler eventHandler = new PCustomInputEventHandler(node,
			 getCanvas(), allPNodes);
			 node.addInputEventListener(eventHandler);
			getCanvas().getLayer().addChild(node);
		}

		this.setBounds(0, 0, 1024, 762);
	}

	public CustomPNode getPackageNodes() {
		Collection<CustomPNode> listePNode = new ArrayList<>();
		Map<String, Node> mm = new XmlToStructure().parseNode();
		HashMap<String, Node> nodesList = new HashMap<>(mm);

		CustomPNode root = new CustomPNode();
		for (Entry<String, Node> entry : nodesList.entrySet()) {
			String key = entry.getKey();
			Node n = entry.getValue();
			if (n.getType().equals("package")) {
				Node packag = nodesList.get(key);
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
					Node node = nodesList.get(e.getTo());
					CustomPNode pnode = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, node.getName(),
							node.getId());
					allPNodes.put(pnode.getIdNode(), pnode);
					pnode = structureToPiccolo(node, pnode);
					pnode.setName(node.getName());
					pnode.setParent(p);
					children.add(pnode);
					// p.addChild(pnode);
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
		return root;
	}

	public CustomPNode structureToPiccolo(Node node, CustomPNode pnode) {
		PCustomInputEventHandler eventHandler;
		if (pnode.getIdNode() == null) {
			pnode = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, node.getName(), node.getId());
			pnode.setName(node.getName());
		}
		Collection<CustomPNode> children = new ArrayList<>();
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("contains")) {
				Node n = listNodes.get(e.getTo());
				CustomPNode pnodeBis = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, n.getName(),
						n.getId());
				pnodeBis.setName(n.getName());
				pnodeBis.setParent(pnode);
				allPNodes.put(pnodeBis.getIdNode(), pnodeBis);
				children.add(pnodeBis);
				structureToPiccolo(n, pnodeBis);
			}
		}
		eventHandler = new PCustomInputEventHandler(pnode, getCanvas(), allPNodes);
		pnode.addInputEventListener(eventHandler);
		// System.out.println(pnode.getIdNode());
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
					arrow = new ParrowExtends(custom.getRect().getGlobalBounds().getCenter2D(),
							dest.getRect().getGlobalBounds().getCenter2D());
					canvas.getLayer().addChild(arrow);
					createExtendsEdges(dest, canvas);
				}
			}
		}
	}

	public void addEventListnerToNodes(CustomPNode root) {
		PCustomInputEventHandler eventHandler;
		if (root.getChildren() != null) {

			for (CustomPNode child : root.getChildren()) {
				eventHandler = new PCustomInputEventHandler(child, getCanvas(), allPNodes);
				child.addInputEventListener(eventHandler);
				addEventListnerToNodes(child);
			}

		}

	}

	public static void main(String[] args) {
		new NewDisplayDG();

	}

}