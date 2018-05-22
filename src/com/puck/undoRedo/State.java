package com.puck.undoRedo;

import java.util.HashMap;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class State {
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private ArrowNodesHolder ANH;
	private PSwingCanvas canvas;
	private PiccoloCustomNode root;
	private StringBuilder refactoringCommands;
	public State(HashMap<String, PiccoloCustomNode> allPNodes, ArrowNodesHolder aNH, PSwingCanvas canvas,PiccoloCustomNode root,StringBuilder refactoringCommands) {
		super();
		this.allPNodes = allPNodes;
		ANH = aNH;
		this.canvas = canvas;
		this.root = root;
		this.refactoringCommands = refactoringCommands;
	}
	public StringBuilder getRefactoringCommands() {
		return refactoringCommands;
	}
	public void setRefactoringCommands(StringBuilder refactoringCommands) {
		this.refactoringCommands = refactoringCommands;
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
	public PiccoloCustomNode getRoot() {
		return root;
	}
	public void setRoot(PiccoloCustomNode root) {
		this.root = root;
	}
	
	
}
