package nodes.piccolo2d.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.piccolo2d.nodes.PText;

import nodes.piccolo2d.NodeContent;

class NodeContentTest {

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
	final void testGetMargin() {
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1));
		assertEquals(10, nc.getMargin());
	}

	@Test
	final void testSetMargin() {
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1));
		int margin = 10000;
		nc.setMargin(margin);
		assertEquals(margin, nc.getMargin());
	}

	@Test
	final void testGetText() {
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1));
		assertNotNull(nc.getText());
	}	

	@Test
	final void testSetText() {
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1));
		String nct2 = "Test 1";
		nc.setText(nct2);
		assertEquals(nct2, nc.toString());
	}

	@Test
	final void testGetIcon() {
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1));
		assertNull(nc.getIcon());
	}

	@Test
	final void testNodeContent() {
		NodeContent nc;
		nc = new NodeContent(new PText("Test"));
		assertNotNull(nc);
	}

	@Test
	final void testToString() {
		NodeContent nc = new NodeContent(new PText("Test"));
		assertEquals("Test",nc.toString());
	}

}
