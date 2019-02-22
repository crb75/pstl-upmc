package puck.gui.item.edge.outgoing;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.arrow.Parrow;
import puck.gui.item.node.Node;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.menu.Menu;

public class CreateEgdesHierarchyOf extends JMenuItem{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes ;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private CreateEdgesOf createEdgesOf;
	
	public CreateEgdesHierarchyOf(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH,Map<String, Node> listNodes) {
		super("Show hierarchy outgoing edges ",new ImageIcon("images/right-arrow.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		createEdgesOf = new CreateEdgesOf(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		addActionListener();
	}
	public void drawOutgoingdges(PiccoloCustomNode pnode , PSwingCanvas canvas) {
		createEdgesOf = new CreateEdgesOf(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEdgesOf.drawOutgoingdges(pnode, canvas);
		for(PiccoloCustomNode child : pnode.getHierarchy()) {
			createEdgesOf = new CreateEdgesOf(child, canvas, this.allPNodes, menu,ANH,listNodes);
			createEdgesOf.drawOutgoingdges(child, canvas);
		}
		for (Parrow arrow : ANH.getVisibleArrows()) {
			ANH.updatePosition(arrow);
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
