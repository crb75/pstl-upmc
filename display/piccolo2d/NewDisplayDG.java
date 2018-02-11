package display.piccolo2d;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;




import org.piccolo2d.extras.pswing.PSwingCanvas;



import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import nodes.piccolo2d.PiccoloCustomNode;
import utilities.piccolo2d.PCustomInputEventHandler;
import utilities.piccolo2d.XmlToStructure;

public class NewDisplayDG extends JFrame {
	private HashMap<String, PiccoloCustomNode> allPNodes = new HashMap<>();
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	private PiccoloCustomNode root;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewDisplayDG(PSwingCanvas canvas) {
		root = getPackageNodes();
		root.collapseAll();
		//root.setLayout();
		addEvent(root, root,canvas);
		// createExtendsEdges(root, getCanvas());
		canvas.getLayer().addChild(root);
	}

	public PiccoloCustomNode getPackageNodes() {
		Collection<PiccoloCustomNode> listePNode = new ArrayList<>();
		Map<String, Node> mm = new XmlToStructure().parseNode();
		HashMap<String, Node> nodesList = new HashMap<>(mm);

		PiccoloCustomNode root = new PiccoloCustomNode("root", "r01");
		for (Entry<String, Node> entry : nodesList.entrySet()) {
			String key = entry.getKey();
			Node n = entry.getValue();
			if (n.getType().equals("package")) {
				Node packag = n;
				PiccoloCustomNode p = new PiccoloCustomNode(packag.getName(), packag.getId());
				allPNodes.put(p.getidNode(), p);
				p.setName(packag.getName());
				// les relation contain du package
				HashMap<String, Edge> relation = new HashMap<>(packag.getRelation());
				// collection des classes du package
				Collection<PiccoloCustomNode> children = new ArrayList<>();
				for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
					Edge e = edgeEntry.getValue();
					Node node = nodesList.get(e.getTo());
					PiccoloCustomNode pnode;
					if (allPNodes.containsKey(node.getId())) {
						listePNode.remove(allPNodes.get(node.getId()));
						pnode = allPNodes.get(node.getId());
						pnode.setName(node.getName());
						children.add(pnode);
					} else {
						pnode = new PiccoloCustomNode(node.getName(), node.getId());
						allPNodes.put(pnode.getidNode(), pnode);
						pnode = structureToPiccolo(node, pnode);
						pnode.setName(node.getName());
						pnode.setParentNode(p);
						children.add(pnode);
					}
				}
				p.setChilldren(children);
				p.setParentNode(root);
				listePNode.add(p);

			}
		}
		root.addChildren(listePNode);
		root.setName("root");
		return root;
	}

	public PiccoloCustomNode structureToPiccolo(Node node, PiccoloCustomNode pnode) {
		if (pnode.getidNode() == null) {
			pnode = new PiccoloCustomNode(node.getName(), node.getId());
			pnode.setName(node.getName());
		}
		Collection<PiccoloCustomNode> children = new ArrayList<>();
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("contains")) {
				Node n = listNodes.get(e.getTo());
				PiccoloCustomNode pnodeBis = new PiccoloCustomNode(n.getName(), n.getId());
				pnodeBis.setName(n.getName());
				pnode.setParentNode(pnode);
				allPNodes.put(pnodeBis.getidNode(), pnodeBis);
				children.add(pnodeBis);
				structureToPiccolo(n, pnodeBis);
			}
		}

		pnode.setChilldren(children);
		return pnode;
	}

//	public void createExtendsEdges(PiccoloCustomNode pnode, PCanvas canvas) {
//		ParrowExtends arrow = null;
//		for (PiccoloCustomNode custom : pnode.getChildren()) {
//			Node node = listNodes.get(custom.getidNode());
//			HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
//			for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
//				Edge e = edgeEntry.getValue();
//				if (e.getType().equals("isa")) {
//					System.out.println(e.getId());
//					PiccoloCustomNode dest = allPNodes.get(e.getTo());
//					arrow = new ParrowExtends(custom.getRect().getGlobalBounds().getCenter2D(),
//							dest.getRect().getGlobalBounds().getCenter2D());
//					canvas.getLayer().addChild(arrow);
//					createExtendsEdges(dest, canvas);
//				}
//			}
//		}
//	}

	private void addEvent(PiccoloCustomNode node, PiccoloCustomNode tree,	PSwingCanvas canvas) {
		node.getContent().addInputEventListener(new PCustomInputEventHandler(node, tree, canvas, allPNodes));
		if (node.getAllChildren().size() != 0)
			for (PiccoloCustomNode PCN : node.getAllChildren()) {
				addEvent(PCN, tree,canvas);
			}
	}

	public static void main(String[] args) {
		PSwingCanvas canvas = new PSwingCanvas();
		JFrame frame = new NewDisplayDG(canvas);
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(canvas, BorderLayout.CENTER);
		canvas.setPreferredSize(new Dimension(1000, 500));
		frame.pack();
		//frame.setPreferredSize(new Dimension(742,500));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

	}
}