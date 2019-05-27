package tests.controleur.state;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.controleur.refactoring.RefactoringCommands;
import puck.controleur.state.State;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.node.PiccoloCustomNode;

public class TestState {
	
	State s;
	PiccoloCustomNode n1;
	PiccoloCustomNode n2;
	PiccoloCustomNode n3;
	ArrowNodesHolder anh;
	HashMap<String, PiccoloCustomNode> allPNodes;
	PSwingCanvas canvas;
	StringBuilder sb;

	@Before
	public void beforeTests() {
		anh = new ArrowNodesHolder();
		allPNodes = new HashMap<String, PiccoloCustomNode>();
		n1 = new PiccoloCustomNode("c1","0","package");
		n2 = new PiccoloCustomNode("c2","1","class");
		n3 = new PiccoloCustomNode("c3","2","class");
		n1.setName("c1");
		n2.setName("c2");
		n3.setName("c3");
		n1.addChild(n2);
		n1.addChild(n3);
		allPNodes.put("0", n1);
		allPNodes.put("1", n2);
		allPNodes.put("2", n3);
		canvas = new PSwingCanvas();
		sb = new StringBuilder("");
		s = new State(allPNodes,anh,canvas,n1,sb);
	}
	
	
	@After
	public void afterTests() {
		s = null;
		n1 = null;
		n2 = null;
		n3 = null;
		canvas = null;
		anh = null;
		sb = null;
	}
	
	@Test
	public void testInit() {
		assertEquals(s.getAllPNodes().size(),allPNodes.size());
		assertEquals(s.getANH(),anh);
		assertEquals(s.getCanvas(),canvas);
		assertEquals(s.getRefactoringCommands(),sb);
		assertEquals(s.getRoot(),n1);
	}
	
	
	
	

}
