package com.puck.menu.items.outgoing;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.menu.Menu;
import com.puck.menu.items.ingoing.CreateEdgesBy;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.utilities.piccolo2d.XmlToStructure;

public class CreateEgdesHierarchyOf extends JMenuItem{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private CreateEdgesOf createEdgesOf;
	
	public CreateEgdesHierarchyOf(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH) {
		super("Show hierarchy outgoing edges ",new ImageIcon("images/right-arrow.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		createEdgesOf = new CreateEdgesOf(pnode, canvas, this.allPNodes, menu,ANH);
		addActionListener();
	}
	public void drawOutgoingdges(PiccoloCustomNode pnode , PSwingCanvas canvas) {
		createEdgesOf = new CreateEdgesOf(pnode, canvas, this.allPNodes, menu,ANH);
		createEdgesOf.drawOutgoingdges(pnode, canvas);
		for(PiccoloCustomNode child : pnode.getHierarchy()) {
			createEdgesOf = new CreateEdgesOf(child, canvas, this.allPNodes, menu,ANH);
			createEdgesOf.drawOutgoingdges(child, canvas);
		}
		menu.hideMenu();
	}
	
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				drawOutgoingdges(pnode, canvas);
			}
		});
	}
}
