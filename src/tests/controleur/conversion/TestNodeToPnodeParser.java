package tests.controleur.conversion;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puck.controleur.conversion.NodeToPnodeParser;
import puck.controleur.conversion.XmlToStructure;
import puck.gui.item.node.PiccoloCustomNode;
import puck.modele.Node;

public class TestNodeToPnodeParser {

	NodeToPnodeParser nodesToPnodes;
	String args = "TestFile.xml";
	Map<String, Node> listNodes; //12 noeuds
	HashMap<String, PiccoloCustomNode> allPNodes;
	
	@Before
	public void beforeTests() {
		listNodes = new XmlToStructure(args).parseNode();
		allPNodes = new HashMap<>();
		nodesToPnodes = new NodeToPnodeParser(allPNodes, listNodes);
	}
	
	@After
	public void afterTests() {
		nodesToPnodes =null;
		String args = "TestFile.xml";
		listNodes = null;
		allPNodes = null;
	}
	
	@Test
	public void testGetPackageNodes() {
		PiccoloCustomNode root = new PiccoloCustomNode("root", "r01","root");
		PiccoloCustomNode p = new PiccoloCustomNode("p", "0","package");
		
		assertEquals(nodesToPnodes.getPackageNodes().getName(),"root");
	}

	
	@Test
	public void testStructureToPiccolo() {
		
	}
}
