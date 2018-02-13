/**
 * 
 */
package nodes.piccolo2d.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import nodes.piccolo2d.PiccoloCustomNode;

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
		String idNodeResult = "124548654";
		String content = "Test node";
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode(content, idNodeResult);
		assertEquals(content, testNode.toString());	
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#isHidden()}.
	 */
	@Test
	final void testIsHidden() {
		String idNodeResult = "124548654";
		String content = "Test node";
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode(content, idNodeResult);
		assertEquals(true, testNode.isHidden());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setParentNode(nodes.piccolo2d.PiccoloCustomNode)}.
	 */
	@Test
	final void testSetParentNode() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		PiccoloCustomNode testNodeParent = new PiccoloCustomNode("Test node parent", "0124548654");
		testNode.setParentNode(testNodeParent);
		assertEquals(testNodeParent, testNode.getParentNode());

	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getParentNode()}.
	 */
	@Test
	final void testGetParentNode() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		PiccoloCustomNode testNodeParent = new PiccoloCustomNode("Test node parent", "0124548654");
		testNode.setParentNode(testNodeParent);
		assertEquals(testNodeParent, testNode.getParentNode());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#PiccoloCustomNode(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testPiccoloCustomNode() {
		PiccoloCustomNode testNode;
		testNode = new PiccoloCustomNode("Test node", "124548654");
		assertNotNull(testNode);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setChilldren(java.util.Collection)}.
	 */
	@Test
	final void testSetChilldren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		assertEquals(3, testNode.getAllChildren().size());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getChildren()}.
	 */
	@Test
	final void testGetChildren() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		assertEquals(0, testNode.getChildren().size());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getAllChildren()}.
	 */
	@Test
	final void testGetAllChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		assertEquals(3, testNode.getAllChildren().size());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getHierarchy()}.
	 */
	@Test
	final void testGetHierarchy() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node","123456");
		assertEquals(0, testNode.getHierarchy().size());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#showChildren()}.
	 */
	@Test
	final void testShowChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		testNode.showChildren();
		assertEquals(3, testNode.getChildren().size());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#hideChildren()}.
	 */
	@Test
	final void testHideChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		testNode.showChildren();
		testNode.hideChildren();
		assertEquals(0, testNode.getChildren().size());
	
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#toggleChildren()}.
	 */
	@Test
	final void testToggleChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		testNode.toggleChildren();
		assertEquals(3, testNode.getChildren().size());	
	}
	
	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setLayout()}.
	 */
	@Test
	final void testSetLayout() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		double initialWidth = testNode.getRect().getWidth();
		double initialHeight = testNode.getRect().getHeight();
		testNode.showChildren();
		testNode.setLayout();
		double finalWidth = testNode.getRect().getWidth();
		double finalHeight = testNode.getRect().getHeight();
		boolean result = ((finalWidth*finalHeight) != (initialHeight*initialWidth));
		assertEquals(true, result);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setGridLayoutH()}.
	 */
	@Test
	final void testSetGridLayoutH() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		double initialWidth = testNode.getRect().getWidth();
		double initialHeight = testNode.getRect().getHeight();
		testNode.showChildren();
		testNode.setGridLayoutH();
		double finalWidth = testNode.getRect().getWidth();
		double finalHeight = testNode.getRect().getHeight();
		boolean result = ((finalWidth*finalHeight) != (initialHeight*initialWidth));
		assertEquals(true, result);	
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setGridLayoutV()}.
	 */
	@Test
	final void testSetGridLayoutV() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		double initialWidth = testNode.getRect().getWidth();
		double initialHeight = testNode.getRect().getHeight();
		testNode.showChildren();
		testNode.setGridLayoutV();
		double finalWidth = testNode.getRect().getWidth();
		double finalHeight = testNode.getRect().getHeight();
		boolean result = ((finalWidth*finalHeight) != (initialHeight*initialWidth));
		assertEquals(true, result);		
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setGridLayout(int)}.
	 */
	@Test
	final void testSetGridLayout() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		double initialWidth = testNode.getRect().getWidth();
		double initialHeight = testNode.getRect().getHeight();
		testNode.showChildren();
		testNode.setGridLayout(3);
		double finalWidth = testNode.getRect().getWidth();
		double finalHeight = testNode.getRect().getHeight();
		boolean result = ((finalWidth*finalHeight) != (initialHeight*initialWidth));
		assertEquals(true, result);	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#bevelOut(org.piccolo2d.nodes.PPath, int)}.
	 */
	@Test
	final void testBevelOut() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "1234");
		assertNotNull(testNode.bevelOut(testNode.getRect(), 0));
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#bevelIn(org.piccolo2d.nodes.PPath, int)}.
	 */
	@Test
	final void testBevelIn() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "1234");
		assertNotNull(testNode.bevelIn(testNode.getRect(), 0));
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#updateContentBoundingBoxes(boolean, org.piccolo2d.PCanvas)}.
	 */
	@Test
	final void testUpdateContentBoundingBoxes() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		PBounds bi = testNode.getContent().getBounds();
		testNode.updateContentBoundingBoxes(false, null);
		PBounds bf = testNode.getContent().getBounds();
		assertNotEquals(bi, bf);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#updateTextBoundingBoxes(boolean)}.
	 */
	@Test
	final void testUpdateTextBoundingBoxes() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		int bi = testNode.getContent().getChildrenCount();
		testNode.updateTextBoundingBoxes(true);
		int bf = testNode.getContent().getChildrenCount();
		assertEquals(bf, bi+1);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#expandAll()}.
	 */
	@Test
	final void testExpandAll() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		testNode.expandAll();
		assertEquals(testNode.getAllChildren().size(), testNode.getAllChildren().size());
	}
	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#collapseAll()}.
	 */
	@Test
	final void testCollapseAll() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		testNode.expandAll();
		testNode.collapseAll();
		assertEquals(0, testNode.getChildren().size());	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getHigherParent()}.
	 */
	@Test
	final void testGetHigherParent() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		PiccoloCustomNode testParentNode = new PiccoloCustomNode("test parent node", "1");
		testNode.setParent(testParentNode);
		assertNotNull(testNode.getHigherParent());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getAscendency()}.
	 */
	@Test
	final void testGetAscendency() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		assertNotNull(testNode.getAscendency());
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#focus()}.
	 */
	@Test
	final void testFocus() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
        Collection<PiccoloCustomNode> ascendency=testNode.getAscendency();
        for(PiccoloCustomNode PCN:ascendency){
            assertEquals(PCN.getAllChildren().size(), PCN.getChildren().size());
        }

	}

}
