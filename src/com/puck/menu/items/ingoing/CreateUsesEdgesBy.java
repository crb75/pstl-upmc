package com.puck.menu.items.ingoing;



import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.arrows.ParrowUses;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Edge;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class CreateUsesEdgesBy extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes ;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;

	public CreateUsesEdgesBy(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
		super();
		this.setText("show uses ingoing");
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
	    addActionListener();
	}

	public void DrawEdges(PiccoloCustomNode target, PSwingCanvas canvas) {
		Node node = listNodes.get(target.getidNode());

		HashMap<String, Edge> relation = getRelationInGoing();
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			PNode to = target;
			PNode from = (allPNodes.get(e.getFrom()));
			if (from.getParent() instanceof PiccoloCustomNode && !((PiccoloCustomNode) from.getParent()).isHidden()) {
				ANH.addArrow(new ParrowUses(from, to, 10, from, to));
			} else {
				for (PiccoloCustomNode pnode : ((PiccoloCustomNode) from).getAscendency()) {
					if (!pnode.isHidden()) {
						ANH.addArrow(new ParrowUses(from, to, 10, pnode, to));
						break;
					}
				}
			}
		}

		this.menu.hideMenu();
	}
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				DrawEdges(pnode, canvas);
			}
		});
	}

	public HashMap<String, Edge> getRelationInGoing() {
		Node currentNode = listNodes.get(pnode.getidNode());
		HashMap<String, Edge> relationInGoing = new HashMap<>();
		if (currentNode != null) {
			for (Entry<String, Node> nodeEntry : listNodes.entrySet()) {
				Node n = nodeEntry.getValue();
				HashMap<String, Edge> relation = n.getRelation();
				for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
					Edge e = edgeEntry.getValue();
					if (e.getType().equals("uses") && (e.getTo().equals(currentNode.getId()))) {
						relationInGoing.put(e.getId(), e);
					}
				}
			}

		}
		return relationInGoing;
	}
}
