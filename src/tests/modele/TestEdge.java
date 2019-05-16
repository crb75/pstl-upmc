package tests.modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puck.modele.Edge;

public class TestEdge {

	 private Edge e;
	 
	 @Before
	 public void beforeTests() {
		 e = new Edge();
	 }
	 
	 @After
	 public void afterTests() {
		 e = null;
	 }
	 
	
	 @Test
	 public void testGetType() {
		 String actual = e.getType();
	     assertEquals("", actual);
	 }

	 @Test
	 public void testSetType() {
	    String type = "Test type";
	    e.setType(type);
	    assertTrue(type.equals(e.getType()));
	 }

	 @Test
	 public void testGetId() {
	    String actual = e.getId();
	    assertEquals("",actual);
	 }

	 @Test
	 public void testSetId() {
		e.setId("id");
	    assertEquals("id", e.getId());
	 }

	@Test
	public void testGetFrom() {
	    String actual = e.getFrom();
	    assertEquals("", e.getFrom());
	}

	@Test
	public void testSetFrom() {
	    e.setFrom("from");
	    assertEquals("from", e.getFrom());
	}

	@Test
	public void testGetTo() {
	   String actual = e.getTo();
	   assertEquals("", e.getTo());
	}

	@Test
	public void testSetTo() {	     
	   e.setTo("to");
	   assertEquals("to", e.getTo());
	}

}
