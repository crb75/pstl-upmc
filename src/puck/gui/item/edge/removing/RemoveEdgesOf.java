package puck.gui.item.edge.removing;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.conversion.XmlToStructure;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.edge.outgoing.CreateISAEdgesOf;
import puck.gui.item.edge.outgoing.CreateUsesEdgesOf;
import puck.gui.item.node.Node;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.menu.Menu;

public class RemoveEdgesOf extends JMenuItem{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private RemoveISAEdges removeISAEdges;
	private RemoveUsesEdges removeUsesEdges;
	

	public RemoveEdgesOf(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
		super("Hide edges",new ImageIcon("images/hide.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		removeISAEdges = new RemoveISAEdges(pnode, canvas, this.allPNodes, menu, ANH,listNodes);
		removeUsesEdges = new RemoveUsesEdges(pnode, canvas, this.allPNodes, menu, ANH,listNodes);

		addActionListener();
	}
	public void drawOutgoingdges(PiccoloCustomNode pnode , PSwingCanvas canvas) {
		removeISAEdges.RemoveEdges(pnode, canvas);
		removeUsesEdges.RemoveEdges(pnode, canvas);

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
