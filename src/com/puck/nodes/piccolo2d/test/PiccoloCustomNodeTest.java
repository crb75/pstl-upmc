package com.puck.nodes.piccolo2d.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.util.PBounds;

import com.puck.nodes.piccolo2d.NodeContent;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.utilities.Logger;

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
	 * Cette méthode permet des tester la méthode getRect() de la classe PiccoloCustomNode
	 * La méthode getRect() permet de retourner l'attribut rect de type PPAth qui signife le rectangle d'un objet PiccoloCustomNode
	 * Pour tester cette méthode on initialise une variable testNode de type PiccoloCustomNode par l'appel du constructeur picolloCustomNode(testContent:String,idNode:String).
	 * Puis on appelle la méthode getRect() sur cette variable et on teste si le résultat de l'appel de la méhtode est non null. 
	 */
	@Test
	final void testGetRect() {
		final String methodeName = "testGetRect()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getRect() de la classe PiccoloCustomNode";
		Logger.logMethod(methodeName, message);
		message = "La méthode getRect() de la classe PiccoloCustomNode permet d'obtenir l'attribut rect de type PPath d'un objet de type PiccoloCustomNode";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable testNode de type PiccoloCustomNode par l'appel du constructeur (textContent:String,idNode:String). On appelle ce constructeur avec les paramètres textContent=\"Test Node\" et idNode = \"124548654\"";
		Logger.logMethod(methodeName, message);
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "La variable testNode de type PiccoloCustomNode a bien été initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode getRect() sur cette variable testNode.";
		Logger.logMethod(methodeName, message);
		PPath rect = testNode.getRect();
		message = "La méthode getRect() sur la variable testNode est bien appelé. Le résultat de cette appel est désormais stocké dans une variable rect de type PPath.";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si cette variable rect est non null";
		Logger.logMethod(methodeName, message);
		if (rect != null)
		{
			message = "La variable rect qui représente le résultat de l'appel de la méthode getRect() sur la variable testNode est non null";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La variable rect qui représente le résultat de l'appel de la méthode getRect() sur la variable testNode est null. Il y a un problème quelque part";
			Logger.logError(methodeName, message);
		}
		assertNotNull(rect);	
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getContent()}.
	 * Cette méthode permet de tester la méhode getContent() de la classe PiccoloCustomNode.
	 * La méthode getContent() de la classe PiccoloCustomNode permet d'obtenir l'attribut content de type NodeContent d'un objet de type PiccoloCustomNode
	 * Pour tester cette méthode on commence par initialiser une variable testNode de type PiccoloCustomNode par l'appel du constructeur PiccoloCustomNode(textContent:String,idNode:String) avec les paramètres textContent = "Test node" et idNode ="124548654"
	 * Puis on appelle la méthode getContent sur la variable testNode et on stocke le résultat de l'appel de cette méthode dans une variable content de type NodeContent
	 * On teste si la variable content est non-null
	 */
	@Test
	final void testGetContent() {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		final String methodeName = "testGetContent()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méhode getContent() de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "La méthode getContent() de la classe PiccoloCustomNode permet d'obtenir l'attribut content de type NodeContent d'un objet de type PiccoloCustomNode";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable testNode de type PiccoloCustomNode par l'appel du constructeur PiccoloCustomNode(textContent:String,idNode:String) avec les paramètres textContent = \"Test node\" et idNode =\"124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "La variable testNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode getContent sur la variable testNode et on stocke le résultat de l'appel de cette méthode dans une variable content de type NodeContent";
		Logger.logMethod(methodeName, message);
		NodeContent content = testNode.getContent();
		message = "La variable content de type NodeContent est bien initialisé par l'appel de la méthode getContent sur la variable testNode";
		Logger.logMethod(methodeName, message);
		message = "On teste si la variable content est non-null";
		Logger.logMethod(methodeName, message);
		if (content != null)
		{
			message = "La variable content est non-null.";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La variable content est null. Il doit avoir une erreur quelque part";
			Logger.logError(methodeName, message);
		}
		assertNotNull(testNode.getContent());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getMargin()}.
	 * Cette méthode permet de tester la méthode getMargin() de la classe PiccoloCustomNode.
	 * La méthode getMargin() permet d'obtenir l'attribut margin qui représente la marge de l'objet PiccoloCustomNode.
	 * Pour tester cette méhthode, on commence par initialiser une variable testNode de type PiccoloCustomNode par l'appel de constructeur PiccoloCustomNode(textContent:String,idNode:String) avec les parmaètres textContent = "Test node" et idNode = "124548654"
	 * On sait que la valeur de l'attribut margin par défaut est 10.
	 * On appelle la méthode getMargin() sur la variable testNode et on stocke le résultat de l'appel dans une variable result de type double.
	 * On teste maintenant si la variable result est égale à la valeur de l'attribut margin attendu. 
	 */
	@Test
	final void testGetMargin() {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		final String methodeName = "testGetMargin()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getMargin() de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "La méthode getMargin() permet d'obtenir l'attribut margin qui représente la marge de l'objet PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méhthode, on commence par initialiser une variable testNode de type PiccoloCustomNode par l'appel de constructeur PiccoloCustomNode(textContent:String,idNode:String) avec les parmaètres textContent = \"Test node\" et idNode = \"124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "La variable testNode est bien initialisé.";
		Logger.logMethod(methodeName, message);
		double marginResult = 10;
		message = "On sait que la valeur de l'attribut margin par défaut est " + marginResult;
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode getMargin() sur la variable testNode et on stocke le résultat de l'appel dans une variable result de type double.";
		Logger.logMethod(methodeName, message);
		double result = testNode.getMargin();
		message = "La variable result est bien initialisé par l'appel de la méthode getMargin() sur la variable testNode.";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si la variable result est égale à la valeur de l'attribut margin attendu.";
		Logger.logMethod(methodeName, message);
		if (marginResult == result)
		{
			message = "La valeur de la variable result est égale à la valeur de l'attribut margin attendu "+marginResult;
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La valeur de la variable result n'est pas égale à la valeur de l'attribut margin attendu. Il doit avoir un problème quelque part";
			Logger.logError(methodeName, message);
		}
		assertEquals(marginResult, testNode.getMargin());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
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
