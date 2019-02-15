package state;

import java.util.HashMap;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.undoRedo.Changeable;

public abstract class StateChanger implements Changeable {
	
	protected HashMap<String, PiccoloCustomNode> allPNodes;
	protected ArrowNodesHolder ANH;
	protected PSwingCanvas canvas;
	protected int position;
	
	
	
	
	//GETTERS AND SETTERS
	
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
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
