package com.puck.menu.items;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.arrows.Parrow;
import com.puck.menu.Menu;
import com.puck.menu.items.ingoing.CreateISAEdgesBy;
import com.puck.menu.items.ingoing.CreateUsesEdgesBy;
import com.puck.menu.items.removing.RemoveEdgesOf;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

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
			RemoveEdgesOf removeEdges = new RemoveEdgesOf(pnode, canvas, allPNodes, menu, ANH, listNodes);
			removeEdges.drawOutgoingdges(pnode,canvas);
			PiccoloCustomNode parent = pnode.getParentNode();
			parent.removeChild(pnode);
			if (fromAscendency.size() > 0) {
				fromAscendency.get(fromAscendency.size()-1).setLayout();
			}
			
			
		
		}
	
		public void addActionListener() {
			this.addActionListener(new AbstractAction() {

				public void actionPerformed(ActionEvent arg0) {
					hideNode(pnode, canvas);
				}
			});
		}
}
