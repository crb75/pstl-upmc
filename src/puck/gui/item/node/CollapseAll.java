package puck.gui.item.node;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.menu.Menu;

public class CollapseAll extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes ;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	
	public CollapseAll(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
		super("Collapse All",new ImageIcon("images/hide.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		addActionListener();
	}
	public void expandAll(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		pnode.collapseAll();
		pnode.getHigherParent().setLayout();
		ANH.updateAllPosition();
		
	}
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				expandAll(pnode, canvas);
			}
		});
	}
}
