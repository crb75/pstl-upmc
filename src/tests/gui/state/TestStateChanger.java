package tests.gui.state;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.state.StateChanger;

public class TestStateChanger {

	StateChanger sc;
	PiccoloCustomNode n1;
	PiccoloCustomNode n2;
	PiccoloCustomNode n3;
	ArrowNodesHolder anh;
	HashMap<String, PiccoloCustomNode> allPNodes;
	PSwingCanvas canvas;
	StringBuilder sb;

	
	@Before
	public void beforeTests() {
		sc = new StateChanger();
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
	}
	
	@After
	public void afterTests() {
		sc = null;
		n1 = null;
		n2 = null;
		n3 = null;
		canvas = null;
		anh = null;
		sb = null;
	}
	
	@Test
	public void testInit() {
		sc.init(allPNodes, anh, canvas);
		assertEquals(allPNodes,  sc.getAllPNodes());
		assertEquals(anh,sc.getANH());
		assertEquals(canvas,sc.getCanvas());
		assertEquals(0,sc.getPosition());
		assertEquals(new  Stack<PiccoloCustomNode>() ,sc.getAddedPnodes());
	}
	
	
	@Test
	public void undo() {
		sc.init(allPNodes, anh, canvas);
		PiccoloCustomNode n = new PiccoloCustomNode("c","42","class");
		PiccoloCustomNode parent = new PiccoloCustomNode("p","41","package");
		n.setParentNode(parent);
		sc.getAddedPnodes().add(n);
		sc.setPosition(0);
		sc.undo();
		assertEquals(0,sc.getPosition());
	}


	@Test
	public void redo() {
		sc.init(allPNodes, anh, canvas);
		PiccoloCustomNode n = new PiccoloCustomNode("c","42","class");
		PiccoloCustomNode parent = new PiccoloCustomNode("p","41","package");
		n.setParentNode(parent);
		sc.getAddedPnodes().add(n);
		sc.setPosition(0);
		sc.undo();
		assertEquals(0,sc.getPosition());
		assertEquals(0,parent.getAllChildren().size());
		sc.redo();
		assertEquals(0,sc.getPosition());
		assertEquals(1,parent.getAllChildren().size());
	}
}
