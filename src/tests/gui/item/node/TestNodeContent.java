package tests.gui.item.node;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.piccolo2d.nodes.PImage;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import puck.gui.item.node.NodeContent;


public class TestNodeContent {
	
	NodeContent nc;
	String nct1 = "Test";
	PText ptext;
	
	 @Before
	 public void beforeTests() {
		 ptext = new PText(nct1);
		 nc = new NodeContent(ptext,"package");
	 }
	 
	 @After
	 public void afterTests() {
		 ptext = null;
		 nc = null;
	 }
	 
	@Test
	public void testGetText() {
		 assertNotNull(nc.getText());
		 assertEquals(nc.getText(), ptext);
	}


	@Test
	public void testSetText() {
		 nc.setText("Success");
		 assertNotNull(nc.getText());
		 assertEquals(nc.toString(), "Success");
	}
	
	
	@Test
	public void testGetIcon() {
		assertNotNull(nc.getIcon());
		assertEquals(nc.getIcon().getName(),"package");
	}
	
	@Test
	public void testSetType() {
		 nc.setType("class");
		 assertEquals(nc.getType(), "class");
	}
	
	@Test
	public void testGetType() {
		 assertEquals(nc.getType(), "");
	}

	@Test
	public void testRename() {
		String t = "test42";
		nc.rename(t);
		assertEquals(nc.toString(),"test42");
	}
}
