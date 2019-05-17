package puck.gui.item.node;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import puck.modele.Node;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.event.PCustomInputEventHandler;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.menu.Menu;
import puck.gui.state.Changeable;
import puck.gui.state.State;
import puck.gui.state.StateChanger2;

public class AddNode extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private NodeType nodeType;
	private Changeable state;
	private PiccoloCustomNode root;
	private Collection<PiccoloCustomNode> children;

	public AddNode(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes, NodeType nodeType, Changeable state) {
		super("Add " + nodeType, new ImageIcon("images/add.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		this.nodeType = nodeType;
		this.state = state;
		root = pnode.getHigherParent();
		children = pnode.getChildren();
		addActionListener();
	}

	public void addNode(PiccoloCustomNode pnode, PSwingCanvas canvas,String nodeName) {
		switch (nodeType) {
		case CLASS:
			PiccoloCustomNode cla = new PiccoloCustomNode(nodeName, ""+allPNodes.size(), "class");
			addNodeToParent(cla, nodeName);
			break;
		case PACKAGE:
			PiccoloCustomNode pack = new PiccoloCustomNode(nodeName, ""+allPNodes.size(), "package");
			addNodeToParent(pack, nodeName);			
			break;
		default:
			break;
		}
	}

	public void addNodeToParent(PiccoloCustomNode nodeToAdd, String name) {
		PiccoloCustomNode root_atpre = PiccoloCustomNode.newInstance(root);
		nodeToAdd.setName(name);
		nodeToAdd.setParentNode(pnode);
		nodeToAdd.getContent().getText().addInputEventListener(new PCustomInputEventHandler(nodeToAdd, root, canvas, allPNodes, menu, ANH, listNodes));
		children.add(nodeToAdd);
		pnode.setChilldren(children);
		pnode.showChildren();
		// undo redo with state
	//	Stack<State> editedState = StateChanger2.getInstance().getAddedPnodes();
	  //  editedState.push((State) state);
	//	StateChanger2.getInstance().setAddedPnodes(editedState);
	//	StateChanger2.getInstance().setPosition(StateChanger2.getInstance().getPosition()+1);
		
		allPNodes.put(nodeToAdd.getidNode(), nodeToAdd);

		root.setLayout();
		//root.showChildren();
		ANH.updateAllPosition();
		
//		State currentState = new State(copy(), ANH, canvas,PiccoloCustomNode.newInstance(root),StateChanger2.getInstance().getRefactoringCommands());
//		editedState = StateChanger2.getInstance().getAddedPnodes();
//		editedState.push(currentState);
//		StateChanger2.getInstance().setAddedPnodes(editedState);
	
	}

	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				  String nodeName = JOptionPane.showInputDialog("Add","");
				  if(nodeName==null||nodeName.equals(""))
			            return;
				  
				  addNode(pnode, canvas,nodeName);
			}
		});
	}
	
	public HashMap<String, PiccoloCustomNode>  copy() {
		HashMap<String, PiccoloCustomNode> allPNodes_atPre = new HashMap<>();
		for(Map.Entry<String, PiccoloCustomNode> node : allPNodes.entrySet()) {
			PiccoloCustomNode copy = PiccoloCustomNode.newInstance(node.getValue());
			Collection<PiccoloCustomNode> hide_atPre = new ArrayList<>(node.getValue().getHiddenchildren());
			copy.setHiddenchildren(hide_atPre);
			Collection<PiccoloCustomNode> children_atPre = new ArrayList<>(node.getValue().getChildren());
			copy.setChilldren(children_atPre);
			copy.setParentNode(node.getValue().getParentNode());
			copy.setParent(node.getValue().getParent());
			allPNodes_atPre.put(copy.getidNode(), copy);
		}
		return allPNodes_atPre;
	}
}
