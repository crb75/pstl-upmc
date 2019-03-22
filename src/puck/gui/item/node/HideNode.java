package puck.gui.item.node;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import puck.modele.Node;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.edge.removing.RemovesHierarchyEdgesOf;
import puck.gui.menu.Menu;

public class HideNode extends JMenuItem {
	
		private HashMap<String, PiccoloCustomNode> allPNodes;
		private Map<String, Node> listNodes ;
		private PiccoloCustomNode pnode;
		private PSwingCanvas canvas;
		private Menu menu;
		private ArrowNodesHolder ANH;
		public HideNode(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
				Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
			super("Hide node ",new ImageIcon("images/hide.png"));
			this.allPNodes = allPNodes;
			this.pnode = pnode;
			this.canvas = canvas;
			this.menu = menu;
			this.ANH = ANH;
			this.listNodes = listNodes;
			addActionListener();
		}
		public void hideNode(PiccoloCustomNode pnode, PSwingCanvas canvas) {
			ArrayList<PiccoloCustomNode> fromAscendency = pnode.getAscendency();
//			RemoveEdgesOf removeEdges = new RemoveEdgesOf(pnode, canvas, allPNodes, menu, ANH, listNodes);
//			removeEdges.drawOutgoingdges(pnode,canvas);
			RemovesHierarchyEdgesOf removeEdges = new RemovesHierarchyEdgesOf(pnode, canvas, allPNodes, menu, ANH, listNodes);
			removeEdges.drawOutgoingdges(pnode,canvas);
			PiccoloCustomNode parent = pnode.getParentNode();
			parent.getHiddenchildren().add(pnode);
			parent.removeChild(pnode);
			if (fromAscendency.size() > 0) {
				fromAscendency.get(fromAscendency.size()-1).setLayout();
			}
			
		}
	
		public void addActionListener() {
			this.addActionListener(new AbstractAction() {

				public void actionPerformed(ActionEvent arg0) {
					System.out.println("je click");
					hideNode(pnode, canvas);
				}
			});
		}
}
