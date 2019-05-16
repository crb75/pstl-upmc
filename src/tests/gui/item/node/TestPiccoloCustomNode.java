package tests.gui.item.node;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.util.PBounds;

import puck.gui.item.node.NodeContent;
import puck.gui.item.node.PiccoloCustomNode;

public class TestPiccoloCustomNode {
	
	PiccoloCustomNode testNode;

	@Before
	public void beforeTests() {
		testNode = new PiccoloCustomNode("Test node", "124548654","package");
	}
	
	@After
	public void afterTests() {
		testNode = null;
	}
	
	/**
	 * La m�thode getRect() permet de retourner l'attribut rect de type PPAah qui signife le rectangle d'un objet PiccoloCustomNode
	 * Pour tester cette méthode on initialise une variable testNode de type PiccoloCustomNode 
	 * par l'appel du constructeur PiccoloCustomNode(textContent:String,idNode:String,type:String).
	 * Puis on appelle la m�thode getRect() sur cette variable et on teste si le résultat de l'appel de la méhtode est non null. 
	 */
	@Test
	public void testGetRect() {
		PPath rect = testNode.getRect();
		assertNotNull(rect);
	}
	
	
	/**
	 * La méthode getContent() de la classe PiccoloCustomNode permet d'obtenir l'attribut content de type NodeContent d'un objet de type PiccoloCustomNode
	 * Pour tester cette méthode on commence par initialiser une variable testNode de type PiccoloCustomNode par l'appel du constructeur PiccoloCustomNode(textContent:String,idNode:String,type:String) avec les paramètres textContent = "Test node" et idNode ="124548654"
	 * Puis on appelle la méthode getContent sur la variable testNode et on stocke le résultat de l'appel de cette méthode dans une variable content de type NodeContent
	 * On teste si la variable content est non-null
	 */
	@Test
	public void testGetContent() {
		NodeContent content = testNode.getContent();
		assertNotNull(testNode.getContent());
		assertEquals(testNode.getContent().toString(),"Test node");
	}
	
	

	@Test
	public void testGetMargin() {
		double marginResult = 10;
		double result = testNode.getMargin();
		assertEquals(marginResult, result);
	}
	
	@Test
	public void testSetMargin() {
		testNode.setMargin(20);
		assertEquals(20, testNode.getMargin());
	}

	
	@Test
	public void testGetIdNode() {
		String idNodeResult = "124548654";
		String idNNode = testNode.getidNode();
		assertEquals(idNodeResult,idNNode);
	}

	
	@Test
	public void testToString() {
		assertEquals(testNode.toString(),"Test node");
	}
	
	
	@Test
	public void testIsHidden() {
		assertEquals(testNode.isHidden(),true);
	}
	
	@Test
	public void testSetParent() {
		PiccoloCustomNode testNodeParent = new PiccoloCustomNode("Parent", "42","class");
		testNode.setParentNode(testNodeParent);
		assertEquals(testNodeParent, testNode.getParentNode());
	}
	
	@Test
	public void testGetParent() {
		assertEquals(null, testNode.getParentNode());
	}
	
	
	@Test
	public void testPiccoloCustomNode() {
		assertNotNull(testNode);
		assertEquals(null, testNode.getParentNode());
		assertEquals("124548654",testNode.getidNode());
		assertEquals(testNode.getContent().toString(),"Test node");
		assertEquals(testNode.getContent().getType(),"package");
	}
	
	@Test
	public void testSetChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		int result = testNode.getAllChildren().size();
		assertEquals(3, testNode.getAllChildren().size());
	}
	
	
	@Test
	public void test1GetChildren() {
		assertEquals(0, testNode.getChildren().size());
	}
	
	
	@Test
	public void test2GetChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		testNode.toggleChildren();
		assertEquals(3, testNode.getChildren().size());
	}
	
	@Test
	public void testGetAllChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		assertEquals(3, testNode.getAllChildren().size());
	}
	
	/**
	 * La méthode getHierarchy() de la classe PiccoloCustomNode permet de retourner une liste de tous les noeuds contenus sous le noeud actuel c'est � dire qu'il fait un parcours en largeur du structure arborescente en considerant le noeud actuel comme la racine de l'arbre.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String, type:String) avec les paramètres textContent="Test node", idNode="124548654" et type="package"
	 * Par défaut un noeud de type PiccoloCustomNode ne contient aucun enfant à l'initialisation, donc la taille de la collection restourné par l'appel de la méthode getHierarchy() sur la variable testNode doit être 0.
	 * Pour tester si c'est bien le cas, on appelle la méthode getHierarchy().size() sur la variable testNode et on stocke le résutat de cet appel dans une variable result de type int.
	 * Puis on teste si la valeur de la variable result est bien 0.
	 */
	@Test
	public void test1GetHierarchy() {
		int result = testNode.getHierarchy().size();
		assertEquals(0,result);
	}
	
	@Test
	public void test2GetHierarchy() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		PiccoloCustomNode c1 = new PiccoloCustomNode("Je suis un child 01", "01","class");
		c1.addChild( new PiccoloCustomNode("Je suis un child 04", "04","method"));
		children.add(c1);
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		ArrayList<String> listString = new ArrayList<String>();
		listString.add("Je suis un child 01");
		listString.add("Je suis un child 02");
		listString.add("Je suis un child 03");
		listString.add("Je suis un child 04");
		testNode.setChilldren(children);
		assertEquals(4,testNode.getHierarchy().size());
	}
	
	@Test
	public void testShowChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		testNode.showChildren();
		assertEquals(0, testNode.getHiddenchildren().size());
		assertEquals(3,testNode.getChildren().size());
	}
	
	
	@Test
	public void testHideChildren() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		testNode.showChildren();
		assertEquals(0, testNode.getHiddenchildren().size());
		testNode.hideChildren();
		assertEquals(0,testNode.getChildren().size());
		assertEquals(3, testNode.getHiddenchildren().size());
	}
	
	
	
	
	/**
	 * La méthode setLayout() permet de définir l'affichage du noeud par rapport à ses enfants. C'est à dire que si le noeud contient des enfants qui sont visibles, l'appel de la méthode setLayout() sur cette noeud permet d'aggrandir le rectangle représentant ce noeud en fonction de ses enfants.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String, type:String) avec les paramètres textContent="Test node", idNode="124548654" et type="package"
	 * Puis on initialise une variable children de type ArrayList<PiccoloCustomNode> avec une liste vide.
	 * Puis on y ajoute 3 éléments de type PiccoloCustomNode sur cette liste en appelant la méthdode add sur cette variable.
	 * Les noeuds qu'on ajoute sont définis à la volée au moment d'appel de la méthode add.
	 * Une fois qu'on a ajouté tous les trois noeuds sur la liste, on appelle la métode setChilldren en passant la liste children en paramètre.
	 * Les noeuds enfants qu'on vients d'ajouter sont par défaut cachées. 
	 * On récupère maintenant le largeur du rectangle représentant le noued par l'appel de méthode getRect().getWidth() sur la variable testNode on stocke le résultat de cet appel dans une variable initialWidth de type double.
	 * Et puis on récupère l'hauteur du rectangle représentatnt le noeud par l'appel de la méthode getRect.getHeihgt() sur la variable testNode. On stocke le résultat de cet appel dans une variable initialHeight de type double.
	 * Ensuite on appelle la méthode showChildren() pour rendre les noeuds enfants visible.
	 * Une fois que les noeuds ensembles sont visible, on appelle la méthode setLayout() pour que le changement de visibilité de ces enfant est prise en compte.
	 * Une fois le layout est mis à jour, on appelle la méthode getRect().getWidth() pour récupèrer le largeur actuel du noeud et on sotcke le résultat de cet appel dans une variable finalWidth de type double.
	 * On fait la même chose pour l'hauteur finale. C'est à dire qu'on appelle la méthode getRect().getHeight() sur la variable testNode et on stocke le résultat de cet apprel dans une variable finalHeight de type double.
	 * Puis on teste si la surface du rectangle initial est différent que la surface actuel du rectangle qui représente le noeud.
	 * Pour le faire, calcule la surface initiale et on le compare d'inégalité avec le surface finale. Le résultat de cette comparasion, on le stocke dans une variable result de type boolean.
	 * Puis on teste si la valeur de la variable result est true.
	 */
	@Test
	public void testSetLayout() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
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
	
	
	@Test
	public void testSetGridLayout() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		double initialWidth = testNode.getRect().getWidth();
		double initialHeight = testNode.getRect().getHeight();
		testNode.showChildren();
		testNode.setGridLayout(3);
		double finalWidth = testNode.getRect().getWidth();
		double finalHeight = testNode.getRect().getHeight();
		boolean result = ((finalWidth*finalHeight) != (initialHeight*initialWidth));
		assertEquals(true, result);
	}
	
	

	@Test
	public void testBevelOut() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "1234","package");
		assertNotNull(testNode.bevelOut(testNode.getRect(), 0));
	}


	@Test
	public void testBevelIn() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "1234","package");
		assertNotNull(testNode.bevelIn(testNode.getRect(), 0));
	}

	@Test
	public void testUpdateContentBoundingBoxes() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654","package");
		testNode.setChilldren(children);
		PBounds bi = testNode.getContent().getBounds();
		testNode.updateContentBoundingBoxes(false, null);
		PBounds bf = testNode.getContent().getBounds();
		assertNotEquals(bi, bf);
	}


	@Test
	public void testUpdateTextBoundingBoxes() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		int bi = testNode.getContent().getChildrenCount();
		testNode.updateTextBoundingBoxes(true);
		int bf = testNode.getContent().getChildrenCount();
		assertEquals(bf, bi+1);
	}


	@Test
	public void testExpandAll() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		testNode.expandAll();
		assertEquals(testNode.getAllChildren().size(), testNode.getAllChildren().size());
	}

	
	@Test
	public void testCollapseAll() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		testNode.expandAll();
		testNode.collapseAll();
		assertEquals(0, testNode.getChildren().size());	}


	@Test
	public void testGetHigherParent() {
		PiccoloCustomNode testParentNode = new PiccoloCustomNode("test parent node", "1","package");
		testNode.setParent(testParentNode);
		assertNotNull(testNode.getHigherParent());
	}


	@Test
	public void testGetAscendency() {
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654","packge");
		assertNotNull(testNode.getAscendency());
	}


	@Test
	public void test1Focus() {
		testNode.focus();
		assertEquals(0,testNode.getChildren().size());
	}
	
	@Test
	public void test2Focus() {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01","class"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02","class"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03","class"));
		testNode.setChilldren(children);
		testNode.focus();
		assertEquals(3,testNode.getChildren().size());
	}
}
