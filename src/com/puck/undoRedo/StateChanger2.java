package com.puck.undoRedo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.utilities.piccolo2d.PCustomInputEventHandler;

public class StateChanger2 implements Changeable{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private ArrowNodesHolder ANH;
	private PSwingCanvas canvas;
	private Stack<State> editedState; 
	private int position;
	private PiccoloCustomNode root;
	private Map<String, Node> listNodes;
	private Menu menu;
	private State currentState;
	
	private StateChanger2() {
		super();
	};
	private static StateChanger2 INSTANCE = new StateChanger2();
	 public static StateChanger2 getInstance()
	    {   return INSTANCE;
	    }
	public void init(HashMap<String, PiccoloCustomNode> allPNodes,ArrowNodesHolder ANH,PSwingCanvas canvas,PiccoloCustomNode root,
			Map<String, Node> listNodes, Menu menu) {
		this.allPNodes = allPNodes;
		this.ANH = ANH;
		this.canvas = canvas;
		this.editedState = new  Stack<State>();
		this.position = 0;
		this.root = root;
		this.listNodes = listNodes;
		this.menu = menu;
		System.err.println("init root"+ root.getHierarchy().size());
	}
	
	@Override
	public void undo() {
		if(position > 1 )position-- ;
		else position = 0 ;
		if (editedState.size() > 0 && position >= 0 && !currentState.equals(editedState.get(position))) {
			System.err.println("undo");
			State previousState = editedState.get(position);
			currentState = previousState;
			allPNodes.clear();
			allPNodes.putAll(previousState.getAllPNodes());
			
			ANH = previousState.getANH();
			
			root.removeAllChildren();
			root.getAllChildren().clear();
			root.getHiddenchildren().clear();
			Collection<PiccoloCustomNode> children = previousState.getRoot().getAllChildren();
			root.setChilldren(new ArrayList<>(children));
			//root.setHiddenchildren(previousState.getRoot().getHiddenchildren());	
			addEvent(root, root, canvas, menu, listNodes);

			root.setLayout();
		}

	}


	@Override
	public void redo() {
		position++;
		if (position == editedState.size()) position--;
		
		if (editedState.size() > 0 && position < editedState.size() && !currentState.equals(editedState.get(position))) {
			System.out.println("redo");
			State nextState = editedState.get(position);
			currentState = nextState;
			allPNodes.clear();
			allPNodes.putAll(nextState.getAllPNodes());
			
			ANH = nextState.getANH();
			
			root.removeAllChildren();
			root.getAllChildren().clear();
			root.getHiddenchildren().clear();
			
			root.setChilldren(new ArrayList<>(nextState.getRoot().getAllChildren()));
			//root.setHiddenchildren(nextState.getRoot().getHiddenchildren());
			addEvent(root, root, canvas, menu, listNodes);

			root.setLayout();
		}

	}
	
	
	public Stack<State> getAddedPnodes() {
		return editedState;
	}



	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setAddedPnodes(Stack<State> editedState) {
		this.editedState = editedState;
		position = this.editedState.size()-1;
		currentState = editedState.get(position);
	}

	public HashMap<String, PiccoloCustomNode> getAllPNodes() {
		return allPNodes;
	}

	public void setAllPNodes(HashMap<String, PiccoloCustomNode> allPNodes) {
		this.allPNodes = allPNodes;
	}

	public ArrowNodesHolder getANH() {
		return ANH;
	}

	public void setANH(ArrowNodesHolder aNH) {
		ANH = aNH;
	}

	public PSwingCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(PSwingCanvas canvas) {
		this.canvas = canvas;
	}
	
	private void addEvent(PiccoloCustomNode node, PiccoloCustomNode tree,PSwingCanvas canvas,Menu menu,Map<String, Node> listNodes) {
		if (node.getidNode() != "r01") 
		node.getContent().getText().addInputEventListener(new PCustomInputEventHandler(node, tree, canvas, allPNodes,menu,ANH,listNodes));
		if (node.getAllChildren().size() != 0)
			for (PiccoloCustomNode PCN : node.getAllChildren()) {
				addEvent(PCN, tree,canvas,menu,listNodes);
			}
	}
	

}
