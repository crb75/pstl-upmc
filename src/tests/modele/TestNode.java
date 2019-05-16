package tests.modele;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puck.modele.Edge;
import puck.modele.Node;

public class TestNode {

		
		private Node n;
		
		 @Before
		 public void beforeTests() {
			 n = new Node();
		 }
		 
		 @After
		 public void afterTests() {
			 n = null;
		 }
		 

		@Test
		public void testInit() {
			assertEquals("", n.getType());
			assertEquals("",n.getId());
			assertEquals("",n.getName());
			assertEquals(0,n.getRelation().size());
		}
		
		@Test
		public void testSetName() {
			n.setName("test");
			assertEquals("test",n.getName());
		}
		
		@Test
		public void testSetId() {
			n.setId("42");
			assertEquals("",n.getId());
		}
		
		@Test
		public void testSetType() {
			n.setType("uses");
			assertEquals("", n.getType());
		}
		
		
		@Test
		public void testSetRelation() {
			HashMap<String, Edge> map = new HashMap();
			map.put("42", new Edge());
			n.setRelation(map);
			assertEquals(1,n.getRelation().size());
		}
		
		
			

}
