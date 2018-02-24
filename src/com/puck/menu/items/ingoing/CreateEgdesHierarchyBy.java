package com.puck.menu.items.ingoing;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.utilities.piccolo2d.XmlToStructure;

public class CreateEgdesHierarchyBy extends JMenuItem {

	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private CreateEdgesBy createEdgesBy;

	public CreateEgdesHierarchyBy(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH) {
		super("Show hierarchy ingoing edges ",new ImageIcon("images/left-arrow.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		createEdgesBy = new CreateEdgesBy(pnode, canvas, this.allPNodes, menu,ANH);
		addActionListener();
	}
	public void drawOutgoingdges(PiccoloCustomNode pnode , PSwingCanvas canvas) {
		createEdgesBy = new CreateEdgesBy(pnode, canvas, this.allPNodes, menu,ANH);
		createEdgesBy.drawOutgoingdges(pnode, canvas);
		for(PiccoloCustomNode child : pnode.getHierarchy()) {
			createEdgesBy = new CreateEdgesBy(child, canvas, this.allPNodes, menu,ANH);
			createEdgesBy.drawOutgoingdges(child, canvas);
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

