package com.puck.menu.items;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.refactoring.RefactoringCommands;
import com.puck.undoRedo.Changeable;
import com.puck.undoRedo.State;
import com.puck.undoRedo.StateChanger2;

public class RenameNode extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> listNodes;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private Changeable state;
	private PiccoloCustomNode root;
	private Collection<PiccoloCustomNode> children;

	public RenameNode(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes, Changeable state) {
		super("Rename ",new ImageIcon("images/add.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		this.state = state;
		root = pnode.getHigherParent();
		children = pnode.getChildren();
		addActionListener();
	}

	public void rename(String newName) {
		PiccoloCustomNode root_atpre = PiccoloCustomNode.newInstance(root);
		State previousState = new State(copy(), ANH, canvas,root_atpre);
		Stack<State> editedState = StateChanger2.getInstance().getAddedPnodes();
		editedState.push(previousState);
		StateChanger2.getInstance().setAddedPnodes(editedState);
		
		pnode.getContent().rename(newName);
		pnode.setName(newName);
		
		State currentState = new State(copy(), ANH, canvas,PiccoloCustomNode.newInstance(root));
		editedState = StateChanger2.getInstance().getAddedPnodes();
		editedState.push(currentState);
		StateChanger2.getInstance().setAddedPnodes(editedState);
		
		RefactoringCommands.getInstance().nodeToString(pnode);
		root.setLayout();
	}

	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				String newName = JOptionPane.showInputDialog("Rename",pnode.getContent().getText().getText());
				if (newName == null || newName.equals(""))
					return;
				rename(newName);
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
