package tests.conversion;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graph.Node;
import puck.conversion.NodeToPnodeParser;
import puck.conversion.XmlToDisplay;
import puck.conversion.XmlToStructure;
import puck.gui.item.node.PiccoloCustomNode;

public class TestXmlToDisplay {

	XmlToDisplay xml;
	
	@Before
	public void beforeTests() {
		xml = new XmlToDisplay();
	}
	
	@After
	public void afterTests() {
		xml = null;
	}
	
	
	@Test
	public void testAddPnodesPositif() {
		PiccoloCustomNode pnode = new PiccoloCustomNode("test","42","method");
		PiccoloCustomNode n1 = new PiccoloCustomNode("test1","42.1","method");
		PiccoloCustomNode n2 = new PiccoloCustomNode("test2","42.2","method");
		n1.setName("test1");
		n2.setName("test2");
		pnode.addChild(n1);
		pnode.addChild(n2);
		xml.addPnodes(pnode);
		assertTrue(xml.getAddedPnodes().containsKey("42.1"));
		assertTrue(xml.getAddedPnodes().containsKey("42.2"));
	
		String s1 = "<node type=\"method\" id=\"42.1\" name=\"test1\"/>";
		String s2 = "<node type=\"method\" id=\"42.2\" name=\"test2\"/>";
		
		assertTrue(xml.getXmlString().toString().contains(s1));
		assertTrue(xml.getXmlString().toString().contains(s2));
	}
	
}
