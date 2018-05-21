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



}
