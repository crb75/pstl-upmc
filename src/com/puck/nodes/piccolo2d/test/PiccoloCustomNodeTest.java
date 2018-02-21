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
	 * Cette méthode permet de tester la méthode setMargin(margin:double) de la classe PiccoloCustomNode.
	 * La méthode setMArgin(margin:double) permet de changer la valeur de l'attribut margin d'un objet de type PiccoloCustomNode.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Puis on appelle la methode setMargin(margin:double) sur cette variable avec le paramètre margin=15 qui est censé de changer la valeur de l'attribut margin de la variable testNode avec 15.
	 * Pour tester si le changement est bien passé, on teste si la nouvelle valeur de l'attribut margin de cette varaible est égale à la valeur qu'on a défini. 
	 */
	@Test		
	final void testSetMargin() {
		final String methodeName = "testSetMargin()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setMargin(margin:double) de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "La méthode setMArgin(margin:double) permet de changer la valeur de l'attribut margin d'un objet de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "La variable testNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		double marginResult = 15;
		message = "Puis on appelle la methode setMargin(margin:double) sur cette variable avec le paramètre margin="+marginResult+" qui est censé de changer la valeur de l'attribut margin de la variable testNode avec 15.";
		Logger.logMethod(methodeName, message);
		testNode.setMargin(marginResult);
		message = "La méthode setMargin(margin:double) est bien appelé avec le paramètre margin="+marginResult;
		Logger.logMethod(methodeName, message);
		message = " Pour tester si le changement est bien passé, on teste si la nouvelle valeur de l'attribut margin de cette varaible est égale à la valeur qu'on a défini.";
		Logger.logMethod(methodeName, message);
		double nmargin = testNode.getMargin();
		if (nmargin == marginResult)
		{
			message = "Le changement est bien eu lieu. La nouvelle valeur de l'attribut margin est égale à la valeur qu'on a passée au paramètre de la méthode setMargin";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La nouvelle valeur de l'attribut margin ne correspond pas avec la valeur margin qu'on a passée en paramètre de la méhode setMargin";
			Logger.logError(methodeName, message);
		}
		assertEquals(marginResult, testNode.getMargin());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getidNode()}.
	 * Cette méthode permet de tester la méthode getIdNode() de la clasee PiccoloCustomNode.
	 * La méthode getIdNode() permet de d'obtenir la valeur de l'attribut id d'un objet de type PiccoloCustomNode.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Puis on appelle la métode getIdNode() sur cette variable testNode et on stocke le résultat de retour dans une variable idNNode de type String.
	 * On teste maintenant si la valeur de la variable idNNode est égale à la valeur du paramètre idNode qu'on avait passé aux paramètres de constrcuteur PiccoloCustomNode au moment d'initialisation de la variable testNode. 
	 */
	@Test
	final void testGetidNode() {
		final String methodeName = "testGetidNode()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getIdNode() de la clasee PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		String idNodeResult = "124548654";
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", idNodeResult);
		message = "La variable testNode de type PiccoloCustomNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la métode getIdNode() sur cette variable testNode et on stocke le résultat de retour dans une variable idNNode de type String.";
		Logger.logMethod(methodeName, message);
		String idNNode = testNode.getidNode();
		message = "La variable idNNode est bien initialisée par l'appel de la méthode getidNode() sur la variable testNode.";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si la valeur de la variable idNNode est égale à la valeur du paramètre idNode qu'on avait passé aux paramètres de constrcuteur PiccoloCustomNode au moment d'initialisation de la variable testNode.";
		Logger.logMethod(methodeName, message);
		if (idNodeResult.equals(idNNode))
		{
			message = "La valeur de la variable id de la variable testNode est égale à la valeur du paramètre idNode qu'on avait passé au constructeur PiccoloCustomNode(textContent:String,idNode:String) au moment d'initialisation de la variable testNode";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La valeur de l'attribut id de la variable testNode ne correspond pas avec la valeur du paramtère idNode qu'on a passé au paramètre du constructeur PiccoloCustomNode(textContent:String,idNode:String) au moment d'initialisation de la variable testNode.";
			Logger.logError(methodeName, message);
		}	
		assertEquals(idNodeResult, testNode.getidNode());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#toString()}.
	 * Cette méthode permet de tester la méthode toString de la classe PiccoloCustomNode.
	 * La méthode toString() de la classe PiccoloCustomNode permet d'obtenir le contenu d'un objet de type PiccoloCustomNode sous forme de String. Plus précisement, cette méthode retourne la valeur textuel qu'on a initialisé dans le constructeur par le paramètre textContent d'un objet de type PiccoloCustomNode.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Puis on appelle la méthode toString() sur la variable testNode et on stocke le résultat de cet appel dans une variable nnContent de type String.
	 * On teste maintenant si la valeur de la variable nnContent correspond bien avec la valeur du paramètre textContent qu'on a passé dans le constructeur PiccoloCustomNode(textContent:String,idNode:String) au moment d'initialisation de la variable testNode. 
	 */
	@Test
	final void testToString() {
		final String methodeName = "testToString()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode toString de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "La méthode toString() de la classe PiccoloCustomNode permet d'obtenir le contenu d'un objet de type PiccoloCustomNode sous forme de String. Plus précisement, cette méthode retourne la valeur textuel qu'on a initialisé dans le constructeur par le paramètre textContent d'un objet de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		String idNodeResult = "124548654";
		String content = "Test node";
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNode = new PiccoloCustomNode(content, idNodeResult);
		message = "La variable testNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode toString() sur la variable testNode et on stocke le résultat de cet appel dans une variable nnContent de type String.";
		Logger.logMethod(methodeName, message);
		String nnContent = testNode.toString();
		message = "La variable nnContent est bien initialisée par l'appel du méthode toString() sur la variable testNode.";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si la valeur de la variable nnContent correspond bien avec la valeur du paramètre textContent qu'on a passé dans le constructeur PiccoloCustomNode(textContent:String,idNode:String) au moment d'initialisation de la variable testNode.";
		Logger.logMethod(methodeName, message);
		if (nnContent.equals(content))
		{
			message = "La valeur de la variable nnContent est égale à la valeur du paramètre textContent qu'on a passé en paramètre du constructeur PiccoloCustomNode(textContent:String,idNode:String) au moment d'initialisation de la variable testNode.";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La valeur de la variable nnContent est différent de la valeur du paramètre textContent qu'on a passé en paramètre du constructeur PiccoloCustomNode(textContent:String,idNode:String) au moment d'initialisation de la variable testNode.";
			Logger.logError(methodeName, message);
		}
		assertEquals(content, testNode.toString());	
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#isHidden()}.
	 * Cette méthode permet de tester la méthode isHidden() de la classe PiccoloCustomNode.
	 * La méthode isHidden() de la classe PiccoloCustomNode permet de tester si le noeud est caché ou pas
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Par défaut un objet de type PiccoloCustomNode est initialisé comme étant un noeud caché, donc l'appel de la méthode est censé retourner true.
	 * On appelle la méthode isHidden() sur la variable testNode et on stocker le résultat de cet appel dans une variable h du type bool
	 * On teste maintenant si la valeur de la variable h est true.
	 */
	@Test
	final void testIsHidden() {
		final String methodeName = "testIsHidden()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode isHidden() de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		String idNodeResult = "124548654";
		String content = "Test node";
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode(content, idNodeResult);
		message = "La variable testNode est bien initialisée.";
		Logger.logMethod(methodeName, message);
		message = "Par défaut un objet de type PiccoloCustomNode est initialisé comme étant un noeud caché, donc l'appel de la méthode est censé retourner true.";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode isHidden() sur la variable testNode et on stocker le résultat de cet appel dans une variable h du type bool";
		Logger.logMethod(methodeName, message);
		boolean h = testNode.isHidden();
		message = "La variable h est bien initialisée par l'appel de la méthode isHidden() sur la variable testNode.";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si la valeur de la variable h est true.";
		Logger.logMethod(methodeName, message);
		if (h) {
			message = "La valer de la variable h est true. Donc la variable testNode est bien initialisée comme étant cachée";
			Logger.logMethod(methodeName, message);
		} else {
			message = "La valeur de la variable h est false. Donc la variable testNode est initialisée comme étant visible. Il doit avoir un problème quelqque part";
			Logger.logError(methodeName, message);
		}
		assertEquals(true, testNode.isHidden());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#setParentNode(nodes.piccolo2d.PiccoloCustomNode)}.
	 * Cette méthode permet de tester la méthode setParentNode(parent:PiccoloCustomNode) de la classe PiccoloCustomNode.
	 * La méthode setParentNode(parent:PiccoloCustomNode) permet d'initialiser le noeud père d'un neud PiccoloCustomNode.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Ainsi on initialise une autre variable testNodeParent de type PiccoloCustomNode par l'appel du même constructeur mais avec les paramètres textContent = "Test node parent" et idNode = "0124548654"
	 * Puis on appelle la méthode setParentNode en passant la variable testNodeParent en paramètres. Ceci est censé d'initialiser le noeud testNodeParent comme étant le noeud père du noeud testNode.
	 * Pour tester si tout est bien passé, on appelle la méthode getParentNode() sur la variable testNode et on stocke le résultat de cet appel dans une variable result de type PiccoloCustomNode.
	 * Puis on teste si la variable result est la même que la variable testNodeParent.
	 */
	@Test
	final void testSetParentNode() {
		final String methodeName = "testSetParentNode()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setParentNode(parent:PiccoloCustomNode) de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "La méthode setParentNode(parent:PiccoloCustomNode) permet d'initialiser le noeud père d'un neud PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "La variable testNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Ainsi on initialise une autre variable testNodeParent de type PiccoloCustomNode par l'appel du même constructeur mais avec les paramètres textContent = \"Test node parent\" et idNode = \"0124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNodeParent = new PiccoloCustomNode("Test node parent", "0124548654");
		message = "La variable testNodeParent est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode setParentNode en passant la variable testNodeParent en paramètres. Ceci est censé d'initialiser le noeud testNodeParent comme étant le noeud père du noeud testNode.";
		Logger.logMethod(methodeName, message);
		testNode.setParentNode(testNodeParent);
		message = "La méthode setParentNode est bien appelée sur la variable testNode avec la variable testNodeParent en paramètre";
		Logger.logMethod(methodeName, message);
		message = "Pour tester si tout est bien passé, on appelle la méthode getParentNode() sur la variable testNode et on stocke le résultat de cet appel dans une variable result de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode result = testNode.getParentNode();
		message = "La variable result est bien initialisée par l'appel de la methode getParentNode() sur la variable testNode";
		Logger.logMethod(methodeName, message);
		message = "Puis on teste si la variable result est la même que la variable testNodeParent.";
		Logger.logMethod(methodeName, message);
		if (result.equals(testNodeParent)) {
			message = "La variable result est la même que la variable testNodeParent.";
			Logger.logMethod(methodeName, message);
		} else {
			message = "La variable result est différente de la variable testNodeParent";
			Logger.logError(methodeName, message);
		}
		assertEquals(testNodeParent, testNode.getParentNode());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#getParentNode()}.
	 * Cette méthode permet de tester la méthode getParentNode() de la classe PiccoloCustomNode.
	 * La méthode getParentNode() permet d'obtenir le noeud père du noeud de type PiccoloCustomNode.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Ainsi on initialise une variable testNodeParent avec le même constructeur qu'on a initialisé la variable testNode avec les paramètres textContent="Test node parent" idNode="0124548654"
	 * On appelle la méthode setParentNode sur la variable testNode en lui passant testNodeParent en paramètre.
	 * Puis on appelle la méthode getParentNode() sur la variable testNode et on stocke le résultat de cet appel dans une variable result de type PiccoloCustomNode.
	 * On teste maintenant si la variable result est identique à la variable testParentNode.
	 */
	@Test
	final void testGetParentNode() {
		final String methodeName = "testGetParentNode()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getParentNode() de la classe PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "La méthode getParentNode() permet d'obtenir le noeud père du noeud de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "La variable testNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Ainsi on initialise une variable testNodeParent avec le même constructeur qu'on a initialisé la variable testNode avec les paramètres textContent=\"Test node parent\" idNode=\"0124548654\"";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNodeParent = new PiccoloCustomNode("Test node parent", "0124548654");
		message = "La variable testNodeParent est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode setParentNode sur la variable testNode en lui passant testNodeParent en paramètre.";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode getParentNode() sur la variable testNode et on stocke le résultat de cet appel dans une variable result de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		testNode.setParentNode(testNodeParent);
		message = "La méthode setParentNode est bien appéllée en lui passant la variable testNodeParent en paramètres";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode getParentNode() sur la variable testNode et on stocke le résultat de cet appel dans une variable result de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode result = testNode.getParentNode();
		if (result.equals(testNodeParent)) {
			message = "La variable result est identique que la variable testParentNode.";
			Logger.logMethod(methodeName, message);
		} else {
			message = "La variable result est différent de la variable testParentNode.";
			Logger.logError(methodeName, message);
		}
		assertEquals(testNodeParent, testNode.getParentNode());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link nodes.piccolo2d.PiccoloCustomNode#PiccoloCustomNode(java.lang.String, java.lang.String)}.
	 * Cette méthode permet de tester la méthode constructeur de la classe PiccoloCustomNode.
	 * Le constucteur permet de créer un objet de type PiccoloCustomNode.
	 * Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent="Test node" et idNode="124548654"
	 * Puis on teste si la variable testNode est non null
	 */
	@Test
	final void testPiccoloCustomNode() {
		final String methodeName = "testPiccoloCustomNode()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Le constucteur permet de créer un objet de type PiccoloCustomNode.";
		Logger.logMethod(methodeName, message);
		PiccoloCustomNode testNode;
		message = "Pour tester cette méthode, on commence par intialiser une variable testNode de type PiccoloCustomNode en appelant le constructeur PiccoloCustomNode(textContent: String, idNode:String) avec les paramètres textContent=\"Test node\" et idNode=\"124548654\"";
		Logger.logMethod(methodeName, message);
		message = "La variable testNode est bien initialisée";
		Logger.logMethod(methodeName, message);
		testNode = new PiccoloCustomNode("Test node", "124548654");
		message = "Puis on teste si la variable testNode est non null";
		Logger.logMethod(methodeName, message);
		if (testNode != null) {
			message = "La variable testNode est non null";
			Logger.logMethod(methodeName, message);
		} else {
			message = "La variable testNode est null. Il y a un problème quelque part";
			Logger.logError(methodeName, message);
		}
		assertNotNull(testNode);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
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
