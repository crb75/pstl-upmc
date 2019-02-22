package puck.gui.item.edge.outgoing;



import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.conversion.XmlToStructure;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.arrow.ParrowExtends;
import puck.gui.item.edge.Edge;
import puck.gui.item.node.Node;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.menu.Menu;

public class CreateISAEdgesOf extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes ;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;

	public CreateISAEdgesOf(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
		super("show extends outgoing",new ImageIcon("right-arrow.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes= listNodes;
		addActionListener();
	}

	public void drawExtendsEdges(PiccoloCustomNode target, PSwingCanvas canvas) {
		Node node = listNodes.get(target.getidNode());
		if (node != null && node.getRelation() != null) {
			HashMap<String, Edge> relation = node.getRelation();
			for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
				Edge e = edgeEntry.getValue();
				if (e.getType().equals("isa")) {
					PNode from = target;
					PNode to = (allPNodes.get(e.getTo()));
					if (to.getParent() instanceof PiccoloCustomNode
							&& !((PiccoloCustomNode) to.getParent()).isHidden()) {
						ANH.addArrow(new ParrowExtends(from, to, from, to));
						ANH.updateAllPosition();
					} else {
						for (PiccoloCustomNode pnode : ((PiccoloCustomNode) to).getAscendency()) {
							if (!pnode.isHidden()) {
								ANH.addArrow(new ParrowExtends(from, to, from, pnode));
								break;
							}
						}
					}
				}
			}
		}
		this.menu.hideMenu();
	}

	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				drawExtendsEdges(pnode, canvas);
			}
		});
	}

}
