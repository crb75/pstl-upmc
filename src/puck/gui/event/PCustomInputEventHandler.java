package puck.gui.event;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuItem;

import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.modele.Node;
import puck.modele.Parrow;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.edge.ingoing.CreateEdgesBy;
import puck.gui.item.edge.ingoing.CreateEgdesHierarchyBy;
import puck.gui.item.edge.outgoing.CreateEdgesOf;
import puck.gui.item.edge.outgoing.CreateEgdesHierarchyOf;
import puck.gui.item.edge.removing.RemoveEdgesOf;
import puck.gui.item.edge.removing.RemovesHierarchyEdgesOf;
import puck.gui.item.node.AddNode;
import puck.gui.item.node.CollapseAll;
import puck.gui.item.node.ExpandAll;
import puck.gui.item.node.FocusNode;
import puck.gui.item.node.HideNode;
import puck.gui.item.node.NodeType;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.item.node.RenameNode;
import puck.gui.menu.Menu;
import puck.gui.state.Changeable;
import puck.gui.state.StateChanger;

public class PCustomInputEventHandler extends PBasicInputEventHandler {
	
	private PiccoloCustomNode pnode;
	private PiccoloCustomNode root;
	private PSwingCanvas canvas;
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Menu menu;
	private JMenuItem createEdgesOf;
	private JMenuItem createEdgesBy;
	private JMenuItem removeEdgesOf;
	private JMenuItem createEgdesHierarchyBy;
	private JMenuItem createEgdesHierarchyOf;
	private JMenuItem removesHierarchyEdgesOf;
	private Map<String, Node> listNodes;
	private ArrowNodesHolder ANH;
	private HideNode hideNode ;
	private FocusNode focusNode;
	private ExpandAll expandAll;
	private CollapseAll collapseAll;
	private JMenuItem addClass;
	private JMenuItem addPackage;
	private JMenuItem renameNode;
	private Changeable state;
	
	public PCustomInputEventHandler(PiccoloCustomNode pnode, PiccoloCustomNode root, PSwingCanvas canvas,
			Map<String, PiccoloCustomNode> allPNodes, Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
		this.canvas = canvas;
		this.root = root;
		this.allPNodes = (HashMap<String, PiccoloCustomNode>) allPNodes;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		createEdgesOf = new CreateEdgesOf(pnode, canvas, this.allPNodes, menu,ANH,this.listNodes);
		removeEdgesOf = new RemoveEdgesOf(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEdgesBy = new CreateEdgesBy(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEgdesHierarchyBy = new CreateEgdesHierarchyBy(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEgdesHierarchyOf = new CreateEgdesHierarchyOf(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		removesHierarchyEdgesOf = new RemovesHierarchyEdgesOf(pnode, canvas, this.allPNodes, menu, ANH, listNodes);
		hideNode = new HideNode(pnode, canvas, this.allPNodes, menu, ANH, listNodes);
		focusNode = new FocusNode(pnode, canvas, this.allPNodes, menu, ANH, listNodes);
		expandAll = new ExpandAll(pnode, canvas, this.allPNodes, menu, ANH, listNodes);
		collapseAll = new CollapseAll(pnode, canvas, this.allPNodes, menu, ANH, listNodes);
		state = StateChanger.getInstance();
		addClass = new AddNode(pnode, canvas, this.allPNodes, menu, ANH, listNodes, NodeType.CLASS, state);
		addPackage =  new AddNode(pnode, canvas, this.allPNodes, menu, ANH, listNodes, NodeType.PACKAGE, state);
		renameNode = new RenameNode(pnode, canvas, this.allPNodes, menu, ANH, listNodes, state);
	}

	public PCustomInputEventHandler(PiccoloCustomNode pnode) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
	}

	@Override
	public void mousePressed(PInputEvent aEvent) {
		
		try {
			if (aEvent.isLeftMouseButton()) {	
				
				
				pnode.toggleChildren();
				//pnode.setPickable(true);
				root.setLayout();
				root.updateContentBoundingBoxes(false, canvas);
				for (Parrow arrow : ANH.getVisibleArrows()) {
					ANH.updatePosition(arrow);
				}
				 aEvent.setHandled(true);
				
			}
			if (aEvent.isRightMouseButton()) {
					generateMenu(menu,aEvent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*
	 public void mouseDragged(PInputEvent event) {
 		 Point2D pt = event.getPosition();
         org.piccolo2d.PNode aNode = event.getPickedNode();
         org.piccolo2d.util.PDimension delta = event.getDeltaRelativeTo(aNode);
         aNode.translate(delta.width, delta.height);
         event.setHandled(true);
 	}*/
	 
	 
	 @Override
     public void mouseEntered(final PInputEvent event) {
         event.getPickedNode().setPaint(Color.RED);
     }
 	
	 
	 @Override
     public void mouseExited(final PInputEvent event) {
         event.getPickedNode().setPaint(Color.LIGHT_GRAY);
     }
	
	public void generateMenu(Menu menu,PInputEvent aEvent) {
		menu.removeAll();
		menu.add(createEdgesOf);
		menu.add(createEgdesHierarchyOf);
		menu.addSeparator();
		menu.add(createEdgesBy);
		menu.add(createEgdesHierarchyBy);
		menu.addSeparator();
		menu.add(removeEdgesOf);
		menu.add(removesHierarchyEdgesOf);
		menu.addSeparator();
		menu.add(hideNode);
		menu.add(focusNode);
		menu.addSeparator();
		menu.add(expandAll);
		menu.add(collapseAll);
		menu.addSeparator();
		if(pnode.getContent().getType().equals("package")) {
			menu.add(addClass);
			menu.add(addPackage);
			menu.addSeparator();
		}
		menu.add(renameNode);
		menu.setPoint(aEvent.getPosition());
		menu.setCanvas(canvas);
	}

	 
}