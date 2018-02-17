/**
 * 
 */
package reader.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;
import utilities.Logger;
/**
 * @author ky
 *
 */
class ReaderTest {

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
	 * Test method for {@link reader.xml.Reader#Reader(java.lang.String)}.
	 * Cette méthode de teste permet de tester le contructeur de la classe Reader.
	 */
	@Test
	final void testReader() {
		String methodeName = "testReader()";
		Logger.logMethod(methodeName, "Début de l'appel de la méthode");
		Logger.logMethod(methodeName, "Cette méthode permet de tester le contructeur de la classe Reader");
		Logger.logMethod(methodeName, "On va initialiser une variable r de type Reader par l'appel de ce constructeur sur le fichier mongraph.xml");
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(methodeName, "La variable r est bien initialisé");
		if (r != null)
		{
			Logger.logMethod(methodeName, "La variable r n'est pas null");
		}
		else
		{
			Logger.logError(methodeName, "La variable r est null il y a certainement un problème avec le constructeur.");
		}
		assertNotNull(r);
		Logger.logMethod(methodeName, "Fin d'appel de la méthode");
	}

	/**
	 * Test method for {@link reader.xml.Reader#executeBooleanQuery(java.lang.String)}.
	 * Cette méthode de teste permet de tester la méthode executeBooleanQuery(query:String) de la classe Reader.
	 * Cette méthode permet de exécuter une requête XPath sur le fichier XML dont le type de retour de cette requête est un booléen
	 */
	@Test
	final void testExecuteBooleanQuery() {
		String mName = "testExecuteBooleanQuery()";
		Logger.logMethod(mName, "Debut de l'appel de la méthode");
		Logger.logMethod(mName, "Cette méthode permet de tester ma méthode executeBooleanQuery(query:String) de la classe Reader");
		Logger.logMethod(mName, "La méthode executeBooleanQuery(query:String) permet d'exécuter une requête XPath dont le type de retour est une booléenne sur le fichier XML");
		Logger.logMethod(mName, "On commence par initialiser une variable r de type Reader pour pouvoir tester la méthode");
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(mName, "La variable r de type Reader est initialisé");
		String requete = "//node[2]";
		Logger.logMethod(mName,"On va appeler la fonction avec la requête \""+requete+"\"");
		Logger.logMethod(mName, "La réponse attendue est true");
		boolean resultat = r.executeBooleanQuery(requete);
		if (resultat) 
		{
			Logger.logMethod(mName,"On a eu le résultat attendu");
		}
		else
		{
			Logger.logError(mName,"La réponse obtenue n'est pas la réponse attendue");
		}
		assertEquals(true,resultat);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getAllNodes()}.
	 * Cette méthode permet de tester la méthode getAllNodes() de la classe Reader.
	 * La méthode getAllNodes() est une méthode qui retourne tous les nodes sous forme d'une liste des nodes.
	 * Pour tester la méthode on va initialiser d'abord une variable r de type Reader
	 * puis on va appeler la méthode getAllNodes() sur la variable et on va tester si le résultat n'est pas null
	 * et au final on va tester si la collection des éléments de type node a la bonne taille
	 */
	@Test
	final void testGetAllNodes() {
		String mName = "testGetAllNodes()";
		Logger.logMethod(mName, "Début de l'appel de la méthode testGetAllNodes()");
		Logger.logMethod(mName, "Cette méthode permet de tester la méthode getAllNodes() qui permet d'obtenir la liste des éléments de type node depuis le fichier XML de la classe Reader.");
		Logger.logMethod(mName, "On va commencer par initialiser une variable de type Reader");
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(mName, "La variable r est bien créé");
		Logger.logMethod(mName, "On va appeler la méthode getAllNodes() sur la variable r qu'on vient de créer");
		NodeList nl = r.getAllNodes();
		Logger.logMethod(mName, "La méthode getAllNodes() est appelée sur la variable r de type Reader. Et le résultat de cet appel est initialisé dans une variable de type NodeList.");
		if (nl!=null)
		{
			Logger.logMethod(mName, "Le résultat de la méthode getAllNodes() n'est pas null");
		}
		else
		{
			Logger.logError(mName, " Le résultat de la méthode getAllNodes() est null.");
		}
		assertNotNull(nl);
		Logger.logMethod(mName, "On va maintenant tester si la taille du résultat correspond la taille attendue.");
		int sizeAttendu = 18;
		Logger.logMethod(mName,"La taille attendue est " + sizeAttendu);
		Logger.logMethod(mName,"La taille de la liste des noeuds est " + nl.getLength());
		Logger.logMethod(mName,"On va tester si les deux tailles sont les mêmes.");
		if (sizeAttendu == nl.getLength())
		{
			Logger.logMethod(mName,"La taille attendu et la taille de la collection retourné par la méthode getAllNodes sont la même");
		}
		else
		{
			Logger.logError(mName,"Les tailles ne sont pas le même");
		}
		assertEquals(sizeAttendu,nl.getLength());	
		Logger.logMethod(mName, "Fin d'appel");
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNbNodes()}.
	 * La méthode testGetNbNodes() permet de tester la méthode getNbNodes() de la classe Reader.
	 * La méthode getNbNodes() permet de retourner le nombre des éléments nodes stocké dans le document xml.
	 * Pour tester, on va d'abord créer une varible de type reader et puis on tester si le nombre retourné par la méthode convient avec le nimbre réel des éléments node de la document.
	 */
	@Test
	final void testGetNbNodes() {
		String methodeName = "testGetNbNodes()";
		int sizeAttendu = 18;
		Logger.logMethod(methodeName, "Début de l'appel de la méthode");
		Logger.logMethod(methodeName, "Cette méthode permet de tester la méthode getNbNodes() de la classe Reader qui permet d'obtenir le nombre d'éléments de type node depuis le fichier xml");
		Logger.logMethod(methodeName, "Pour tester cette méthode, on va d'abord créer une variable r de type Reader, et on va appeler la méthode getNbNodes() sur cette variable.");
		Logger.logMethod(methodeName, "Puis on va contrôler si le résultat de cet appel correspond au résultat attendu qui est " + sizeAttendu);
		Logger.logMethod(methodeName, "On commence par initialiser une variable r de type Reader");
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(methodeName, "La variable r de type Reader est bien créé");
		Logger.logMethod(methodeName, "Le nombre des éléments nodes retournés par cette méthode est " + r.getNbNodes());
		assertEquals(sizeAttendu,r.getNbNodes() );
		if (sizeAttendu == r.getNbNodes())
		{
			Logger.logMethod(methodeName, "Le résultat de cet appel correspond bien au résultat attendu");
		}
		else
		{
			Logger.logError(methodeName, "Les deux résultats ne correspondent pas");
		}
		Logger.logMethod(methodeName, "Fin d'appel de la méthode");
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNode(int)}.
	 * La méthode testGetNode() permet de tester la méthode getNode(index:integer) de la classe Reader.
	 * Cette méthode permet de retourner l'élement node du document xml sous forme d'une classe Node.
	 * Pour tester on va appeler la méthode getNode par l'index 1 pour retourner le premier élément Node.
	 * On va tester si le résultat de cet appel est non null.
	 */
	@Test
	final void testGetNode() {
		String methodeName = "testGetNode()";
		Logger.logMethod(methodeName, "Début de l'appel de la méthode");
		Logger.logMethod(methodeName, "Cette méthode permet de tester la méthide getNode(index:integer) de la classe Reader qui permet de retourner l'élément de type node dont l'index sur le fichier xml est passé en paramètre en tant qu'une objet java de type Node");
		Logger.logMethod(methodeName,"On commence par initialiser une variable r de type Reader");
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(methodeName, "La variable r est bien initialisée");
		Logger.logMethod(methodeName, "On va maintenant appeler la méthide getNode avec le paramètre 1. Ceci va nous permettre d'avoir le premier élément de type node présent sur le fichier XML");
		if (r.getNode(1) == null)
		{
			Logger.logError(methodeName, "La méthode est retournée null. Il y un problème!");
		}
		else
		{
			Logger.logMethod(methodeName, "Le résultat de cet appel n'est pas null");
		}
		assertNotNull(r.getNode(1));
		Logger.logMethod(methodeName, "Fin d'appel");
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNodeType(int)}.
	 * La méthode testGetNodeType() permet de tester la méthode getNodeType(index:integer) de la classe Reader.
	 * Cette méthode permet de retourner le type d'une élément node dont l'index est passé en paramètres.
	 */
	@Test
	final void testGetNodeType() {
		String methodeName = "testGetNodeType()";
		Logger.logMethod(methodeName, "Debut de l'appel");
		Logger.logMethod(methodeName, "Cette méthode permet de tester la méthode getNodeType(index:integer) qui permet d'obtenir l'attribut type d'un élémént node dont l'index est passé en paramètre depuis le fichier xml");
		Logger.logMethod(methodeName, "On commence par initialiser une variable r de type Reader à partir du fichier XML mongraph.xml")
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(methodeName, "La variable r bien initialisée");
		String typeAttendu = "package";
		Logger.logMethod(methodeName, "Le résultat attendu est " + typeAttendu);
		Logger.logMethod(methodeName, "On contrôle si les deux résultats correspondent bien");
		if (typeAttendu.equals(r.getNodeType(1)))
		{
			Logger.logMethod(methodeName, "Le type du premier élémnent de type node correspond bien le type retourné par l'appel de la méthode");
		}
		else
		{
			Logger.logError(methodeName, "Les deux résultats ne correspondent pas");
		}
		assertEquals("package", r.getNodeType(1));
		Logger.logMethod(methodeName, "Fin d'appel de la méthode");
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNodeId(int)}.
	 * La méthode testGetNodeId() permet de tester la méthode getNodeId(index:int) de la classe Reader.
	 * Pour tester cette méthode on commence par initialiser une variable r de type Reader par le fichier xml
	 * Et puis on va tester si l'id retourné par la méthode convient bien l'id attendu 
	 */
	@Test
	final void testGetNodeId() {
		final String methodeName = "testGetNodeId()";
		String message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de test la méthode getNodeId(index:integer) sur la classe Reader qui permet de retourner l'attribut id de l'élément de type node dont l'index dans le fichier xml est passé en paramètres";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on initialise d'abord une variable r de type Reader. Puis on appel la méthode getNodeId avec le paramètre index=1. Ce qui nous permet de retourne l'attribut id du premier élément de type node. A la fin on teste si le résultat de cet appel corresponde bien au résultat attendu";
		Logger.logMethod(methodeName, message);
		String idAttendu = "p04";
		message = "Le résultat attendu est " + idAttendu;
		Logger.logMethod(methodeName, message);
		message = "On commence par initialiser la variable r de type Reader";
		Logger.logMethod(methodeName, message);
		Reader r = new Reader("./mongraph.xml");
		message = "La variable r est bien initialisé";
		Logger.logMethod(methodeName, message);
		message = "On test maintenant si les deux résulats se correspondent";
		Logger.logMethod(methodeName, message);
		if (idAttendu.equals(r.getNodeId(1)))
		{
			message = "L'id retourné par la méthode correspond bien au résultat attendu";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les deux résultats ne correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals(idAttendu, r.getNodeId(1));
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNodeName(int)}.
	 * La méthode testGetNodeName() permet de tester la méthode getNodeName(index:integer) de la classe Reader
	 * Cette méthode retourne l'attribut name de l'élément node depuis le fichier xml dont l'index est passé en paramiètres
	 * Pour tester cette méthode on suit le démarche suivant:
	 * =	 On crée une variable r de type Reader.
	 * - On appelle la méthode getNodeName avec index=1.
	 * - Le resultat attendu est "unPackageParent"
	 * - On contrôle si le résultat de l'appel de la méthode sur la variable r est égale au résultat attendu
	 */
	@Test
	final void testGetNodeName() {
		final String methodeName = "testGetNodeName()";
		Logger.logMethod(methodeName,"Début de l'appel de la méthode testGetNodeName()");
		Logger.logMethod(methodeName,"Cette méthode permet de tester la méthode getNodeName(index:integer) de la classe Reader");
		Logger.logMethod(methodeName,"Cette méthode permet d'avoir l'attribut name de l'élément node depuis le fichier xml dont l'index est passé aux paramètres.");
		Logger.logMethod(methodeName,"Pour tester cette méthode on crée d'abord une variable r de type Reader");
		Reader r = new Reader("./mongraph.xml");
		Logger.logMethod(methodeName,"La variable r est créé avec succès");
		Logger.logMethod(methodeName,"On teste en suite si l'appel de la fonction retourne bien le résultat attendu qui est \"unPackageParent\"");
		if (r.getNode(1).equals("unPackageParent"))
		{
			Logger.logMethod(methodeName,"Le résultat de la méthode est bien égale au résultat attendu");
		}
		else
		{
			Logger.logError(methodeName,"Il y a un problème avec cette méthode. Les résultats ne correspondent pas");
		}
		assertEquals("unPackageParent", r.getNodeName(1));
		Logger.logMethod(methodeName, "Fin de l'appel de la méthode");
	}

	/**
	 * Test method for {@link reader.xml.Reader#getAllEdges()}.
	 * Cette méthode permet de tester la méthode getAllEdges de la classe Reader qui permet de retourne la liste des éléments de type Edge depuis le fichier XML.
	 * Pour tester cette méthode on initialise d'abord un élément r de type Reader.
	 * Puis on appelle la méthode getAllEdges() sur cette variable r
	 * On contrôle d'abord le résultat de cet appel est non null
	 * Puis on teste le nombe d'éléments de la colleciton retournée par cet appel correspond bien à notre résultat attendu.
	 */
	@Test
	final void testGetAllEdges() {
		final String methodeName = "testGetAllEdges()';
		String message;
		message = "Début de l'appel de la méthode";
		Logger.logMethod(methodeName, message);
		message = "Cette méthode permet de test la méthode getAllEdges de la classe Reader qui permet de retourner tous les éléments de type edge depuis le fichier XML";
		Logger.logMethod(methodeName, message);
		message = "Pour tester cette méthode, on créé d'abord une variable r de type Reader. Puis on appel la méthode getAllEdges() sur cette variable. Puis on teste si le résultat retourné par cet appel est non-null. Puis on teste si la taille du réultat de cet appel correspond bien à la taille attendu";
		Logger.logMethod(methodeName, message);
		message = "On commence par initialiser une variable r de type Reader";
		Logger.logMethod(methodeName, message);
		Reader r = new Reader("./mongraph.xml");
		message = "La variable r est bien initialisée";
		Logger.logMethod(methodeName, message);
		message = "On appelle maintenant la méthode getAllEdges sur cette variable r";
		Logger.logMethod(methodeName, message);
		NodeList nl = r.getAllEdges();
		message = "On a créé une variable nl de type NodeList avec le résultat de l'appel de la méthode getAllEdges() sir la variable r";
		Logger.logMethod(methodeName, message);
		message = "On teste si la variable nl est non-null";
		Logger.logMethod(methodeName, message);
		if (nl == null)
		{
			message = "La variable nl est null! Il y a un problème";
			Logger.logError(methodeName, message);
		}
		else
		{
			message = "La variable nl est non null";
			Logger.logMethod(methodeName, message);
		}
		assertNotNull(nl);
		int resultatAttendu = 22;
		message = "On teste maintenant si la taille de la variable nl correspond bien à la taille attendu qui est " + resultatAttendu;
		Logger.logMethod(methodeName, message);
		if (nl.getLength() == resultatAttendu)
		{
			message = "Les tailles correspondent bien comme il faut";
			Logger.logMethod(methodeName, message);
		}
		else
		{
			message = "Les deux tailles ne correspondent pas";
			Logger.logError(methodeName, message);
		}
		assertEquals(22,nl.getLength());
		message = "Fin d'appel de la méthode";
		Logger.logMethod(methodeName, message);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNbEdges()}.
	 */
	@Test
	final void testGetNbEdges() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals(18, r.getNbNodes());
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdge(int)}.
	 */
	@Test
	final void testGetEdge() {
		Reader r = new Reader("./mongraph.xml");
		assertNotNull(r.getEdge(1));
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeId(int)}.
	 */
	@Test
	final void testGetEdgeId() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "e01";
	     String actual = r.getEdgeId(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeType(int)}.
	 */
	@Test
	final void testGetEdgeType() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "uses";
	     String actual = r.getEdgeType(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeSource(int)}.
	 */
	@Test
	final void testGetEdgeSource() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "c01";
	     String actual = r.getEdgeSource(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeDestination(int)}.
	 */
	@Test
	final void testGetEdgeDestination() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "c02";
	     String actual = r.getEdgeDestination(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeFrom(java.lang.String)}.
	 */
	@Test
	final void testGetEdgeFrom() {
		Reader r = new Reader("./mongraph.xml");
		assertNotNull(r.getEdgeFrom("c01"));
	}

}
