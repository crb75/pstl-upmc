package com.puck.nodes.piccolo2d.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.puck.nodes.piccolo2d.Edge;
import com.puck.nodes.piccolo2d.Node;
import com.puck.utilities.Logger;

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

	/*
	 * Cette méthode permet de tester le constructeur de la classe Node.
	 * Pour tester cette méthode on initialise une variable n de type Node avec l'appel de constructeur.
	 * Puis on teste si cette variable est non null.
	 * */
	@Test
	final void testNode() {
		final String methodeName = "testNode()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester le constructeur de la classe Node.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on initialise une variable n de type Node avec l'appel de constructeur.";
		Logger.logMethod(methodeName, message);
		Node n;
		n = new Node();
		message = "La variable n de type Node est bien initialisé avec l'appel du constructeur Node()";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on initialise une variable n de type Node avec l'appel de constructeur.";
		Logger.logMethod(methodeName, message);
		if (n != null)
		{
			message = "La variable n est non-null";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La variable n est null il y a un problème";
			Logger.logError(methodeName, message);
		}
		assertNotNull(n);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getName() de la classe Node qui permet d'obtenir la valeur de l'attribut name
	 * Pour tester cette méthode on initialise d'abord une variable n de type Node.
	 * La valeur par défaut de l'attribut name est null
	 * On appelle la méthode getName() sur la variable n
	 * On teste le résultat de l'appel avec le résultat attendu null
	 * */
	@Test
	final void testGetName() {
		final String methodeName = "testGetName()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getName() de la classe Node qui permet d'obtenir la valeur de l'attribut name";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on initialise d'abord une variable n de type Node.";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "La valeur par défaut de l'attribut name est null";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode getName() sur la variable n";
		Logger.logMethod(methodeName, message);
		String name = n.getName();
		message = "L'appel de la méthode getName() est bien passée le résultat obtenu est \""+name+"\"";
		Logger.logMethod(methodeName, message);
		message = "On teste le résultat de l'appel avec le résultat attendu null";
		Logger.logMethod(methodeName, message);
		if (name == null)
		{
			message = "Le résultat de la méthode correspond bien avec le résultat attendu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat de la méthde ne correspond pas avec le résultat attendu";
			Logger.logError(methodeName, message);
		}
		assertEquals(null,name);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setName(name:String) de la classe Node qui pemet de changer la valeur de l'attribut name.
	 * Pour tester cette méthode on commence par créer une variable n de type Node
	 * Puis on appelle la méthode setName sur cette variable avec le paramètre name="Test" qui permet de changer la valeur de l'attribut name de la variable par la chaîne des caractères "Test"
	 * Puis on teste si la nouvelle valeur de l'attribut name correspond bien avec la valeur désirée.
	 * Pour cela on appelle la méthode getName() sur la variable n
	 * Et on teste si cette valeur obtenue correspond avec la valeur désirée qu'on a passeé en paramètres de la méthode setName 
	 * */
	@Test
	final void testSetName() {
		final String methodeName = "testSetName()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setName(name:String) de la classe Node qui pemet de changer la valeur de l'attribut name.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par créer une variable n de type Node";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n de type Node est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode setName sur cette variable avec le paramètre name=\"Test\" qui permet de changer la valeur de l'attribut name de la variable par la chaîne des caractères \"Test\"";
		Logger.logMethod(methodeName, message);
		n.setName("Test");
		message = "L'appel de la méthode setName(\"Test\") est bien passé";
		Logger.logMethod(methodeName, message);
		message = "Puis on teste si la nouvelle valeur de l'attribut name correspond bien avec la valeur désirée.";
		Logger.logMethod(methodeName, message);
		message = "Pour cela on appelle la méthode getName() sur la variable n";
		Logger.logMethod(methodeName, message);
		String name = n.getName();
		message = "L'appel de la méthode getName() est bien passé, la valeur retournée par cette méthode est " + name;
		Logger.logMethod(methodeName, message);
		message = "Et on teste si cette valeur obtenue correspond avec la valeur désirée qu'on a passeé en paramètres de la méthode setName";
		Logger.logMethod(methodeName, message);
		if (name.equals("Test"))
		{
			message = "Les deux valeurs se correspondent";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les deux valeurs ne se correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals("Test",name);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getId de la classe Node qui permet de retourner la valeurd de l'attribut Id.
	 * Pour tester cette méthode on commence par initialiser une variable n de type Node.
	 * La valeur par défaut de l'attribut id est null.
	 * On appelle la méthode getId() sur la variable n.
	 * On teste si le résultat de cette appelle correspond bien avec la valeur par défaut
	 * */
	@Test
	final void testGetId() {
		final String methodeName = "testGetId()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getId de la classe Node qui permet de retourner la valeurd de l'attribut Id.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable n de type Node.";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "La valeur par défaut de l'attribut id est null.";
		Logger.logMethod(methodeName, message);
		message = "On appelle la méthode getId() sur la variable n.";
		Logger.logMethod(methodeName, message);
		String id = n.getId();
		message = "L'appel de la méthode retournée " + id;
		Logger.logMethod(methodeName, message);
		message = "On teste si le résultat de cette appelle correspond bien avec la valeur par défaut";
		Logger.logMethod(methodeName, message);
		if (id == null)
		{
			message = "Le résulat obtenu correspond bien avec le résultat attendu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Le résultat attendu ne correspond pas avec le résultat obtenu";
			Logger.logError(methodeName, message);
		}
		assertEquals(null, id);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}


	/*
	 * Cette méthode permet de tester la méthode setId(id:String) de la classe Node qui permet de changer la valeur de l'attribut id
	 * Pour tester cette méthode on commence par initialiser une variable n de type Node.
	 * Puis on appelle la méthode setId("1") qui permet de changer la valeur de l'attribut id avec la chaîne de caractères "1".
	 * Pour tester si tout est bien passé, on appelle la méthode getId() et on teste si la valeur obtenu correspond bien avec le résultat attendu.
	 */
	@Test
	final void testSetId() {
		final String methodeName = "testSetId()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setId(id:String) de la classe Node qui permet de changer la valeur de l'attribut id";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable n de type Node.";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n de type Node est bien initialisé";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode setId(\"1\") qui permet de changer la valeur de l'attribut id avec la chaîne de caractères \"1\".";
		Logger.logMethod(methodeName, message);
		n.setId("1");
		message = "La méthode setId est bien appelé avec le paramètre \"1\"";
		Logger.logMethod(methodeName, message);
		message = "Pour tester si tout est bien passé, on appelle la méthode getId() et on teste si la valeur obtenu correspond bien avec le résultat attendu.";
		Logger.logMethod(methodeName, message);
		if ("1".equals(n.getId()))
		{
			message = "Les deux résultats se correspondent. Le changement de la valeur de l'attribut id est bien passé";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les deux resultats ne se correspondent pas le changement de la valeur de l'attribut n'est pas bien pasé";
			Logger.logError(methodeName, message);
		}
		assertEquals("1", n.getId());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getType() de la classe Node qui permet de retourner la valeur de l'attribiut type.
	 * Pour tester cette méthode on commence par initialiser une variable n de type Node
	 * La valeur par défaut de l'attribut type est null.
	 * On appelle en suite la méthide getType() sur la variable n
	 * On teste si le résultat obtenu de cet appel correspond bien avec la chaîne de caractères vide.
	 * */
	@Test
	final void testGetType() {
		final String methodeName = "testGetType()";
		String message;
		
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getType() de la classe Node qui permet de retourner la valeur de l'attribiut type.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable n de type Node";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n de type Node est bien initialisé";
		Logger.logMethod(methodeName, message);
		message = "La valeur par défaut de l'attribut type est null.";
		Logger.logMethod(methodeName, message);
		message = "On appelle en suite la méthide getType() sur la variable n";
		Logger.logMethod(methodeName, message);
		String type = n.getType();
		message = "Appel de la fonction getType() est bien passé et retourné \"" + type + "\"";
		Logger.logMethod(methodeName, message);
		message = "On teste si le résultat obtenu de cet appel correspond bien avec null.";
		Logger.logMethod(methodeName, message);
		if (type == null)
		{
			message = "Les deux résultats se correspondent";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les deux résultats ne se correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals(null,n.getType());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setType(type:String) de la classe Node qui permet de changer la valeur de l'attribut type
	 * Pour tester cette méthode on initialise d'abord une variable n de type Node
	 * Puis on appelle la méthode setType("Test type") qui est censé de changer la valeur de l'attribut type à "Test type".
	 * Pour tester si le changement est bien passé, on appelle la méthode getType() sur la variable n et on teste si le résultat obtenu de cet appel correspond bien avec la nouvelle valeur de l'attribut type passé en paramètres lors de l'appel de la méthode setType sur la variable r 
	 * */
	@Test
	final void testSetType() {
		final String methodeName = "testSetType()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setType(type:String) de la classe Node qui permet de changer la valeur de l'attribut type";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on initialise d'abord une variable n de type Node";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n de type Node est bien initialisé";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode setType(\"Test type\") qui est censé de changer la valeur de l'attribut type à \"Test type\".";
		Logger.logMethod(methodeName, message);
		n.setType("Test type");
		message = "Appel de la méthode setType avec le paramètre \"Test type\" est bien passé";
		Logger.logMethod(methodeName, message);
		message = "Pour tester si le changement est bien passé, on appelle la méthode getType() sur la variable n et on teste si le résultat obtenu de cet appel correspond bien avec la nouvelle valeur de l'attribut type passé en paramètres lors de l'appel de la méthode setType sur la variable r";
		Logger.logMethod(methodeName, message);
		String type = n.getType();
		if ("Test type".equals(type))
		{
			message = "Le changement de la valeur de l'attribut type est bien passé";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Il y a eu un problème lors de la changement de la valeur de l'attribut type";
			Logger.logError(methodeName, message);
		}
		assertEquals("Test type",type);
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode getRelation() de la classe Node qui permet d'obtenir la table d'hachage des relations d'un objet de type Node.
	 * Pour tester cette méthode on commence par initialiser une variable n de type Node.
	 * Puis on appelle la méthode getRelations sur cette variable n.
	 * Par défaut, la liste des relations est une liste vide donc la taille de la liste des relations doit être 0.
	 * On teste si c'est bien le cas
	 * */
	@Test
	final void testGetRelation() {
		final String methodeName = "testGetRelations()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode getRelation() de la classe Node qui permet d'obtenir la liste des relations d'un objet de type Node.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode on commence par initialiser une variable n de type Node.";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n de type Node est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "Puis on appelle la méthode getRelations sur cette variable n.";
		Logger.logMethod(methodeName, message);
		HashMap<String,Edge> relations = n.getRelation();
		if (relations != null)
		{
			message = "La méthode getRelations est bien appelé sur la variable n. La taille de la table d'hachage obtenu est " + relations.size();
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "La table d'hachage des relations n'est pas défini. L'appel de la méthode retourné null";
			Logger.logError(methodeName, message);
		}
		message = "Par défaut, la liste des relations est une liste vide donc la taille de la liste des relations doit être 0.";
		Logger.logMethod(methodeName, message);
		message = "On teste si c'est bien le cas";
		Logger.logMethod(methodeName, message);
		if ((relations != null) && (relations.size() == 0))
		{
			message = "La table d'hachage des relations est bien défini est la taille de la table est 0";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Il doit avoir un problèeme quelque part.";
			Logger.logError(methodeName, message);
		}
		assertEquals(0, n.getRelation().size());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/*
	 * Cette méthode permet de tester la méthode setRelations(relations:HashMap<String,Edge>) de la classe Node, qui permet de changer la valeur de l'attribut relations. Autrement dit de redéfinir la table d'hachage des relations d'un objet de type Node.
	 * Pour tester cette méthode, on commence par créer une table d'hachage vide.
	 * Puis on y ajoute un nouveau objet de type Edge dont on le crée à la volée avec l'étuquiette "Test"
	 * Et puis on initialise une variable n de type Node.
	 * Et on appelle la méthode setRelations sur la variable n avec la table d'hachage qu'on vient d'initialiser.
	 * Pour tester tout est bien passé, on teste l'égalité entre la table d'hachage obtenu par la méthode getRelations() et la table d'hachage local qu'on a créé tout au début.
	 * */
	@Test
	final void testSetRelation() {
		final String methodeName = "testSetRelation()";
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de tester la méthode setRelations(relations:HashMap<String,Edge>) de la classe Node, qui permet de changer la valeur de l'attribut relations. Autrement dit de redéfinir la table d'hachage des relations d'un objet de type Node.";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on commence par créer une table d'hachage vide.";
		Logger.logMethod(methodeName, message);
		HashMap<String, Edge> re = new HashMap<>();
		message = "La table d'hachage est bien initilisé";
		Logger.logMethod(methodeName, message);
		message = "Puis on y ajoute un nouveau objet de type Edge dont on le crée à la volée avec l'étuquiette \"Test\"";
		Logger.logMethod(methodeName, message);
		re.put("Test", new Edge());
		message = "Une variable de type Edge est bien ajouté à la table d'hachage avec l'étiquette \"Test\"";
		Logger.logMethod(methodeName, message);
		message = "Et puis on initialise une variable n de type Node.";
		Logger.logMethod(methodeName, message);
		Node n = new Node();
		message = "La variable n de type Node est bien initialisé";
		Logger.logMethod(methodeName, message);
		message = "Et on appelle la méthode setRelations sur la variable n avec la table d'hachage qu'on vient d'initialiser.";
		Logger.logMethod(methodeName, message);
		n.setRelation(re);
		message = "La méthode setRelation est bien appelé sur la variable n avec la table d'hachage qu'on avait créé au début de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Pour tester tout est bien passé, on teste l'égalité entre la table d'hachage obtenu par la méthode getRelations() et la table d'hachage local qu'on a créé tout au début.";
		Logger.logMethod(methodeName, message);
		if (n.getRelation().equals(re))
		{
			message = "Le changement de la table des relations est bien passée. La nouvelle table des relations correspond bien avec celle qui est passée en paramètres de la méthode setRelation";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Il y a un problème avec le changement de la table des relations. La nouvelle table des relations ne correspond pas avec la table qu'on a passée en paramètres";
			Logger.logError(methodeName, message);
		}
		assertEquals(re, n.getRelation());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

}
