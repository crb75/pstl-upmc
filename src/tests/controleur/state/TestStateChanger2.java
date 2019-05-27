package tests.controleur.state;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.controleur.conversion.XmlToStructure;
import puck.controleur.state.StateChanger2;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.menu.Menu;
import puck.modele.Node;

public class TestStateChanger2 {

	StateChanger2 sc;
	PiccoloCustomNode n1;
	PiccoloCustomNode n2;
	PiccoloCustomNode n3;
	ArrowNodesHolder anh;
	HashMap<String, PiccoloCustomNode> allPNodes;
	PSwingCanvas canvas;
	StringBuilder sb;
	Menu m;
	Map<String, Node> listNodes;

	@Before
	public void beforeTests() {
		sc = new StateChanger2();
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
		m = new Menu();
		listNodes =  new XmlToStructure("TestFile.xml").parseNode();
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
		m = null;
	}
	
	@Test
	public void testInit() {
		sc.init(allPNodes, anh, canvas, n1, listNodes, m, sb);
		assertEquals(allPNodes,sc.getAllPNodes());
		assertEquals(anh,sc.getANH());
		assertEquals(canvas,sc.getCanvas());
		assertEquals(0,sc.getPosition());
		assertEquals(new  Stack<PiccoloCustomNode>(),sc.getAddedPnodes());
	}
	
//	@Test
//	public void testUndo() {
//		sc.init(allPNodes, anh, canvas, n1, listNodes, m, sb);
//		PiccoloCustomNode n = new PiccoloCustomNode("c","42","class");
//		PiccoloCustomNode parent = new PiccoloCustomNode("p","41","package");
//		n.setParentNode(parent);
//		sc.getAddedPnodes().;
//		sc.setPosition(0);
//		sc.undo();
//		assertEquals(0,sc.getPosition());
//	}

}
