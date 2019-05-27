package puck.controleur.state;

import java.util.HashMap;
import java.util.Stack;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.node.PiccoloCustomNode;

public class StateChanger implements Changeable{
	private static HashMap<String, PiccoloCustomNode> allPNodes;
	private static ArrowNodesHolder ANH;
	private static PSwingCanvas canvas;
	private static Stack<PiccoloCustomNode> editedPnodes; 
	private static int position;
	
	public StateChanger() {
		super();
	};
	private static StateChanger INSTANCE = new StateChanger();
	 public static StateChanger getInstance()
	    {   return INSTANCE;
	    }
	public void init(HashMap<String, PiccoloCustomNode> allPNodes,ArrowNodesHolder ANH,PSwingCanvas canvas) {
		StateChanger.allPNodes = allPNodes;
		StateChanger.ANH = ANH;
		StateChanger.canvas = canvas;
		StateChanger.editedPnodes = new  Stack<PiccoloCustomNode>();
		StateChanger.position = 0;
	}
	
	public void undo() {
		if (editedPnodes.size() > 0 && position >0) {
			System.out.println("undo "+ editedPnodes.size() + " " + position);
			try {
			PiccoloCustomNode pnode = editedPnodes.get(position-1);
			pnode.getParentNode().removeChild(pnode);
			pnode.getHigherParent().setLayout();
			ANH.updateAllPosition();
			position-- ;
			}
			catch(Exception e) {
				System.out.println(position);
				System.out.println(editedPnodes.size());
			}
		}
	}

	@Override
	public void redo() {
		if (editedPnodes.size() > 0 && position < editedPnodes.size()) {
			System.out.println("redo "+ editedPnodes.size() + " " + position);
			try {
			PiccoloCustomNode pnode = editedPnodes.get(position);
			pnode.getParentNode().addChild(pnode);
			pnode.getHigherParent().setLayout();
			ANH.updateAllPosition();
			position++;
			System.out.println(position);
			}catch(Exception e) {
				System.out.println(position);
				System.out.println(editedPnodes.size());
			}
		}
		
	}
	
	
	public static Stack<PiccoloCustomNode> getAddedPnodes() {
		return editedPnodes;
	}

	public int getPosition() {
		return StateChanger.position;
	}

	public static void setPosition(int position) {
		StateChanger.position = position;
	}

	public static void setAddedPnodes(Stack<PiccoloCustomNode> addedPnodes) {
		StateChanger.editedPnodes = addedPnodes;
		position = StateChanger.editedPnodes.size()-1;
	}

	public HashMap<String, PiccoloCustomNode> getAllPNodes() {
		return allPNodes;
	}

	public void setAllPNodes(HashMap<String, PiccoloCustomNode> allPNodes) {
		StateChanger.allPNodes = allPNodes;
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
		StateChanger.canvas = canvas;
	}
	
	

}
