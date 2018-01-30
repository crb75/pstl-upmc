package display.piccolo2d;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.extras.PFrame;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import modals.piccolo2d.CustomPNode;
import modals.piccolo2d.Edge;
import modals.piccolo2d.Node;
import modals.piccolo2d.NodeContent;
import utilities.piccolo2d.PCustomInputEventHandler;
import utilities.piccolo2d.XmlToStructure;

public class NewDisplayDG extends PFrame {

	public NewDisplayDG() {
		//System.out.println(getPackageNodes().size());
		int i = 0;

		for (CustomPNode node : getPackageNodes()) {

			 //node.setCollapsedGridLayout();
			// node.getParent().setGridLayoutV();
			//ArrayList<CustomPNode> list = new ArrayList<>(node.getChildren());
			//ArrayList<CustomPNode> list2 = new ArrayList<>(list.get(0).getChildren());
			//System.out.println(list.get(0).getChildrenCount());
			PCustomInputEventHandler eventHandler = new  PCustomInputEventHandler(node);
			node.addInputEventListener(eventHandler);
			getCanvas().getLayer().addChild(node);
			

		}

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
					pnode = getClassNode(pnode);
					pnode.setExpandGridLayout();
					pnode.setParent(p);
					PCustomInputEventHandler eventHandler = new  PCustomInputEventHandler(pnode);
					pnode.addInputEventListener(eventHandler);
					children.add(pnode);
					//p.addChild(pnode);
					

				}
				p.setChildren(children);
				p.setParent(root);
				// p.getParent().setGridLayoutV();
				p.setExpandGridLayout();
				listePNode.add(p);
			}

		}
		root.addChildren(listePNode);
		root.setChildren(listePNode);
		root.setText("root");
		root.setName("root");
		root.setGridLayoutV();
		return root.getChildren();
	}

	public CustomPNode getClassNode(CustomPNode pnode) {
		Map<String, Node> m = new XmlToStructure().parseNode();
		HashMap<String, Node> listNodes = new HashMap<>(m);
		Node node = listNodes.get(pnode.getIdNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		//System.out.println(relation.size());
		// collection des classes du package
		Collection<CustomPNode> children = new ArrayList<>();
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			//System.out.println(e.getType());
			if (e.getType().equals("contains")) {
				Node n = listNodes.get(e.getTo());
				CustomPNode pnodeBis = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, n.getName(),
						n.getId());
				if (n.getType().equals("method")) {
					pnodeBis = getMethodNode(pnodeBis);
				}
				pnodeBis.setParent(pnode);
				children.add(pnodeBis);
				//pnode.addChild(pnodeBis);
				//
				//System.out.println(pnodeBis.getIdNode());
			}
			
		}
		pnode.setChildren(children);
		

		return pnode;
	}
	public CustomPNode getMethodNode(CustomPNode pnode) {
		Map<String, Node> m = new XmlToStructure().parseNode();
		HashMap<String, Node> listNodes = new HashMap<>(m);
		Node node = listNodes.get(pnode.getIdNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		
		Collection<CustomPNode> children = new ArrayList<>();
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			//System.out.println(e.getType());
			if (e.getType().equals("contains")) {
				Node n = listNodes.get(e.getTo());
				CustomPNode pnodeBis = new CustomPNode(PPath.createRectangle(0, 0, 100, 100), null, 10, n.getName(),
						n.getId());
				
				pnodeBis.setParent(pnode);
				children.add(pnodeBis);
				//pnode.addChild(pnodeBis);
				
				//System.out.println(pnodeBis.getIdNode());
			}
		}
		pnode.setChildren(children);
		pnode.setExpandGridLayout();
		return pnode;
	}

	// public Collection<CustomPNode> getPNodes() {
	// Collection<CustomPNode> listePackageNodes = getPackageNodes();
	// Map<String,Node> m = new XmlToStructure().parseNode();
	// HashMap<String, Node> listNodes = new HashMap<>(m);
	// for (CustomPNode classNode : listePackageNodes) {
	// Node p = listNodes.get(classNode.getIdNode());
	// HashMap<String,Edge> relation = p.getRelation();
	// Collection<CustomPNode> children =classNode.getChildren();
	// for (Entry<String, Edge> edgeEntry : relation.entrySet() ) {
	// Edge e = edgeEntry.getValue();
	// Node node = listNodes.get(e.getTo());
	// CustomPNode pnode = new CustomPNode(PPath.createRectangle(0,0,
	// 100,100),null,10,node.getName(),node.getId());
	// //children.add(pnode);
	// //classNode.addChild(pnode);
	// }
	// //classNode.setChildren(children);
	// //classNode.setExpandGridLayout();
	// listePackageNodes.add(classNode);
	//
	// }
	//
	// return listePackageNodes;
	// }
	public static void main(String[] args) {
		new NewDisplayDG();

	}

}
