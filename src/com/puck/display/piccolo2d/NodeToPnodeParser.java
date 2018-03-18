package com.puck.display.piccolo2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.puck.nodes.piccolo2d.Edge;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class NodeToPnodeParser {
	private HashMap<String, PiccoloCustomNode> allPNodes ;
	private Map<String, Node> listNodes;

	public NodeToPnodeParser(HashMap<String, PiccoloCustomNode> allPNodes,Map<String, Node> listNodes) {
		this.allPNodes= allPNodes;
		this.listNodes = listNodes ;
	}
	
	public PiccoloCustomNode getPackageNodes() {
		Collection<PiccoloCustomNode> listePNode = new ArrayList<>();
		

		PiccoloCustomNode root = new PiccoloCustomNode("root", "r01","root");
		for (Entry<String, Node> entry : listNodes.entrySet()) {
			String key = entry.getKey();
			Node n = entry.getValue();
			if (n.getType().equals("package")) {
				Node packag = n;
				PiccoloCustomNode p = new PiccoloCustomNode(packag.getName(), packag.getId(),n.getType());
				allPNodes.put(p.getidNode(), p);
				p.setName(packag.getName());
				// les relation contain du package
				HashMap<String, Edge> relation = new HashMap<>(packag.getRelation());
				// collection des classes du package
				Collection<PiccoloCustomNode> children = new ArrayList<>();
				for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
					Edge e = edgeEntry.getValue();
					Node node = listNodes.get(e.getTo());
					PiccoloCustomNode pnode;
					if (allPNodes.containsKey(node.getId())) {
						listePNode.remove(allPNodes.get(node.getId()));
						pnode = allPNodes.get(node.getId());
						pnode.setName(node.getName());
						children.add(pnode);
					} else {
						pnode = new PiccoloCustomNode(node.getName(), node.getId(),node.getType());
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
			pnode = new PiccoloCustomNode(node.getName(), node.getId(),node.getType());
			pnode.setName(node.getName());
		}
		Collection<PiccoloCustomNode> children = new ArrayList<>();
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("contains")) {
				Node n = listNodes.get(e.getTo());
				PiccoloCustomNode pnodeBis = new PiccoloCustomNode(n.getName(), n.getId(),n.getType());
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


	

}
