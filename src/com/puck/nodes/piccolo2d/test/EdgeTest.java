package com.puck.nodes.piccolo2d.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.puck.nodes.piccolo2d.Edge;

class EdgeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testEdge() {
		assertNotNull(new Edge());
	}

	@Test
	final void testGetType() {
		Edge e = new Edge();
		assertEquals("", e.getType());
	}

	@Test
	final void testSetType() {
		Edge e = new Edge();
		boolean result = (e.getType() == "");
		String type = "Test type";
		e.setType(type);
		result = result && (type == e.getType());
		assertEquals(true, result);
		
	}

	@Test
	final void testGetId() {
		Edge e = new Edge();
		assertEquals("",e.getId());
	}

	@Test
	final void testSetId() {
		Edge e = new Edge();
		e.setId("id");
		assertEquals("id", e.getId());
	}

	@Test
	final void testGetFrom() {
		Edge e = new Edge();
		assertEquals("", e.getFrom());
	}

	@Test
	final void testSetFrom() {
		Edge e = new Edge();
		e.setFrom("from");
		assertEquals("from", e.getFrom());
	}

	@Test
	final void testGetTo() {
		Edge e = new Edge();
		assertEquals("", e.getTo());
	}

	@Test
	final void testSetTo() {
		Edge e = new Edge();
		e.setTo("to");
		assertEquals("to", e.getTo());
	}
}
