package puck.gui.item.edge.removing;


import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.controleur.conversion.XmlToStructure;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.modele.Parrow;
import puck.gui.item.arrow.ParrowExtends;
import puck.modele.Node;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.menu.Menu;

public class RemoveISAEdges extends JMenuItem{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes ;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;

	public RemoveISAEdges(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,Menu menu,ArrowNodesHolder ANH
			, Map<String, Node> listNodes) {
		super();
		this.setText("hide extends");
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		addActionListener();
	}
	public void RemoveEdges(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		  Collection<Parrow> arrows =ANH.getVisibleArrows();
		  for (Parrow parrow : arrows) {
			PNode from = parrow.getFrom();
			PNode to = parrow.getTo();
			if (parrow instanceof ParrowExtends && (((PiccoloCustomNode)from).getidNode().equals(pnode.getidNode()))||
					((PiccoloCustomNode)to).getidNode().equals(pnode.getidNode())) {
				ANH.removeArrow(parrow);
			}
		  }
		  this.menu.hideMenu();
	}
	
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent arg0) {
            	RemoveEdges(pnode,canvas);
            }    
        });
	}
}
