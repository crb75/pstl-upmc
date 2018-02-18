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
import org.piccolo2d.util.PPaintContext;

import arrows.ArrowNodesHolder;
import menu.Menu;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import nodes.piccolo2d.PiccoloCustomNode;
import utilities.piccolo2d.PCustomInputEventHandler;
import utilities.piccolo2d.XmlToStructure;

public class NewDisplayDG extends JFrame {
	private HashMap<String, PiccoloCustomNode> allPNodes = new HashMap<>();
	private Map<String, Node> listNodes = new XmlToStructure().parseNode();
	//private HashMap<String, Node> listNodes = new HashMap<>(m);
	private PiccoloCustomNode root;
	private Menu menu;
	private ArrowNodesHolder ANH;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewDisplayDG(PSwingCanvas canvas) {
		menu = new Menu();
		root = getPackageNodes();
		root.collapseAll();
		this.ANH =  new ArrowNodesHolder();
		addEvent(root, root,canvas,menu);
		canvas.getLayer().addChild(root);
		canvas.getLayer().addChild(ANH);
		
		
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


	private void addEvent(PiccoloCustomNode node, PiccoloCustomNode tree,	PSwingCanvas canvas,Menu menu) {
		node.getContent().addInputEventListener(new PCustomInputEventHandler(node, tree, canvas, allPNodes,menu,ANH));
		if (node.getAllChildren().size() != 0)
			for (PiccoloCustomNode PCN : node.getAllChildren()) {
				addEvent(PCN, tree,canvas,menu);
			}
	}

	public static void main(String[] args) {
		PSwingCanvas canvas = new PSwingCanvas();
		JFrame frame = new NewDisplayDG(canvas);
		canvas.setDefaultRenderQuality(PPaintContext.HIGH_QUALITY_RENDERING);
        canvas.setAnimatingRenderQuality(PPaintContext.HIGH_QUALITY_RENDERING);
        canvas.setInteractingRenderQuality(PPaintContext.HIGH_QUALITY_RENDERING);
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(canvas, BorderLayout.CENTER);
		canvas.setPreferredSize(new Dimension(1000, 500));
		frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
       

	}
}