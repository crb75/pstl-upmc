/**
 * 
 */
package nodes.piccolo2d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

/**
 * @author ky
 *
 */
class PiccoloCustomNodeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getRect()}.
	 */
	@Test
	final void testGetRect() {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		assertNotNull(testNode.getRect());	
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getContent()}.
	 */
	@Test
	final void testGetContent() {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		assertNotNull(testNode.getContent());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getMargin()}.
	 */
	@Test
	final void testGetMargin() {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		double marginResult = 10;
		assertEquals(marginResult, testNode.getMargin());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setMargin(double)}.
	 */
	@Test
	final void testSetMargin() {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		double marginResult = 15;
		testNode.setMargin(marginResult);
		assertEquals(marginResult, testNode.getMargin());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getidNode()}.
	 */
	@Test
	final void testGetidNode() {
		String idNodeResult = "124548654";
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", idNodeResult);
		assertEquals(idNodeResult, testNode.getidNode());
		
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#toString()}.
	 */
	@Test
	final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#isHidden()}.
	 */
	@Test
	final void testIsHidden() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setParentNode(nodes.piccolo2d.PiccoloCustomNode)}.
	 */
	@Test
	final void testSetParentNode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getParentNode()}.
	 */
	@Test
	final void testGetParentNode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#PiccoloCustomNode(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testPiccoloCustomNode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setChilldren(java.util.Collection)}.
	 */
	@Test
	final void testSetChilldren() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getChildren()}.
	 */
	@Test
	final void testGetChildren() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getAllChildren()}.
	 */
	@Test
	final void testGetAllChildren() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getHierarchy()}.
	 */
	@Test
	final void testGetHierarchy() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#showChildren()}.
	 */
	@Test
	final void testShowChildren() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#hideChildren()}.
	 */
	@Test
	final void testHideChildren() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#toggleChildren()}.
	 */
	@Test
	final void testToggleChildren() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setLayout()}.
	 */
	@Test
	final void testSetLayout() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setGridLayoutH()}.
	 */
	@Test
	final void testSetGridLayoutH() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setGridLayoutV()}.
	 */
	@Test
	final void testSetGridLayoutV() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setGridLayout(int)}.
	 */
	@Test
	final void testSetGridLayout() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#bevelOut(org.piccolo2d.nodes.PPath, int)}.
	 */
	@Test
	final void testBevelOut() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#bevelIn(org.piccolo2d.nodes.PPath, int)}.
	 */
	@Test
	final void testBevelIn() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#updateContentBoundingBoxes(boolean, org.piccolo2d.PCanvas)}.
	 */
	@Test
	final void testUpdateContentBoundingBoxes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#updateTextBoundingBoxes(boolean)}.
	 */
	@Test
	final void testUpdateTextBoundingBoxes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#expandAll()}.
	 */
	@Test
	final void testExpandAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#collapseAll()}.
	 */
	@Test
	final void testCollapseAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getHigherParent()}.
	 */
	@Test
	final void testGetHigherParent() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getAscendency()}.
	 */
	@Test
	final void testGetAscendency() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#focus()}.
	 */
	@Test
	final void testFocus() {
		fail("Not yet implemented"); // TODO
	}

}
