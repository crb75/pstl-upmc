package com.puck.nodes.piccolo2d.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.puck.nodes.piccolo2d.Edge;
import com.puck.utilities.Logger;

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

	/* 
	 * Cette méthode permet de tester le contructeur de la classe Edge.
	 * Pour tester ce constructeur, on initialise une variable e en faisant l'appel à ce constructeur.
	 * On teste si la variable est non null
	 * */
	@Test
	final void testEdge() {
		final String methodeName = "testEdge()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Pour tester ce constructeur, on initialise une variable e en faisant l'appel à ce constructeur";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e est bien été initialisé";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si cette variable n'est pas null";
		Logger.logMethod(methodeName, message);
		if (e != null)
		{
			message = "La variable e n'est pas null";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La variable e est null";
			Logger.logError(methodeName, message);
		}
		assertNotNull(e);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getType de la classe Edge, qui permet d'obtenir l'attribut type.
	 * Pour tester cette méthode, on commence par initialiser une variable e de type Edge
	 * Puis on appelle la méthode getType sur la variable e
	 * Par défaut l'attibut type d'une objet de type Edge est la chaîne caractère vide,
	 * On teste alors si la valeur par défaut est égale à la valeur retourne par l'appel de la méthode getType sur la variable e
	 * */
	@Test
	final void testGetType() {
		final String methodeName = "testGetType()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getType de la classe Edge qui permet d'obtenir l'attribut type";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "la variable e est bien été initialisée";
		Logger.logMethod(methodeName, message);
		message = "Par défaut la valeur de l'attribut type d'une objet de type Edge est la chaîne des caractères vide";
		Logger.logMethod(methodeName, message);
		message = "On appelle maintent la méthode getType() sur la variable e";
		Logger.logMethod(methodeName, message);
		String actual = e.getType();
		message = "La valeur retourné par cette méthode est " + actual;
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si la valeur retourné par cette méthode correspond avec le résultat attendu";
		Logger.logMethod(methodeName, message);
		if ("".equals(actual))
		{
			message = "Le résultat retourné par l'appel de la méthode correspond bien avec le résultat attendu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat attendu ne correspond pas avec le résultat obtenu";
			Logger.logError(methodeName, message);
		}
		assertEquals("", actual);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setType(type:String) de la classe Edge qui permet de changer la valeur de l'attribut type.
	 * Pour tester cette méthode on commence par initialiser une variable e de type Edge
	 * Puis on appelle la méthode setType avec le paramètre type = "Test type" qui nous permet de changer le type de l'objet de "" à "Test type"
	 * Puis on teste si le résultat retourné par l'appel de la méthode getType() sur l'objet manipulé retourne bien la valeur "Test type".
	 * */
	@Test
	final void testSetType() {
		final String methodeName = "testSetType()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setType(type:String) de la classe Edge sui permet de changer la valeur de l'attribut type.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une valeur e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La valeur e est bien initialisée";
		Logger.logMethod(methodeName, message);
		String type = "Test type";
		message = "Puis on appelle la méthode setType sur cette variable e avec le paramètre type=" + type + " qui permet de changer la valeur de l'attribut type de \"\" à  \"" + type + "\"";
		Logger.logMethod(methodeName, message);
		e.setType(type);
		message = "La méthode setType est bien appelée";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant le résultat retourné par la méthode getType() sur la variable e manipulé retourne bien le résultat attendu " + type;
		Logger.logMethod(methodeName, message);
		boolean result = type.equals(e.getType());
		if (result)
		{
			message = "Le changement de la valeur de l'attribut type est bien passé";
			Logger.logMethod(methodeName, message);
		}
		else 
		{
			message = "Les valeues ne correspondent pas il y a un problème quelque part";
			Logger.logError(methodeName, message);
		}
		assertEquals(true,result);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getId() de la classe Edge qui permet de retourner la valeur de l'attribut id.
	 * Pour tester cette méthode on commence par initialiser une variable e de type Edge.
	 * Puis on appelle la méthode getId() sur cette variable r
	 * Par défaaut l'attribut id vaut la chaîne de caractères vide
	 * On teste le résultat obtenu par l'appel de la méthode correspond bien avec le résultat attendu la chaîne des caraxtères vide
	 * */
	@Test
	final void testGetId() {
		final String methodeName = "testGetId()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getId de la classe Edge qui permet de retourner la valeur de l'attribut id";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e de type Edge est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "La valeur par défaut de la valeur de l'attribut id d'une objet de type Edge est la chaîne des caractères vide";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode getId() sur la variable e";
		Logger.logMethod(methodeName, message);
		String actual = e.getId();
		message = "La méthode getId() est bien appellé sur la variable e et le résultat obtenu est  \"" + actual + "\"";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si le résultat obtenu par l'appel de la méthode correspond bien avec le résultat attendu";
		Logger.logMethod(methodeName, message);
		if ("".equals(actual))
		{
			message = "Le résultat attendu correspond bien avec le résultat obtenu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les deux résultats ne se correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals("",actual);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setId(id:String) de la classe Edge qui permet de changer la valeur de l'attribut id d'une objet de type Edge.
	 * Pour tester cette méthode on commence par initialiser une variable e de type Edge
	 * Puis on appelle la méthode setId("id") qui est censé de changer la valeur de l'attribut id avec la chaîne des caractères id
	 * On teste si le changement est bien fait avec un appel de la méthode getId() sur la variable e manipulée
	 * */
	@Test
	final void testSetId() {
		final String methodeName = "testSetId()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setId(id:String) de la classe Edge qui permet de changer la valeur de l'attribut id";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e de type Edge est bien été initialisé";
		Logger.logMethod(methodeName, message);
		message = "On appelle maintenant la méthode setId avec le paramètre id=\"id\" qui permet de changer la valeur de l'attribut id à chaîne des caractères id.";
		Logger.logMethod(methodeName, message);
		e.setId("id");
		message = "La méthode setId(\"id\") est bien été appelé sur la variable e";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant si le résultat de l'appel de la méthode getId() sur cette variable e manipulé correspond bien avec la valeur de nouvel attribut id qu'on vient de passer en paramètre";
		Logger.logMethod(methodeName, message);
		if ("id".equals(e.getId()))
		{
			message = "Le changement de la valeur de l'attribut id est bien passé";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Ces deux valeurs ne correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals("id", e.getId());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getFrom() de la classe Edge qui permet de retourner la valeur de l'attribut from
	 * Pour tester cette méthode, on commence par initialiser une variable e de type Edge
	 * La valeur par défaut de l'attribut from est une chaîne de caractères vide
	 * On appelle la méthode getFrom() sur cette variable e
	 * Et on teste si la valeur obtenu par l'appel de cette méthode correspond bien avec le résultat attendu, la chaîne des caractères vide
	 * */	
	@Test
	final void testGetFrom() {
		final String methodeName = "testGetFrom()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getFrom() de la classe Edge qui permet de retourner la valeur de l'attribut from.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e de type Edge est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "La valeur par défaut de l'attribut from est la chaîne des caractères vide";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode getFrom() sur cette variable e";
		Logger.logMethod(methodeName, message);
		String actual = e.getFrom();
		message = "Appel de la méthode getFrom a bien été faite. La valeur retourné par cet appel est \"" + "\"";
		Logger.logMethod(methodeName, message);
		message = "On teste maintenant le résultat attendu correspond bien avec le résultat obtenu";
		Logger.logMethod(methodeName, message);
		if ("".equals(actual))
		{
			message = "Les deux résultats se correspondent";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Ces deux résultats ne correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals("", e.getFrom());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setFrom(from:String) de la classe Edge qui permet de changer la valeur de l'attribut from par la nouvelle valeur passée en paramètres 
	 * Pour tester cette méthode on commence par initialiser une variable e de type Edge.
	 * On appelle la méthode setFrom("from") sur la variable e qui permet de changer la valeur de l'attribut from avec la chaîne des caractères "from"
	 * On contrôle maintenant si le changement de la valeur de l'attribut from est bien passé en testant si la valeur retourné pas l'appel de méthode getFrom() correspond bien avec la nouvelle valeur de l'attribut from qu'on vient de passer en paramètres
	 * */
	@Test
	final void testSetFrom() {
		final String methodeName = "testSetFrom()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setFrom(from:String) de la classe Edge qui permet de changer la valeur de l'attribut from par la nouvelle valeur passée en paramètres";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable e de type Edge.";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e de type Edge a bien été initialisée";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode setFrom(\"from\") sur la variable e qui permet de changer la valeur de l'attribut from avec la chaîne des caractères \"from\"";
		Logger.logMethod(methodeName, message);
		e.setFrom("from");
		message = "L'appel de la méthode setFrom(\"from\") est bien passée";
		Logger.logMethod(methodeName, message);
		message = "On contrôle maintenant si le changement de la valeur de l'attribut from est bien passé en testant si la valeur retourné pas l'appel de méthode getFrom() correspond bien avec la nouvelle valeur de l'attribut from qu'on vient de passer en paramètres";
		Logger.logMethod(methodeName, message);
		String actual = e.getFrom();
		if ("from".equals(actual))
		{
			message = "La nouvelle valeur de l'attribut from correspond bien avec le résultat attendu. Donc le changement est bien passée";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La valeur de la nouvelle attribut from ne correspond pas avec le résultat attendu. Il y a eu un problème lors de la changement de valeur";
			Logger.logError(methodeName, message);
		}
		assertEquals("from", e.getFrom());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getTo() de la classe Edge qui permet de retourner l'attribut to.
	 * Pour tester cette méthode on commence par initialiser une variable e de type Edge
	 * La valeur par défaut de l'attribut to est une chaîne de caractères vide
	 * On appelle la méthode getTo() sur la variable e
	 * On teste si le résultat obtenu correspond bien avec le résultat attendu   
	 */
	@Test
	final void testGetTo() {
		final String methodeName = "testGetTo()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getTo() de la classe Edge qui permet de retourner l'attribut to.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e de type Edge est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "La valeur par défaut de l'attribut to est une chaîne de caractères vide";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode getTo() sur la variable e";
		Logger.logMethod(methodeName, message);
		String actual = e.getTo();
		message = "Le résultat de l'appel est " + actual;
		Logger.logMethod(methodeName, message);
		message = "On teste si le résultat obtenu correspond bien avec le résultat attendu";
		Logger.logMethod(methodeName, message);
		if (actual.equals(""))
		{
			message = "Le résultat attendu correspond bien avec le résultat obtenu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
			Logger.logMethod(methodeName, message);
		}

		assertEquals("", e.getTo());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}


	/*
	 * Cette méthode permet de tester la méthode setTo(to:String) qui permet de changer la valeur de l'attribut to avec la nouvelle valeur passée en paramètres
	 * Pour tester cette méthode, on commence par initialiser une variable e de type Edge
	 * Puis on appelle la méthode setTo("to") sur cette variable r, qui nous permet de changer la valeur de l'attribut to avec la chaîne de caractères "to"
	 * Au final, pour tester si le changement est bien passé, on teste si le résultat de l'appel de la méthode getTo() sur la nouvelle variable e correspond bien avec le résutlat attendu "to" 
	 * */
	@Test
	final void testSetTo() {
		final String methodeName = "testSetTo()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setTo(to:String) qui permet de changer la valeur de l'attribut to avec la nouvelle valeur passée en paramètres";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par initialiser une variable e de type Edge";
		Logger.logMethod(methodeName, message);
		Edge e = new Edge();
		message = "La variable e de type Edge est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode setTo(\"to\") sur cette variable r, qui nous permet de changer la valeur de l'attribut to avec la chaîne de caractères \"to\"";
		Logger.logMethod(methodeName, message);
		e.setTo("to");
		message = "L'appel de la méthode setTo(\"to\") est bien passé";
		Logger.logMethod(methodeName, message);
		message = "Au final, pour tester si le changement est bien passé, on teste si le résultat de l'appel de la méthode getTo() sur la nouvelle variable e correspond bien avec le résutlat attendu \"to\"";
		Logger.logMethod(methodeName, message);
		if ("to".equals(e.getTo()))
		{
			message = "Le résultat obtenu correspond bien avec le résultat attendu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
			Logger.logError(methodeName, message);
		}
		assertEquals("to", e.getTo());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}
}
