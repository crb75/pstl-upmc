package com.puck.reader.xml;

import com.puck.nodes.piccolo2d.Edge;
import com.puck.utilities.Logger;
import com.sun.org.apache.xpath.internal.NodeSet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class ReaderTest {

    private Reader r;
    private String message;
    private String methodName;

    @BeforeMethod
    public void setUp(Method method) {
        this.methodName = method.getName();
        this.message = "Debut de la teste de methode";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par creer une variable r de type Reader en l'initialisant par le constructeur Reader avec le fichier xml test_assets/mongraph.xml";
        Logger.logMethod(this.methodName, this.message);
        this.r = new Reader("./test_assets/mongraph.xml");
        this.message = "La variable r de type Reader est bien initialisee";
        Logger.logMethod(this.methodName, this.message);
    }

    @AfterMethod
    public void tearDown(Method method) {
        this.methodName = method.getName();
        this.message = "Fin de teste de la methode";
        Logger.logMethod(this.methodName, this.message);
    }

    @Test(
            description = "Teste de la methode executeStringQuery",
            groups = {"reader","simple","executeStringQuery"}
    )
    public void testExecuteStringQuery() {
        String resa = "1";
        this.message = "Cette methode pet d'executer une requête XPath dont le type de retour est String sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par creer notre requête a executer";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node[1]/@id";
        this.message = "La requête qu'on va executer est " +
                        req +
                        " qui permet d'obtenir id de premier element node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On execute notre requête";
        Logger.logMethod(this.methodName, this.message);
        String res = this.r.executeStringQuery(req);
        this.message = "La requête est bien execute, on stocke le resultat de cette execution dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le resultat attendu de cette execution est " + resa;
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le resultat obtenu est " + res;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si le resultat obtenu correspond bien avec le resultat attendu";
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "Le resultat attendu correspond bien avec le resultat obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le resultat attendu ne correspond pas avec le resultat obtenu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(resa,res);
    }

    @Test(
            description = "Teste de la methode executeBooleanQuery",
            groups = {"reader","simple","executeBooleanQuery"}
    )
    public void testExecuteBooleanQuery() {
        Boolean resa = false;
        this.message = "Cette methode permet d'executer une requête XPath dont le type de retour est booleen sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par initialiser la requête qu'on va executer";
        Logger.logMethod(this.methodName, this.message);
        String req = "//edge[1]/@id = 197";
        this.message = "La requête qu'on va executer est " +
                        req +
                        " qui permet de tester sur l'identifiant du premier d'element de type edge est egale a 197";
        Logger.logMethod(this.methodName, this.message);
        Boolean res = this.r.executeBooleanQuery(req);
        this.message = "La requête est bien execute sur le fichier xml. On a stocke le resultat de retour dans une variable res de type Boolean";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le resultat attendu est " + resa;
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le resultat obtenu est " + res;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si le resultat attendu correspond bien avec le resultat obtenu";
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "Le resultat attendu correspond bien avec le resultat obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le resultat obtenu ne correspond pas avec le resultat attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,resa);
    }

    @Test(
            description = "Teste de la methode executeNodeQuery",
            groups = {"reader","simple","executeNodeQuery"}
    )
    public void testExecuteNodeQuery() {
        this.message = "La methode permet d'executer une requête dont le type de retour est Node sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par initialiser la requête que nous allons executer";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node[1]";
        this.message = "La requête est bien initialise avec " +
                        req +
                        " qui permet de selectionner le premier element de type Node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On execute maintenant cette requête";
        Logger.logMethod(this.methodName, this.message);
        Node res = this.r.executeNodeQuery(req);
        this.message = "LA requête est bien execute et le resultat de cette execution est stocke dans une variable res de type Node";
        Logger.logMethod(this.methodName, this.message);
        String nA = "Main",
                tA = "class",
                iA = "1",
                nnA = "node";
        int lA = 3;
        this.message = "On va maintenant contrôler si le node obtenu est bien le node attendu";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire, on commence par contrôler si la variable res est non null";
        Logger.logMethod(this.methodName, this.message);
        if (res != null) {
            this.message = "La variable res est non null";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La variable res est null";
            Logger.logError(this.methodName, this.message);
        }
        assertNotNull(res);
        this.message = "Une fois qu'on a verifie que la variable res est non null. On continue par tester si le nom de Node obtenu est bien le nom qu'on attend qui est " + nnA;
        Logger.logMethod(this.methodName, this.message);
        if (res.getNodeName().equals(nnA)) {
            this.message = "Le nom du resultat obtenu est bien le nom attendu qui est " + nnA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nom de l'element obtenu est different du nom attendu " + nnA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getNodeName(),nnA);
        this.message = "Une fois qu'on a verifie que l'element obtenu a bien comme nom le nom qu'on a attendu. On passe maintenant tester ces attributs.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire, on commence par tester si la variable res a bien " +
                        lA +
                        " attributs";
        Logger.logMethod(this.methodName, this.message);
        if (res.getAttributes().getLength() == lA) {
            this.message = "La variable res a bien " +
                            lA +
                            " attributes";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nombre d'attibutes de l'element res est differente de " +
                            lA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(lA,res.getAttributes().getLength());
        this.message = "Une fois qu'on a verifie que la variable res contient bien le nombre d'elements attendu " +
                        lA +
                        " on commence a tester chacun des ses " +
                        lA +
                        " attributs";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire, on commence d'abord par l'attribut id.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste si l'attribut id de l'element obtenu res est bien " + iA;
        Logger.logMethod(this.methodName, this.message);
        if (iA.equals(res.getAttributes().getNamedItem("id").getNodeValue())) {
            this.message = "La valeur de l'attribut id de l'element obtenu, res est bien egale a la valeur attendu " +
                            iA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id de l'element obtenu, res est different de la valeur attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getAttributes().getNamedItem("id").getNodeValue(),iA);
        this.message = "Une fois qu'on a verifie que la valeur de l'attribut id est bien la valeur id attendu. On passe maintenant a verifier si la valeur de l'attribut name est bien la valeur attendu " +
                        nA;
        Logger.logMethod(this.methodName, this.message);
        if (res.getAttributes().getNamedItem("name").getNodeValue().equals(nA)) {
            this.message = "La valeur de l'attribut name de l'element obtenu, res est egale a la valeur name attendu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id de l'element obtenu, rest est differents de la valeur attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getAttributes().getNamedItem("name").getNodeValue(), nA);
        if (res.getAttributes().getNamedItem("type").getNodeValue().equals(tA)) {
            this.message = "La valeur de l'attribut type est bien egale a la valeur de l'attribut type attendu " + tA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut type attendu est different de la valeur de l'attribut type obtenu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(tA,res.getAttributes().getNamedItem("type").getNodeValue());
    }

    @Test(
            description = "Teste de la methode executeNodeSetQuery",
            groups = {"reader","simple","executeNodeSetQuury"}
    )
    public void testExecuteNodeSetQuery() {
        this.message = "Cette methode permet d'executer une requête XPath dont la valeur de retour est de type NodeList qui est une liste des nodes.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire on commence par initialiser la requête qu'on va executer";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node";
        this.message = "La requête est initialisee avec " + req + " qui permet de selectionner tous les elements de type node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On execute maintenant cette requête sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        NodeList res = r.executeNodeSetQuery(req);
        this.message = "On a execute la requête sur le fichier XML, on a stocke le resultat de cette execution dans une variable res de type NodeList.";
        Logger.logMethod(this.methodName,this.message);
        this.message = "On teste maintenant si le resultat obtenu correspond bien avec le resultat attendu";
        Logger.logMethod(this.methodName, this.message);
        int tA = 8;
        this.message = "Pour le faire on commence par tester si la taille de NodeList obtenu correspond bien avec la taille de attendu " + tA;
        Logger.logMethod(this.methodName, this.message);
        if (tA == res.getLength()) {
            this.message = "La taille de NodeList attendu correspond bien avec la taille de NodeList obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La taille de NodeList attendu ne correspond pas avec la taille de NodeList obtenu";
            Logger.logError(this.methodName, this.message);
        }
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
        this.message = "Pour ce faire on parcours tous les nodes dans la NodeList, et pour chaque node;";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On contrôle si le nom de node est egale node ainsi qu'il a 3 attributs et chacun des ses attributs avec les valeurs attendus";
        Logger.logMethod(this.methodName, this.message);
        for (int i = 0; i < res.getLength(); i++) {
            Node n = res.item(i);
            if (n.getNodeName().equals("node")) {
                this.message = "Le nom de l'element index " + i + " de NodeList est egale a node";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "Le nom de l'element index " + i + " de NodeList est different de node";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getNodeName(),"node");
            if(n.getAttributes().getLength() == 3) {
                this.message = "L'element node a bien 3 attributs";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'element node n'a pas 3 attributs";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getLength(),3);
            if(n.getAttributes().getNamedItem("name").getNodeValue().equals(names.get(i))) {
                this.message = "La valeur de l'attribut name de l'element a l'index " + i + " de NodeList est egale a " + names.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut name de l'element a l'index " + i + " est different de " + names.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getNamedItem("name").getNodeValue(),names.get(i));
            if (n.getAttributes().getNamedItem("id").getNodeValue().equals(ids.get(i))) {
                this.message = "L'attribut id de l'element node a l'index " + i + " est egale a " + ids.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'attribut id de l'element node a l'index " + i + " est different de la valeur attendue " + ids.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
            if (n.getAttributes().getNamedItem("type").getNodeValue().equals(types.get(i))) {
                this.message = "La valeur de l'attribut type a l'index " + i + " de NodeList est egale a " + types.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut type a l'index " + i + " est different de la valeur attendu " + types.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(types.get(i),n.getAttributes().getNamedItem("type").getNodeValue());
        }
    }

    @Test(
            description = "Teste de la methode getAllNodes",
            groups = {"reader","simple","getAllNodes"}
    )
    public void testGetAllNodes() {
        this.message = "La methode permet d'obtenir tous les element de type node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour tester cette methode, on appelle la methode sur la variable r et on stocke le resultat de cet appel dans une variable res de type NodeList";
        Logger.logMethod(this.methodName, this.message);
        NodeList res = r.getAllNodes();
        this.message = "On teste maintenant si le resultat obtenu correspond bien avec le resultat attendu";
        Logger.logMethod(this.methodName, this.message);
        int tA = 8;
        this.message = "Pour le faire on commence par tester si la taille de NodeList obtenu correspond bien avec la taille de attendu " + tA;
        Logger.logMethod(this.methodName, this.message);
        if (tA == res.getLength()) {
            this.message = "La taille de NodeList attendu correspond bien avec la taille de NodeList obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La taille de NodeList attendu ne correspond pas avec la taille de NodeList obtenu";
            Logger.logError(this.methodName, this.message);
        }
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
        this.message = "Pour ce faire on parcours tous les nodes dans la NodeList, et pour chaque node;";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On contrôle si le nom de node est egale node ainsi qu'il a 3 attributs et chacun des ses attributs avec les valeurs attendus";
        Logger.logMethod(this.methodName, this.message);
        for (int i = 0; i < res.getLength(); i++) {
            Node n = res.item(i);
            if (n.getNodeName().equals("node")) {
                this.message = "Le nom de l'element index " + i + " de NodeList est egale a node";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "Le nom de l'element index " + i + " de NodeList est different de node";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getNodeName(),"node");
            if(n.getAttributes().getLength() == 3) {
                this.message = "L'element node a bien 3 attributs";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'element node n'a pas 3 attributs";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getLength(),3);
            if(n.getAttributes().getNamedItem("name").getNodeValue().equals(names.get(i))) {
                this.message = "La valeur de l'attribut name de l'element a l'index " + i + " de NodeList est egale a " + names.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut name de l'element a l'index " + i + " est different de " + names.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getNamedItem("name").getNodeValue(),names.get(i));
            if (n.getAttributes().getNamedItem("id").getNodeValue().equals(ids.get(i))) {
                this.message = "L'attribut id de l'element node a l'index " + i + " est egale a " + ids.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'attribut id de l'element node a l'index " + i + " est different de la valeur attendue " + ids.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
            if (n.getAttributes().getNamedItem("type").getNodeValue().equals(types.get(i))) {
                this.message = "La valeur de l'attribut type a l'index " + i + " de NodeList est egale a " + types.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut type a l'index " + i + " est different de la valeur attendu " + types.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(types.get(i),n.getAttributes().getNamedItem("type").getNodeValue());
        }
    }

    @Test(
            description = "Teste de la methode getNbNodes",
            groups = {"simple","reader","getNbNodes"}
    )
    public void testGetNbNodes() {
        this.message = "Cette methode permet d'obtenir le nombre d'elements de type node dans le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        int resa = 8;
        this.message = "Pour tester cette methode, on appelle cette methode sur la variable r et on teste si le resultat obtenu est correspond bien avec le resultat attendu";
        Logger.logMethod(this.methodName, this.message);
        int res = r.getNbNodes();
        this.message = "On a appele la methode sur la variable r, on stocke le resultat de cet appel dans une variable res de type int.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On contrôle maintenant si la valeur obtenu correspond avec la valeur attendue " + resa;
        Logger.logMethod(this.methodName, this.message);
        if (res == resa) {
            this.message = "La valeur attendue correspond bien avec la valeur obtenue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur attendu de correspond pas avec la valeur obntenue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res, resa);
    }

    @Test(
            description = "Teste de la methode generateNodePathWithIndex",
            groups = {"reader","simple","generateNodePathWithIndex"}
    )
    public void testGenerateNodePathWithIndex() {
        this.message = "Cette methode permet de generer un requête XPath depuis un index passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        String resa = "//node[1]";
        this.message = "Pour tester cette methode, on appelle cette methode avec le parametre " + i + " et on stocke le resultat de cet appel dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        String res = r.generateNodePathWithIndex(i);
        this.message = "On a bien appele la methode avec le parametre " + i + " et on a stocke le resultat dans une variable de type String. On contrôle maintenant si cette valeur obtenue correspond avec la valeur attendue " + resa;
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "La valeur obtenue correspond bien avec la valeur attendue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur attendue ne correspond pas avec la valeur obtenue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(resa,res);
    }

    @Test(
            description = "Teste de la methode getNode",
            groups = {"simple","reader","getNode"}
    )
    public void testGetNode() {
        this.message = "Cette methode permet d'obtenir un element de type node par son index dans le ficier xml";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        this.message = "Pour notre exemple cette index est initialise a " + i;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On appelle cette methode par cet index et on stocke le resultat obtenu dans une variable res de type Node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour tester si le resultat attendu est egale au resultat obtenu;";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par tester si le nom est egale a node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Puis on contrôle s'il contient 3 attributs. ";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Puis on teste chacun des ses attributs avec les valeurs attendues";
        Logger.logMethod(this.methodName, this.message);
        Node res = r.getNode(i);
        this.message = "On a appele la methode par le parametre " + i +  " et on a stocke le resultat obtenue dans une parametre res de type Node";
        Logger.logMethod(this.methodName, this.message);
        if (res.getNodeName().equals("node")) {
            this.message = "Le nom du resultat obtenu est bien egale a node";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nom du resultat attendu est different de node";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals("node",res.getNodeName());
        if (res.getAttributes().getLength() == 3) {
            this.message = "Le nombre d'attributs du resultat obtenu est bien 3";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nombre d'attributs du resultat obtenu est different de 3";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(3,res.getAttributes().getLength());
        NamedNodeMap atts = res.getAttributes();
        String nA = "Main";
        if (atts.getNamedItem("name").getNodeValue().equals(nA)) {
            this.message = "La valeur de l'attribut name est egale a " + nA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut name est different de " + nA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(nA,atts.getNamedItem("name").getNodeValue());
        String iA = "1";
        if (atts.getNamedItem("id").getNodeValue().equals(iA)) {
            this.message = "La valeur de l'attribut id du resultat obtenu est egale a " + iA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id du resultat obtenu est different de " + iA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(iA,atts.getNamedItem("id").getNodeValue());
        String tA = "class";
        if (atts.getNamedItem("type").getNodeValue().equals(tA)) {
            this.message = "La valeur de l'attribut type du resultat obtenu est egale a " + tA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut type de resultat obtenu est different de " + tA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(tA,atts.getNamedItem("type").getNodeValue());
    }

    @Test(
            description = "Teste de la methode getNodeType",
            groups = {"simple","reader","getNodeType"}
    )
    public void testGetNodeType() {
        this.message = "Cette methode permet d'obtenir la valeur de l'attribut type d'un element de type node dont l'index est passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        String rA = "class";
        this.message = "Pour la tester on va appaler cette methode par l'index " + i + " et puis on va tester si le resultat obtenu par cet appel est egale a " + rA;
        Logger.logMethod(this.methodName, this.message);
        String res = r.getNodeType(i);
        this.message = "La methode est appele par le parametre " + i + " et le resultat de cet appel est stocke dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si la valeur de la variable res est egale a " + rA;
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(rA)) {
            this.message = "La valeur de la variable res est egale a "+ rA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de la variable res est differente de " + rA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,rA);
    }

    @Test(
            description = "Teste de la methode getNodeId",
            groups = {"simple", "reader", "getNodeId"}
    )
    public void testGetNodeId() {
        this.message = "Cette methode permet d'obtenir la valaur de l'attribut id de l'element de type node dont sa position est identifie dans les parametres";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        this.message = "Pour la tester on appelle la methode par le parametre " + i;
        Logger.logMethod(this.methodName, this.message);
        String res = r.getNodeId(i);
        this.message = "La methode est appele par le parametre " + i + " et le resultat de cet appel est stocke dans la variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        String resa = "1";
        this.message = "On teste maintenant si la valeur obtenue est egale a la valeur attendue " + resa;
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "La valeur attendue est egale a la valeur obtenue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur obtenue est differente de la valeur attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(resa,res);
    }

    @Test(
            description = "Teste de la methode getNodeName",
            groups = {"simple", "reader", "getNodeName"}
    )
    public void testGetNodeName() {
        this.message = "La methode permet d'obtenir la valeur de l'attribut name de l'element node dont sa position est defini par le parametre";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        this.message = "Pour le tester on appelle cette methode par le parametre " + i;
        Logger.logMethod(this.methodName, this.message);
        String res = r.getNodeName(i);
        this.message = "On a bien appele la methode et on a stocke le resultat de cet appel dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        String rA = "Main";
        this.message = "On teste maintenant si le resultat obtenu correspond avec le resultat attendu";
        Logger.logMethod(this.methodName, this.message);
        if (rA.equals(res)) {
            this.message = "Le resultat attendu correspond bien avec le resultat obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le resultat attendu ne correspond pas avec le resultat attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,rA);
    }

    @Test(
            description = "Teste de la méthode getAllEdges",
            groups = {"simple", "reader", "getAllEdges"}
    )
    public void testGetAllEdges() {
        this.message = "La methode permet d'obtenir tous les variable de type edge depuis le fichier XML";
        Logger.logMethod(this.methodName, this.message);
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
            this.message = "Index : " + i;
            Logger.logMethod(this.methodName, this.message);
            Node n = ns.item(i);
            String nname = n.getNodeName();
            String nId = n.getAttributes().getNamedItem("id").getNodeValue();
            String nType = n.getAttributes().getNamedItem("type").getNodeValue();
            String nSrc = n.getAttributes().getNamedItem("src").getNodeValue();
            String nDest = n.getAttributes().getNamedItem("dest").getNodeValue();
            if (nname.equals("edge")) {
                this.message = "Le nom du noeud est edge";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "Le nom du noeud est différent de edge";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(nname,"edge");

            if (nId.equals(aId.get(i))) {
                this.message = "La valeur de l'attribut id de edge est égale à la valeur attendue";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut id de edge est différente de la valeur attendue";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(nId,aId.get(i));

            System.out.println("La valeur attendue " + aSrc.get(i));
            System.out.println("La valeur obtenue " + nSrc);
            if (nSrc.equals(aSrc.get(i))) {
                this.message = "La valeur de l'attribut src de edge " +
                                nSrc +
                                " est égale à la valeur attendue " +
                                aSrc.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut src de edge " +
                                nSrc +
                                " est differente de la valeur attendue " +
                                aSrc.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(nSrc,aSrc.get(i));

            if (nDest.equals(aDest.get((i)))) {
                this.message = "La valeur de l'attribut dest de edge est égale à la valeur attendue";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut dest de edge " +
                                nDest +
                                " est différente de la valeur attendue " +
                                aDest.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(nDest,aDest.get(i));
        }
    }

    @Test(
            description = "Teste de la méthode getNbEdges",
            groups = {"simple", "reader", "getNbEdges"}
    )
    public void testGetNbEdges() {
        this.message = "Cette méthode permet d'obtenir le nombre des elements de type edge dans le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire, on recupere tous les elements de type edge par la methode getAllEdges sur le reader";
        Logger.logMethod(this.methodName, this.message);
        NodeList nl = r.getAllEdges();
        this.message = "Tous les elements de type edge depuis le fichier XML ont ete recuperee et stockee dans une variable nl de type NodeList";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On controle maintenant si le nombre des elements de type edge correspond bien avec le nombre d'elements attendu";
        Logger.logMethod(this.methodName, this.message);
        int na = 7;
        this.message = "Le nombre des elements attendu est " + na;
        Logger.logMethod(this.methodName, this.message);
        if (nl.getLength() == na) {
            this.message = "Le nombre d'elements obtenu correspond bien avec le nombre d'elements attendu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nombre d'elements obtenu ne correspond pas avec le nombre d'elements attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(nl.getLength(),na);
    }

    @Test(
            description = "La méthode permet de tester la méthode generetaeEdgePathFromIndex",
            groups = {"simple","reader","generateEdgePathFromIndex"}
    )
    public void testGenerateEdgePathFromIndex() {
        this.message = "Cette methode permet de tester la methode generateEdgePathFromIndex de la classe Reader";
        Logger.logMethod(this.methodName, this.message);
        this.message = "La methode generateEdgePathFromIndex permet de generer un requete XPath qui permet de selectionner l'element de type edge a partir de la valeur index qui est elle meme passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On va tester pour index = 1";
        Logger.logMethod(this.methodName, this.message);
        String va = "//edge[1]";
        this.message = "La valeur attendu par cet appel de la methode est " + va;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si la valeur attendu correspond bien avec la valeur obtenue";
        Logger.logMethod(this.methodName, this.message);
        if (va.equals(r.generateEdgePathFromIndex(1))) {
            this.message = "La valeur obtenu correspond bien avec la valeur attendue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur attendue ne correspond pas avec la valeur obtenue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(va,r.generateEdgePathFromIndex(1));
    }

    @Test(
            description = "La méthode permet de tester la méthode getEdge de la classe Reader",
            groups = {"simple", "reader", "getEdge"}
    )
    public void testGetEdge() {
        this.message = "La methode permet de tester la methode getEdge de la classe Reader";
        Logger.logMethod(this.methodName, this.message);
        this.message = "la methode getEdge permet de recuperer un element de type Edge depuis le fichier XML par son index passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce cas de teste on va utiliser l'index = 1";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On va appeler la methode getEdge avec index = 1 et on va stocker le resultat de cet appel dans une variable re de type Node";
        Logger.logMethod(this.methodName, this.message);
        Node re = r.getEdge(1);
        this.message = "La methode getEdge est bien appele avec l'index = 1 et le resultat de cet appel est stocke dans une variable ne de type Node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On va maintenant controler les attributs type, id, src et dest de cet element obtenu ainsi que le nom de noeud";
        Logger.logMethod(this.methodName, this.message);
        String nn = "edge";
        this.message = "On commence par controler le nom de noeud";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On controle si le nom du noeud obtenu est bien egale a " + nn;
        Logger.logMethod(this.methodName, this.message);
        if (re.getNodeName().equals(nn)) {
            this.message = "Le nom du noeud obtenu est bien egale a " + nn;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nom du noeud obtenu est different de " + nn;
            Logger.logError(this.methodName, this.message);
        }
        this.message = "On controle maintenant la valeur de l'attribut type du noeud obtenu";
        Logger.logMethod(this.methodName, this.message);
        String ta = "contains";
        this.message = "La valeur de l'attribut type doit etre egale a " + ta;
        Logger.logMethod(this.methodName, this.message);
        if (ta.equals(re.getAttributes().getNamedItem("type").getNodeValue())) {
            this.message = "La valeur de l'attribut type est egale a " + ta;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut type est different de " + ta;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(ta,re.getAttributes().getNamedItem("type").getNodeValue());
        this.message = "On controle en suite la valeur de l'attribut id ";
        Logger.logMethod(this.methodName, this.message);
        String aid = "0";
        this.message = "La valeur de l'attribut id doit etre egale a " + aid;
        Logger.logMethod(this.methodName, this.message);
        if (aid.equals(re.getAttributes().getNamedItem("id").getNodeValue())) {
            this.message = "La valeur de l'attribut id est egale a la valeur attendue " + aid;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id est differente de la valeur attendue " + aid;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(aid,re.getAttributes().getNamedItem("id").getNodeValue());
        this.message = "On controle maintenant la valeur de l'attribut src";
        Logger.logMethod(this.methodName, this.message);
        String asrc = "7";
        this.message = "La valeur de l'attribut src doit etre egale a " + asrc;
        Logger.logMethod(this.methodName, this.message);
        if (re.getAttributes().getNamedItem("src").getNodeValue().equals(asrc)) {
            this.message = "La valeur de l'attribut src est egale a la valeur attendue " + asrc;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut src est differente de la valeur attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(re.getAttributes().getNamedItem("src").getNodeValue(),asrc);
        this.message = "On controle maintenant la valeur de l'attribut dest ";
        Logger.logMethod(this.methodName, this.message);
        String adest = "6";
        this.message = "La valeur de l'attribut src doit etre egale a " + adest;
        Logger.logMethod(this.methodName, this.message);
        if (adest.equals(re.getAttributes().getNamedItem("dest").getNodeValue())) {
            this.message = "La valeur de l'attribut dest est egale a la valeur attendue " + adest;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut dest est differente de la valeur attendue " + adest;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(adest,re.getAttributes().getNamedItem("dest").getNodeValue());
    }

    @Test(
            description = "La méthode permet de tester la methode getEdgeId de la classe Reader",
            groups = {"simple", "reader", "getEdgeId"}
    )
    public void testGetEdgeId() {
        this.message = "La methode permet de tester la methode getEdgeId qui permet d'obtenir la valeur de l'attribut id d'un element de type edge dont son index est passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce cas de teste on va utiliser index = 1";
        Logger.logMethod(this.methodName, this.message);
        String vo = r.getEdgeId(1),
               va = "0";
        this.message = "La valeur attendu de cet appel de la methode est " + va;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si la valeur obtenue " + vo +
                        " est egale a la valeur attendue " + va;
        Logger.logMethod(this.methodName, this.message);
        if (va.equals(vo)) {
            this.message = "La valeur attendue est egale a la valeur obtenue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur obtenue est differente de la valeur attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(va,vo);
    }

    @Test(
            description = "la methode permet de tester la methode getEdgeType de la classe Reader",
            groups = {"reader", "simple", "getEdgeType"}
    )
    public void testGetEdgeType() {
        this.message = "la methode permet de tester la methode getEdgeType qui permet d'obtenir la valeur de l'attribut type d'un element edge depuis le fichier XML par l'index passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce cas de teste on va utiliser index = 1";
        Logger.logMethod(this.methodName, this.message);
        String va = "contains",
                vo = r.getEdgeType(1);
        this.message = "La valeur obtenu est " + vo;
        Logger.logMethod(this.methodName, this.message);
        this.message = "La valeur attendue est " + va;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si la valeur attendue correspond bien avec la valeur obtenue ";
        Logger.logMethod(this.methodName, this.message);
        if (va.equals(vo)) {
            this.message = "La valeur obtenue correspond avec la valeur attendue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur obtenue ne correspond pas avec la valeur attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(va,vo);
    }

    @Test(
            description = "La méthode permet de tester la méthode getEdgeSource de la classe Reader",
            groups = {"reader", "simple", "getEdgeSource"}
    )
    public void testGetEdgeSource() {
        this.message = "La methode permet de tester la methode getEdgeSource de la classe Reader.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Cette methode permet d'obtenir la valeur de l'attribut source du noeud dont son index est passé en paramètres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce cas de teste on va utiliser index = 1";
        Logger.logMethod(this.methodName, this.message);
        String vo = r.getEdgeSource(1),
                va = "7";
        this.message = "La valeur obtenu est " + vo;
        Logger.logMethod(this.methodName, this.message);
        this.message = "La valeur attendue est " + va;
        Logger.logMethod(this.methodName, this.message);
        if (va.equals(vo)) {
            this.message = "La valeur obtenue correspond avec la valeur attendue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur obtenue ne correspond pas avec la valeur attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(vo,va);
    }

    @Test(
            description = "La methode permet de tester la methode getEdgeDestination de la classe Reader",
            groups = {"simple","reader","getEdgeDestination"}
    )
    public void testGetEdgeDestination() {
        this.message = "Cette methode permet de tester la mathide getEdgeDestination qui permet d'obtenir la valeur de l'attribut destination du noeud de type edge dont son index est passé en paramètres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce cas d'exemple on va utiliser index = 1";
        Logger.logMethod(this.methodName, this.message);
        String vo = r.getEdgeDestination(1),
                va = "6";
        this.message = "On va tester maintenant si la valeur attendue " +
                        va +
                        " est egale a la valeur obtenue " +
                        vo;
        Logger.logMethod(this.methodName, this.message);
        if (vo.equals(va)) {
            this.message = "La valeur obtenu correspond bien avec la valeur attendue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur attendue ne correspond pas avec la valeur obtanue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(va, vo);
    }

    @Test(
            description = "Methode permet de tester la methode getEdgeFrom de la classe Reader",
            groups = {"simple","reader","getEdgeFrom"}
    )
    public void testGetEdgeFrom() {
        this.message = "La methode permet de tester la mathode getEdgeFrom qui permet d'obtenir la liste des edges qui partennt de l'edge doont son id est passe en parametres";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce cas de teste on utilise id = 3";
        Logger.logMethod(this.methodName, this.message);
        int ra = 0;
        this.message = "La taille de la liste attendue est " + ra;
        Logger.logMethod(this.methodName, this.message);
        int ro = r.getEdgeFrom("3").getLength();
        this.message = "La taille de la liste obtenue est " + ro;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On controle maintenant si la taille de la liste obtenue correspond bien avec la taille de la liste attendue";
        Logger.logMethod(this.methodName, this.message);
        if (ra == ro) {
            this.message = "La taille de la liste attendue correspond avec la taille de la liste obtenue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La taille de la liste obtenue ne correspond pas avec la taille de la liste attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(ro,ra);
    }
}