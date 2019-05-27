package tests.controleur.refactoring;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import puck.controleur.refactoring.PlanReader;


public class TestPlanReader {
	
	PlanReader pr;
	
	@Before
	public void beforeTests() {
		pr = new PlanReader("test_assets/refact.xml");
	}
	
	@After
	public void afterTests() {
		pr = null;
	}

	@Test
	public void test1executeStringQueryPositif() {
		String res = pr.executeStringQuery("//Rename[1]/@id");
		assertEquals("42",res);
	}
	
	@Test
	public void test1ExecuteStringQueryNegatif() {
		String res = pr.executeStringQuery("//Rename[2]/@id");
		assertEquals("42",res);
	}
	
	@Test
	public void test1ExecuteBooleanQueryPositif() {
		boolean res = pr.executeBooleanQuery("//Rename[1]/@id =42");
		assertEquals(true,res);
	}
	
	@Test
	public void test1ExecuteBooleanQueryNegatif() {
		boolean res = pr.executeBooleanQuery("//Rename[1]/@id =0");
		assertEquals(true,res);
	}
	
	@Test
	public void testExecuteNodeQuery() {
		Node res = pr.executeNodeQuery("//Rename[1]");
		assertNotNull(res);
		assertEquals("42",pr.getNodeId(1));
		assertEquals("test",pr.getNodeNewName(1));
	}

	
	@Test
	public void testExecuteNodeSetQuery() {
		NodeList res = pr.executeNodeSetQuery("//Rename[@id = 15]");
		assertEquals(2,res.getLength());
		ArrayList<String> ids = new ArrayList<>();
	    ArrayList<String> renames = new ArrayList<>();
	    ids.add("15");
	    ids.add("15");
	    renames.add("methodRename");
	    renames.add("m2");

	    for (int i = 0; i < res.getLength(); i++) {
            Node n = res.item(i);
            assertEquals(n.getNodeName(),"Rename");
            assertEquals(n.getAttributes().getLength(),2);
            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
            assertEquals(n.getAttributes().getNamedItem("newName").getNodeValue(),renames.get(i));
 
        }
	}
	
	@Test
	public void testGetAllNodesRename() {
		NodeList res = pr.getAllNodesRename();
		ArrayList<String> ids = new ArrayList<>();
	    ArrayList<String> renames = new ArrayList<>();
	    ids.add("42");
	    ids.add("15");
	    ids.add("15");
	    renames.add("test");
	    renames.add("methodRename");
	    renames.add("m2");
	    
	    
	    for (int i = 0; i < res.getLength(); i++) {
            Node n = res.item(i);
            assertEquals(n.getNodeName(),"Rename");
            assertEquals(n.getAttributes().getLength(),2);
            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
            assertEquals(n.getAttributes().getNamedItem("newName").getNodeValue(),renames.get(i));
        }
	}
	
	@Test
	public void testGetNodeId() {
		String res = pr.getNodeId(1);
		assertEquals("42",res);
	}
	
	
	@Test
	public void testGetNodeNewName() {
		String res = pr.getNodeNewName(1);
		assertEquals("test",res);
	}
	
	
	@Test
	public void testGetNbNodesRename() {
		assertEquals(3,pr.getNbNodesRename());
	}
	
	@Test
	public void testGenerateNodePathWithIndex() {
		assertEquals("//Rename[1]",pr.generateNodePathWithIndex("Rename", 1));
	}
	
	
}
