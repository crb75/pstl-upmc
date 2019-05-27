package tests.controleur.reader;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import puck.controleur.reader.Reader;

public class TestReader {
	
	private Reader r;

	
	@Before
	public void beforeTests() {
		r = new Reader("./test_assets/mongraph.xml");
	}
	
	@After
	public void afterTests() {
		r = null;
	}

	
	/**
	 * Cette methode permet d'executer une requête XPath dont le type de retour est String sur le fichier XML. On commence par creer notre requête a executer.
	 * La requête qu'on va executer est //node[1]/@id qui permet d'obtenir id du premier element 'node'.
	 * On exécute la requête.
	 * La requête est bien exécutée, on stocke le résultat de cette exécution dans une variable res de type String.
	 * Le résultat attendu est resa : "1"
	 * res et resa sont égaux.
	 * 
	 */
	@Test
	public void test1ExecuteStringQueryPositif() {
		String resa = "1";
		String req = "//node[1]/@id";
	    String res = r.executeStringQuery(req);
	    assertEquals(resa,res);
	}
	
	
	@Test
	public void test2ExecuteStringQueryPositif() {
		String resa = "3";
		String req = "//node[2]/@id";
	    String res = r.executeStringQuery(req);
	    assertEquals(resa,res);
	}
	
	
	
	/**
	 * Cette methode permet d'executer une requête XPath dont le type de retour est booleen sur le fichier XML.
	 * On commence par initialiser la requête qu'on va executer.
	 * La requête qu'on va executer est //edge[1]/@id = 0 qui permet de tester si l'identifiant du premier d'element de type edge est égal a 0.
	 * La requête est bien executé sur le fichier xml. On a stocké le resultat de retour dans une variable res de type Boolean
	 * Le résultat attendu est resa : true
	 *   res et resa ne sont égaux.
	 */
	@Test
    public void test1ExecuteBooleanQueryPositif() {
        Boolean resa = true;
        String req = "//edge[1]/@id = 0";
        Boolean res = r.executeBooleanQuery(req);
        assertEquals(res,resa);
    }
	
	
	/**
	 * Cette methode permet d'executer une requête XPath dont le type de retour est booleen sur le fichier XML.
	 * On commence par initialiser la requête qu'on va executer.
	 * La requête qu'on va executer est //edge[1]/@id = 197 qui permet de tester si l'iddu premier d'element de type edge est égal a 197.
	 * La requête est bien executé sur le fichier xml. On a stocké le resultat de retour dans une variable res de type Boolean
	 * Le résultat attendu est resa : false
	 *   res et resa ne sont pas égaux.
	 */
	@Test
    public void test2ExecuteBooleanQueryPositif() {
        Boolean resa = false;
        String req = "//edge[1]/@id = 197";
        Boolean res = r.executeBooleanQuery(req);
        assertEquals(res,resa);
    }
	
	
	/**
	 * La methode permet d'executer une requÃªte dont le type de retour est Node sur le fichier XML.
	 * On commence par initialiser la requÃªte que nous allons executer.
	 * La requÃªte est bien initialise avec //node[1]  qui permet de selectionner le premier element de type Node.
	 * On execute maintenant cette requête.
	 * La requête est bien executée et le resultat de cette execution est stocké dans une variable res de type Node
	 * On va maintenant contrôler si le node obtenu est bien le node attendu.
	 * On commence par contrôler si la variable res est non null.
	 * On continue par tester si le nom de Node obtenu est bien le nom qu'on attend qui est 'Main'.
	 * On teste ensuite ses attributs.
	 * on commence par tester si la variable res a bien 3 attributs.
	 * On teste si l'id est egal à 1.
	 * On passe maintenant a verifier si la valeur de l'attribut name est bien la valeur attendu 'Main
	 * On teste si le type qui doit être égal à class.
	 */
	@Test
	 public void testExecuteNodeQuery() {
	        String req = "//node[1]";
	        Node res = r.executeNodeQuery(req);
	        String nA = "Main",
	                tA = "class",
	                iA = "1",
	                nnA = "node";
	        int lA = 3;
	        
	        //null test
	        assertNotNull(res);
	        
	        //element node test
	        assertEquals(res.getNodeName(),nnA);

	        //attribute length
	        assertEquals(lA,res.getAttributes().getLength());
	      
	        //id test
	        assertEquals(res.getAttributes().getNamedItem("id").getNodeValue(),iA);
	        
	        // valeur test
	        assertEquals(res.getAttributes().getNamedItem("name").getNodeValue(), nA);

	        //type test
	        assertEquals(tA,res.getAttributes().getNamedItem("type").getNodeValue());
	    }
	
	/**
	 * Cette methode permet d'executer une requête XPath dont la valeur de retour est de type NodeList qui est une liste des nodes.
	 * On commence par initialiser la requête qu'on va executer.
	 * La requÃªte est initialisee avec //node qui permet de selectionner tous les elements de type node.
	 * On exécute la requête.
	 * On teste maintenant si le resultat obtenu correspond bien avec le resultat attendu.
	 * Pour chaque noeud de la liste, on vérifie s'il n'y a que des noeuds, le nombre des attributs est égal à 3,
	 *  les ids, names et types correspondent
	 */
	@Test
	 public void testExecuteNodeSetQuery() {
	        String req = "//node";
	        NodeList res = r.executeNodeSetQuery(req);
	        int tA = 8; //taille attendu 

	        assertEquals(tA,res.getLength());
	        
	        ArrayList<String> types = new ArrayList<>();
	        ArrayList<String> ids = new ArrayList<>();
	        ArrayList<String> names = new ArrayList<>();
	        types.add("class");
	        types.add("methodbody");
	        types.add("package");
	        types.add("method");
	        types.add("class");
	        types.add("package");
	        types.add("package");
	        types.add("class");
	        ids.add("1");
	        ids.add("3");
	        ids.add("7");
	        ids.add("2");
	        ids.add("4");
	        ids.add("0");
	        ids.add("5");
	        ids.add("6");
	        names.add("Main");
	        names.add("main");
	        names.add("lang");
	        names.add("main");
	        names.add("void");
	        names.add("test");
	        names.add("@primitive");
	        names.add("String");

	        for (int i = 0; i < res.getLength(); i++) {
	            Node n = res.item(i);
	            assertEquals(n.getNodeName(),"node");
	            assertEquals(n.getAttributes().getLength(),3);
	            assertEquals(n.getAttributes().getNamedItem("name").getNodeValue(),names.get(i));
	            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
	            assertEquals(types.get(i),n.getAttributes().getNamedItem("type").getNodeValue());
	        }
	    }
	
	
	/**
	 * La methode permet d'obtenir tous les element de type node
	 * Pour tester cette methode, on appelle la methode sur la variable r 
	 * et on stocke le resultat de cet appel dans une variable res de type NodeList
	 * On teste maintenant si le resultat obtenu correspond bien avec le resultat attendu
	 * Pour chaque noeud de la liste, on vérifie s'il n'y a que des noeuds, le nombre des attributs est égal à 3,
	 *  les ids, names et types correspondent
	 * 
	 */
	@Test
	 public void testGetAllNodes() {
	        NodeList res = r.getAllNodes();
	        int tA = 8;
	        assertEquals(tA,res.getLength());
	        ArrayList<String> types = new ArrayList<>();
	        ArrayList<String> ids = new ArrayList<>();
	        ArrayList<String> names = new ArrayList<>();
	        types.add("class");
	        types.add("methodbody");
	        types.add("package");
	        types.add("method");
	        types.add("class");
	        types.add("package");
	        types.add("package");
	        types.add("class");
	        ids.add("1");
	        ids.add("3");
	        ids.add("7");
	        ids.add("2");
	        ids.add("4");
	        ids.add("0");
	        ids.add("5");
	        ids.add("6");
	        names.add("Main");
	        names.add("main");
	        names.add("lang");
	        names.add("main");
	        names.add("void");
	        names.add("test");
	        names.add("@primitive");
	        names.add("String");

	        for (int i = 0; i < res.getLength(); i++) {
	            Node n = res.item(i);
	            assertEquals(n.getNodeName(),"node");
	            assertEquals(n.getAttributes().getLength(),3);
	            assertEquals(n.getAttributes().getNamedItem("name").getNodeValue(),names.get(i));
	            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
	            assertEquals(types.get(i),n.getAttributes().getNamedItem("type").getNodeValue());
	        }
	    }
	
	
		
	/**
	 * Cette methode permet d'obtenir le nombre d'elements de type node dans le fichier XML
	 * Pour tester cette methode, on appelle cette methode sur la variable r
	 *  et on teste si le resultat obtenu est correspond bien avec le resultat attendu
	 * 
	 */
    @Test
    public void testGetNbNodes() {
        int resa = 8;
        int res = r.getNbNodes();
        assertEquals(res, resa);
    }

    
    /**
     * Cette methode permet de generer une requête XPath depuis un index passé en parametres pour récupérer
     * le i-ème élément
     *  //node[1]  permet de selectionner le premier element de type Node.
     */
    @Test
    public void testGenerateNodePathWithIndex() {
        int i = 1;
        String resa = "//node[1]";
        String res = r.generateNodePathWithIndex(i);
        assertEquals(resa,res);
    }
    
    /**
     * Cette methode permet d'obtenir un element de type node par son index dans le ficier xml
     * L'index est initialisé à 1
     * On teste si le resultat attendu est egale au resultat obtenu
     * On commence par tester si le nom est egale a node
     * Puis on vérifie s'il contient 3 attributs.
     * Puis on teste chacun des ses attributs avec les valeurs attendues
     */
    @Test
    public void testGetNode() {
        int i = 1;
        Node res = r.getNode(i);
        assertEquals("node",res.getNodeName());
        assertEquals(3,res.getAttributes().getLength());
        NamedNodeMap atts = res.getAttributes();
        String nA = "Main";
        assertEquals(nA,atts.getNamedItem("name").getNodeValue());
        String iA = "1";
        assertEquals(iA,atts.getNamedItem("id").getNodeValue());
        String tA = "class";
        assertEquals(tA,atts.getNamedItem("type").getNodeValue());
    }
    
    /**
     * Cette methode permet d'obtenir la valeur de l'attribut type d'un element
     *  de type node dont l'index est passe en parametres

     */
    @Test
    public void testGetNodeType() {
        int i = 1;
        String rA = "class";
        String res = r.getNodeType(i);
        assertEquals(res,rA);
    }
    
    
    /**
     * Cette methode permet d'obtenir la valaur 
     * de l'attribut id de l'element de type node dont sa position est identifie dans les parametres
     */
    @Test
    public void testGetNodeId() {
        int i = 1;
        String res = r.getNodeId(i);
        String resa = "1";
        assertEquals(resa,res);
    }
    
    /**
     * Cette methode permet d'obtenir la valaur 
     * de l'attribut name de l'element de type node dont sa position est identifie dans les parametres
     */
    @Test
    public void testGetNodeName() {
        int i = 1;
        String res = r.getNodeName(i);
        String rA = "Main";
        assertEquals(res,rA);
    }
    
    
    /**
     * La methode permet d'obtenir tous les variable de type edge depuis le fichier XML
     * 
     */
    @Test
    public void testGetAllEdges() {
        NodeList ns = r.getAllEdges();
        ArrayList<String> aTypes = new ArrayList<String>(),
                            aId = new ArrayList<String>(),
                            aSrc = new ArrayList<String>(),
                            aDest = new ArrayList<String>();

        aTypes.add("contains");
        aTypes.add("contains");
        aTypes.add("contains");
        aTypes.add("contains");
        aTypes.add("uses");
        aTypes.add("uses");
        aTypes.add("contains");

        aId.add("0");
        aId.add("1");
        aId.add("2");
        aId.add("3");
        aId.add("4");
        aId.add("5");
        aId.add("6");

        aDest.add("6");
        aDest.add("2");
        aDest.add("4");
        aDest.add("3");
        aDest.add("4");
        aDest.add("6");
        aDest.add("1");

        aSrc.add("7");
        aSrc.add("1");
        aSrc.add("5");
        aSrc.add("2");
        aSrc.add("2");
        aSrc.add("2");
        aSrc.add("0");
        for (int i = 0; i < ns.getLength(); i++) {
            Node n = ns.item(i);
            String nname = n.getNodeName();
            String nId = n.getAttributes().getNamedItem("id").getNodeValue();
            String nType = n.getAttributes().getNamedItem("type").getNodeValue();
            String nSrc = n.getAttributes().getNamedItem("src").getNodeValue();
            String nDest = n.getAttributes().getNamedItem("dest").getNodeValue();
            assertEquals(nname,"edge");
            assertEquals(nId,aId.get(i));
            assertEquals(nSrc,aSrc.get(i));
            assertEquals(nDest,aDest.get(i));
        }
    }
    
    /**
     * 
     * Cette mÃ©thode permet d'obtenir le nombre des elements de type edge dans le fichier XML
     */
    @Test
    public void testGetNbEdges() {
        NodeList nl = r.getAllEdges();
        int na = 7;
        assertEquals(nl.getLength(),na);
    }
    
    /**
     *  Cette methode permet de generer une requête XPath depuis un index passé en parametres pour récupérer
     * le i-ème élément eddge
     *  //edge[1]  permet de selectionner le premier element de type Edge.
     */
    @Test
    public void testGenerateEdgePathFromIndex() {
        String va = "//edge[1]";
        int i = 1;
        assertEquals(va,r.generateEdgePathFromIndex(i));
    }
    
    
    /**
     * La methode getEdge permet de recuperer un element de type Edge 
     * depuis le fichier XML par son index passé en paramètres.
     * On teste si le 1er élément Edge récupéré correspond bien au 1er élémen edge du fichier
     * 
     */
    @Test
    public void testGetEdge() {
        Node re = r.getEdge(1);
        String nn = "edge";
        String ta = "contains";
        String aid = "0";
        assertEquals(ta,re.getAttributes().getNamedItem("type").getNodeValue());
        assertEquals(aid,re.getAttributes().getNamedItem("id").getNodeValue());
        String asrc = "7";
        assertEquals(re.getAttributes().getNamedItem("src").getNodeValue(),asrc);
        String adest = "6";
        assertEquals(adest,re.getAttributes().getNamedItem("dest").getNodeValue());
    }
    
    
    /**
     * La methode permet de tester la methode getEdgeId qui permet d'obtenir 
     * la valeur de l'attribut id d'un element de type edge dont son index est passe en parametres
     */
    @Test
    public void testGetEdgeId() {
        String vo = r.getEdgeId(1),va = "0";
        assertEquals(va,vo);
    }
    
    
    /**
     * La methode permet de tester la methode getEdgeId qui permet d'obtenir 
     * la valeur de l'attribut type d'un element de type edge dont son index est passe en parametres
     */
    @Test
    public void testGetEdgeType() {
        String to = r.getEdgeType(1),ta = "contains";
        assertEquals(ta,to);
    }
    
    /**
     * La methode permet de tester la methode getEdgeId qui permet d'obtenir 
     * la valeur de l'attribut src d'un element de type edge dont son index est passe en parametres
     */
    @Test
    public void testGetEdgeSource() {
        String to = r.getEdgeSource(1),ta = "7";
        assertEquals(ta,to);
    }
    
    
    
    /**
     * La methode permet de tester la methode getEdgeId qui permet d'obtenir 
     * la valeur de l'attribut dest d'un element de type edge dont son index est passe en parametres
     */
    @Test
    public void testGetEdgeDestination() {
        String to = r.getEdgeDestination(1),ta = "6";
        assertEquals(ta,to);
    }
    
    /**
     * La methode permet de tester la mathode getEdgeFrom qui permet 
     * d'obtenir la liste des edges partant de l'edge dont son id est passe en parametres
     * 
     */
    @Test
    public void testGetEdgeFrom() {
        int ra = 3;
        int ro = r.getEdgeFrom("2").getLength();
        assertEquals(ro,ra);
    }
}
