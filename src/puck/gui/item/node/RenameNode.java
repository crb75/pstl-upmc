package puck.gui.item.node;

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
import puck.modele.Node;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.menu.Menu;
import puck.gui.plan.RefactoringCommands;
import puck.gui.state.Changeable;
import puck.gui.state.State;
import puck.gui.state.StateChanger2;

public class RenameNode extends JMenuItem {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private Changeable state;
	private PiccoloCustomNode root;
	private Collection<PiccoloCustomNode> children;
    // TODO(rename methode interface ) rename -> undo rename -> save -> execute / undo redo ne renomme pas les metrhode override
	public RenameNode(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,
			Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes, Changeable state) {
		super("Rename ",new ImageIcon("images/add.png"));
		this.allPNodes = allPNodes;
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.state = state;
		root = pnode.getHigherParent();
		children = pnode.getChildren();
		addActionListener();
	}

	public void rename(String newName) {
		PiccoloCustomNode root_atpre = PiccoloCustomNode.newInstance(root);
		State previousState = new State(copy(), ANH, canvas,root_atpre,new StringBuilder(RefactoringCommands.getInstance().getXmlString()));
		Stack<State> editedState = StateChanger2.getInstance().getAddedPnodes();
		editedState.push(previousState);
		StateChanger2.getInstance().setAddedPnodes(editedState);
		
		pnode.getContent().rename(newName);
		pnode.setName(newName);
		
		allPNodes.get(pnode.getidNode()).getContent().rename(newName);
		allPNodes.get(pnode.getidNode()).setName(newName);
		
		
		RefactoringCommands.getInstance().nodeToString(pnode);
		//System.out.println(RefactoringCommands.getInstance().getXmlString().hashCode());

		State currentState = new State(copy(), ANH, canvas,PiccoloCustomNode.newInstance(root),new StringBuilder(RefactoringCommands.getInstance().getXmlString()));
		editedState = StateChanger2.getInstance().getAddedPnodes();
		editedState.push(currentState);
		StateChanger2.getInstance().setAddedPnodes(editedState);
	
		root.setLayout();
	}
	public void renameWithoutStateSaving(String newName) {
		pnode.getContent().rename(newName);
		pnode.setName(newName);
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
