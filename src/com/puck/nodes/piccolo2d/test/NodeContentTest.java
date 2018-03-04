package com.puck.nodes.piccolo2d.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.piccolo2d.nodes.PText;

import com.puck.nodes.piccolo2d.NodeContent;
import com.puck.utilities.Logger;

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

	/*
	 * Cette méthode permet de tester la méthode getMargin de la classe NodeContent 
	 * qui permet de retourner l'attribut margin de la classe. Pour tester cette méthode on suit les démarches suivantes:
	 * - On initialise une variable nc de type NodeContent avec une variable de type PText qui contient le text "Test" et avec une variable de type String initialisée à 'package' pour définir le type du noeud 
	 * - Puis on appelle la méthode getMargin sur cette objet nc. 
	 * - On sait que l'attribut margin par défaut vaut 10
	 * - Pour conclure le test on contrôle si la valeur retourné par la méthode est bien égale a 10 
	 * */
	@Test
	final void testGetMargin() {
		final String methodeName = "testGetMargin";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getMargin de la classe NodeContent qui permet d'obtenir l'attribut margin de la classe NodeContent";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable nc de type NodeContent avec une variable de type PText qui contient le text \"Test\" et avec une variable de type String initialisée à 'package' pour définir le type du noeud";
		Logger.logMethod(methodeName, message);
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1), "package");
		message = "La variable nc est bien été initialisé";
		Logger.logMethod(methodeName, message);
		message = "On sait que la marge par défaut est 10. On teste maintenant si le résultat retourné par cet appel est bien 10";
		Logger.logMethod(methodeName, message);
		if (nc.getMargin() == 10)
		{
			message = "La valeur retournée par cet appel de la méthode est égale à 10";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les résultats ne correspondent pas. Il doit avoir un problème quelque part.";
			Logger.logError(methodeName, message);
		}
		assertEquals(10, nc.getMargin());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setMargin(margin:int) de la classe NodeContent qui permet de changer la valeur de l'attribut margin de la classe NodeContent par la nouvelle valeur margin passée en paramètre
	 * Pour tester cette méthode on commence par créer une variable nc de type NodeContent en passant une variable de type PText initialisé avec le String "Test" en paramètres ainsi que la chaîne de caractères 'package' pour définir le type du noeud .
	 * On appelle en suite la méthode setMargin avec margin = 10000 qui permet de changer la valeur de l'attribut margin de 10 à 10000.
	 * Pour tester si toute est bien passée, on teste si la valeur retourné par la méthode getMargin() est égale à la nouvelle valeur de la margin.
	 * */
	@Test
	final void testSetMargin() {
		final String methodeName = "testSetMargin()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setMargin(margin:int) de la classe NodeContent qui permet de changer la valeur de l'attribut margin de la classe NodeContent par la nouvelle valeur margin passée en paramètres";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par créer une variable nc de type NodeContent en passant une variable de type PText initialisé avec le String \"Test\" ainsi que la chaîne des caractères 'package' pour définir le type du noued en paramètres.";
		Logger.logMethod(methodeName, message);
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1), "package");
		message = "La variable nc est bien initialisée";
		Logger.logMethod(methodeName, message);
		int margin = 10000;
		message = "On appelle en suite la méthode setMargin avec margin = 10000 qui permet de changer la valeur de l'attribut margin de 10 à 10000.";
		Logger.logMethod(methodeName, message);
		nc.setMargin(margin);
		message = "La méthode setMargin est bien appelée avec la nouvelle valeur de margin " + margin;
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si le résultat retourné par la méthode getMargin() sur cette nouvelle variable NodeContent est égale à la valeur de la nouvelle margin";
		Logger.logMethod(methodeName, message);
		if (nc.getMargin() == margin)
		{
			message = "La valeur de la nouvelle margin correspond bien avec la valeur attendue " + margin;
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les valeurs ne correspondent pas";
			Logger.logMethod(methodeName, message);
		}
		assertEquals(margin, nc.getMargin());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getText() de la classe NodeContent qui permet de retourner l'attribut Text de la classe NodeContent
	 * Pour tester cette méthode on commence par initialiser une variable nc de type NodeContent en passant en paramtères une variable de type PText avec la chaîne des caractères "Test" ainsi qu'une chaîne de caractères 'package' pour définir le type du noeud
	 * Puis on appelle la méthode getText() sur cette variable, et on teste si le résultat est non null
	 * */
	@Test
	final void testGetText() {
		final String methodeName = "testGetText()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getText() de la classe NodeContent qui permet de retourner l'attribut Text de la classe NodeContent";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable nc de type NodeContent en passant en paramtères une variable de type PText avec la chaîne des caractères \"Test\" ainsi que la chaîne de caractères 'package' pour définir le type du noeud";
		Logger.logMethod(methodeName, message);
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1),"package");
		message = "la variable nc de type NodeContent est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "On appelle maintenant la méthode getText sur cette variable nc et on teste si le résultat est non null";
		Logger.logMethod(methodeName, message);
		if (nc.getText() == null)
		{
			message = "Le résultat de retour de cette méthode est null";
			Logger.logError(methodeName, message);
		}
		else
		{
			message = "Le résultat de l'appel de cette méthode est non null.";
			Logger.logMethod(methodeName, message);
		}
		assertNotNull(nc.getText());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}	

	/*
	 * Cette méthode permet de tester la méthode setText(text:String) de la classe NodeContent qui permet de changer le text de la variable.
	 * Pour tester cette méthode on initialise d'abord une variable nc de type NodeContent avec le text "Test" ainsi que la chaîne de caractères 'package' pour définir le type du noeud
	 * Puis on appelle cette méthode avec le paramètre text = "Test 1" qui permet de changer le texte de l'objet de "Test" à "Test 1".
	 * Pour contrôler si tout est bien passée, on appelle la méthode toString() sur la variable nc et on teste si le résultat obtenu correspond bien avec le résultat attendu.
	 * */
	@Test
	final void testSetText() {
		final String methodeName = "testSetText()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setText(text:String) de la classe NodeContent qui permet de changer le text de la variable.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on initialise d'abord une variable nc de type NodeContent avec le text \"Test\" ainsi que la chaîne de caractères 'package' pour définir le type du noeud";
		Logger.logMethod(methodeName, message);
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1),"package");
		message = "La variable nc de type NodeContent est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle cette méthode avec le paramètre text = \"Test 1\" qui permet de changer le texte de l'objet de \"Test\" à \"Test 1\".";
		Logger.logMethod(methodeName, message);
		String nct2 = "Test 1";
		nc.setText(nct2);
		message = "La méthode setText est bien appellée avec le nouveau text " + nct2;
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si le résultat attendu correspond bien avec le résultat obtenu";
		Logger.logMethod(methodeName, message);
		if (nct2.equals(nc.toString()))
		{
			message = "Le résultat attendu correspond bien avec le résultat obtenu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat attendu ne correspond pas avec le résultat obtenu";
			Logger.logMethod(methodeName, message);
		}
		assertEquals(nct2, nc.toString());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getIcon qui permet d'obtenir l'attribut icon de la classe NodeContent.
	 * Pour tester cette méthode, on commence par initialiser une variable nc de type NodeContent avec le text "Test" ainsi que la chaîne de caractères 'package' pour définir le type du noeud
	 * Ensuite on appelle la méthode getIcon() sur la variable nc
	 * Par défaut tout type de noeud a son propre icon, donc on teste si l'appel de la méthode getIcon() est non null
	 * */
	@Test
	final void testGetIcon() {
		final String methodeName = "testGetIcon()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getIcon de la classe NodeContent qui permet d'obtenir la valeur de l'attribut icon";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable nc de type NodeContent avec le text \"Test\" et avec une chaîne de caracètres 'package' pour définir le type du noeud";
		Logger.logMethod(methodeName, message);
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1),"package");
		message = "La variable nc est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "On appelle maintenant la méthode getIcon sur cette variable";
		Logger.logMethod(methodeName, message);
		message = "Par défaut tout type de noeud a son propre icon, donc on teste si l'appel de la méthode getIcon() est non null";
		Logger.logMethod(methodeName, message);
		if (nc.getIcon() != null)
		{
			message = "Le résultat attendu correspond bien avec le résultat obtenu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
			Logger.logError(methodeName, message);
		}
		assertNotNull(nc.getIcon());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode le contructeur de la classe NodeContent.
	 * Pour le tester on initialise une varible nc de type NodeContent avec le text Test et avec le type "package" par l'appel du constructeur
	 * Puis on teste si la variable nc n'est pas null.
	 * */
	@Test
	final void testNodeContent() {
		final String methodeName = "testNodeContent()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester le constructeur de la classe NodeContent ";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par initialiser une variable nc de type NodeContent avec le text Test et avec le type 'package' par l'appel du constructeur.";
		Logger.logMethod(methodeName, message);
		NodeContent nc;
		nc = new NodeContent(new PText("Test"),"package");
		message = "La variable nc est bien été initialisée";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si cette variable est non null";
		Logger.logMethod(methodeName, message);
		if (nc != null)
		{
			message = "Cette variable est non null. Donc le constructeur a bien fait son travail";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La variable est null. Il doit avoir un problème quelque part";
			Logger.logError(methodeName, message);
		}
		assertNotNull(nc);
	}

	/*
	 * Cette méthode permet de tester la méthode toString() de la classe NodeContent, qui permet de donner une affichage en chaînes de caractères d'une objet de type NodeContent.
	 * Plus précisement, cette méthode retourne le text contenu dans cette objet.
	 * Pour tester cette méthode, on commence par initialiser une variable nc de type NodeContent avec le text Test et avec le type "package".
	 * Puis on appelle la méthode toString() sur cette variable nc qui doit normalement retourner la chaîne des caractères Test.
	 * On teste si la valeur retournée par l'appel de la méthode correspond bien avec le résultat attendu.
	 * */
	@Test
	final void testToString() {
		final String methodeName = "testToString()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode toString() de la classe NodeContent, qui permet de donner une affichage en chaînes de caractères d'une objet de type NodeContent.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par initialiser une variable nc de type NodeContent avec le text Test et avec le type 'package'";
		Logger.logMethod(methodeName, message);
		NodeContent nc = new NodeContent(new PText("Test"),"package");
		message = "Cette variable nc est bien été initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode toString() sur cette variable nc qui doit normalement retourner la chaîne des caractères Test.";
		Logger.logMethod(methodeName, message);
		String actual = nc.toString();
		message = "La méthode toString() est bien appelée sur la variable nc";
		Logger.logMethod(methodeName, message);
		message = "On teste si la valeur retournée par l'appel de la méthode correspond bien avec le résultat attendu.";
		Logger.logMethod(methodeName, message);
		if (actual.equals("Test"))
		{
			message = "Le résultat obtenu correspond bien avec le résultat attendu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
			Logger.logError(methodeName, message);
		}
		assertEquals("Test",nc.toString());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

}
