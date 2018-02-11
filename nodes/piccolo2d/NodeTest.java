package nodes.piccolo2d;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {

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
	final void testNode() {
		Node n;
		n = new Node();
		assertNotNull(n);
	}

	@Test
	final void testGetName() {
		Node n = new Node();
		n.setName("Test");
		assertEquals("Test",n.getName());
	}

	@Test
	final void testSetName() {
		Node n = new Node();
		n.setName("Test");
		assertEquals("Test",n.getName());
	}

	@Test
	final void testGetId() {
		Node n = new Node();
		n.setId("1");
		assertEquals("1", n.getId());
	}

	@Test
	final void testSetId() {
		Node n = new Node();
		n.setId("1");
		assertEquals("1", n.getId());
	}

	@Test
	final void testGetType() {
		Node n = new Node();
		n.setType("Test type");
		assertEquals("Test type",n.getType());
	}

	@Test
	final void testSetType() {
		Node n = new Node();
		n.setType("Test type");
		assertEquals("Test type",n.getType());
	}

	@Test
	final void testGetRelation() {
		Node n = new Node();
		assertEquals(0, n.getRelation().size());
	}

	@Test
	final void testSetRelation() {
		HashMap<String, Edge> re = new HashMap<>();
		re.put("Test", new Edge());
		Node n = new Node();
		n.setRelation(re);
		assertEquals(re, n.getRelation());
	}

}
