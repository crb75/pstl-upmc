package com.puck.undoRedo;

import java.util.HashMap;
import java.util.Stack;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class StateChanger implements Changeable{
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private ArrowNodesHolder ANH;
	private PSwingCanvas canvas;
	private Stack<PiccoloCustomNode> editedPnodes; 
	private int position;
	
	private StateChanger() {
		super();
	};
	private static StateChanger INSTANCE = new StateChanger();
	 public static StateChanger getInstance()
	    {   return INSTANCE;
	    }
	public void init(HashMap<String, PiccoloCustomNode> allPNodes,ArrowNodesHolder ANH,PSwingCanvas canvas) {
		this.allPNodes = allPNodes;
		this.ANH = ANH;
		this.canvas = canvas;
		this.editedPnodes = new  Stack<PiccoloCustomNode>();
		this.position = 0;
	}
	
	@Override
	public void undo() {
		if (editedPnodes.size() > 0 && position >= 0) {
			System.out.println("undo");
			PiccoloCustomNode pnode = editedPnodes.get(position);
			pnode.getParentNode().removeChild(pnode);
			pnode.getHigherParent().setLayout();
			ANH.updateAllPosition();
			if(position > 1 )position-- ;
			else position = 0 ;
		}
	}

	@Override
	public void redo() {
		if (editedPnodes.size() > 0 && position < editedPnodes.size()) {
			System.out.println("redo");
			PiccoloCustomNode pnode = editedPnodes.get(position);
			pnode.getParentNode().addChild(pnode);
			pnode.getHigherParent().setLayout();
			ANH.updateAllPosition();
			position++;
			if (position == editedPnodes.size()) position--;
		}
		
	}
	
	
	public Stack<PiccoloCustomNode> getAddedPnodes() {
		return editedPnodes;
	}



	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setAddedPnodes(Stack<PiccoloCustomNode> addedPnodes) {
		this.editedPnodes = addedPnodes;
		position = this.editedPnodes.size()-1;
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
	
	

}
