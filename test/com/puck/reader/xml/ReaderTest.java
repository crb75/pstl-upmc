package com.puck.reader.xml;

import com.puck.utilities.Logger;
import org.junit.jupiter.api.*;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private Reader r;
    private String message;
    private String methodName;
    @BeforeEach
    void setUp(TestInfo testInfo) {
        this.methodName = testInfo.getTestMethod().get().getName();
        this.message = "Début de la teste de méthode";
        Logger.logMethod(testInfo.getTestMethod().get().getName(),this.message);
        this.message = "On commence par créer une variable r de type Reader en l'initialisant par le constructeur Reader avec le fichier xml mongpraph.xml";
        Logger.logMethod(testInfo.getTestMethod().get().getName(),this.message);
        this.r = new Reader("./test/mongraph.xml");
        this.message = "La variable r de type Reader est bien initialisée";
        Logger.logMethod(this.methodName,this.message);

    }

    @AfterEach
    void endTest(TestInfo testInfo) {
        this.message = "Fin de teste de la méthode";
        Logger.logMethod(testInfo.getTestMethod().get().getName(),this.message);
    }

    @Test
    @DisplayName("Teste de la methode executeStringQuery")
    void executeStringQuery() {
        String resa = "1";
        this.message = "Cette méthode permet d'exécuter une requête XPath dont le type de retour est String sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par créer notre requête à exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node[1]/@id";
        this.message = "La requête qu'on va exécuter est " + req + " qui permet d'obtenir 'attribut id de premier élément node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On exécute notre requête";
        Logger.logMethod(this.methodName, this.message);
        String res = this.r.executeStringQuery(req);
        this.message = "La requête est bien exécuté, on stocke le résultat de cette exécution dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le résultat attendu de cette exécution est " + resa;
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le résultat obtenu est " + res;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si le résultat obtenu correspond bien avec le résultat attendu";
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "Le résultat attendu correspond bien avec le résultat obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le résultat attendu ne coreespond pas avec le résultat obtenu";
            Logger.logError(this.methodName,this.message);
        }
        assertEquals(resa,res);
    }

    @Test
    @DisplayName("Teste de la méthode executeBooleanQuery")
    void executeBooleanQuery() {
        Boolean resa = false;
        this.message = "Cette méthode permet d'exécuter une requête XPath dont le type de retour est booléen sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par initialiser la requête qu'on va exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//edge[1]/@id = 197";
        this.message = "La requête qu'on va exécuter est " + req + " qui permet de tester sur l'idendifiant du premier élément de type edge est égale à 197";
        Logger.logMethod(this.methodName, this.message);
        Boolean res = this.r.executeBooleanQuery(req);
        this.message = "La requête est bien exécuté sur le fichier xml. On a stocké le résultat de retour dans une variable res de type Boolean";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le résultat attendu est " + resa;
        Logger.logMethod(this.methodName, this.message);
        this.message = "Le résultat obtenu est " + res;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si le résultat attendu correspond bien avec le résultat obtenu";
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "Le résultat attendu correspond bien avec le résultat obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else
        {
            this.message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,resa);
    }

    @Test
    @DisplayName("Teste de la méthode executeNodeQuery")
    void executeNodeQuery() {
        this.message = "La méthode permet d'exécuter une requête dont le type de retour est Node sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par d'initialiser la requête que nous allons exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node[1]";
        this.message = "La requête est bien initialisé avec " + req + " qui permet de sélectionner le premier élément de type node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On exécute maintenant cette requête";
        Logger.logMethod(this.methodName, this.message);
        Node res = this.r.executeNodeQuery(req);
        this.message = "La requête est bien exécuté et le résultat de cette exécution est stocké dans une variable res de type Node";
        Logger.logMethod(this.methodName, this.message);
        String nA = "Main";
        String tA = "class";
        String iA = "1";
        String nnA = "node";
        int lA = 3;
        
        this.message = "On va maintenant contrôler si le node obtenu est bien le node attendu";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire, on commence par contrôler si la variable res est non null";
        Logger.logMethod(this.methodName, this.message);
        
        if (res != null) {
            this.message = "La variable res est non null";
            Logger.logMethod(this.methodName, this.message);
        } else
        {
            this.message = "La variable res est null";
            Logger.logError(this.methodName, this.message);
        }
        assertNotNull(res);
        this.message = "Une fois qu'on a vérifié que la variable res est non null. On continue par tester si le nom de Node obtenu est bien le nom qu'on attend qui et " + nnA;

        if (res.getNodeName().equals(nnA)) {
            this.message = "Le nom du résultat obtenu est bien le nom attendu qui est " + nnA;
            Logger.logMethod(this.methodName, this.message);
        } else
        {
            this.message = "Le nom de l'élément obtenu est différent du nom attendu " + nnA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getNodeName(),nnA);

        this.message = "Une fois qu'on a vérifié que l'élément obtenu bien comme nom le nom qu'on attendu, on passe maintenant tester ces attributs.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire on commence par tester si la variable res a bien "+ lA + " attributs";
        Logger.logMethod(this.methodName, this.message);

        if (res.getAttributes().getLength() == lA) {
            this.message = "La variable res a bien " + lA + " attributes";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nombre d'attributes de l'élément res est différente de " + lA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(lA,res.getAttributes().getLength());

        this.message = "Une fois qu'on a vérifié que la variable res contient bien le nombre d'éléments attendu " +
                        lA +
                        ", on commence a tester chacun des ses " +
                        lA +
                        " attributs.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire on commence d'abord par l'attribut id.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste si l'attribut id de l'élément obtenu res est bien " + iA;
        Logger.logMethod(this.methodName, this.message);
        if (iA.equals(res.getAttributes().getNamedItem("id").getNodeValue())) {
            this.message = "La valeur de l'attribut id de l'élément obtenu, res est bien egale à la valeur attendu " + iA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id de l'élement obtenu, res est différent de la valeur attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getAttributes().getNamedItem("id").getNodeValue(), iA);

        this.message = "Une fois qu'on a vérifié que la valeur de l'attribut id est bien la valeur id attendu. On passe maintenant à vérifier si la valeur de l'attribut name est bien la valeur attendu " + nA;
        Logger.logMethod(this.methodName, this.message);
        System.out.println(res.getAttributes().getNamedItem("name").getNodeValue());
        System.out.println(res.getAttributes().getNamedItem("type").getNodeValue());
        System.out.println(res.getAttributes().getNamedItem("id").getNodeValue());
        System.out.println(res.getAttributes().item(1));
        System.out.println(res.getAttributes().item(2));
        System.out.println(res.getAttributes().item(0));
        if (res.getAttributes().getNamedItem("name").getNodeValue().equals(nA)) {
            this.message = "La valeur de l'attribut name de l'élement obtenu, res est égale à la valeur name attendu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id de l'élément obtenu, res est différente de la valeur attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getAttributes().getNamedItem("name").getNodeValue(),nA);

        this.message = "Dernièrement on contrôle si la valeur de l'attribut type est bien égale à la valeur de l'attribut type attendu " + tA;
        Logger.logMethod(this.methodName, this.message);

        if (res.getAttributes().getNamedItem("type").getNodeValue().equals(tA)) {
            this.message = "La valeur de l'attribut type est bien égale à la valeur de l'attribut type attendu " + tA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut type attendu est différent de la valeur de l'attribut type obtenu";
            Logger.logError(this.methodName, this.message);
        }

        assertEquals(tA,res.getAttributes().getNamedItem("type").getNodeValue());
    }

    @Test
    @DisplayName("Teste de la méthode executeNodeSetQuery")
    void executeNodeSetQuery() {
        this.message = "Cette méthode permet d'exécuter une requête XPath dont la valeur de retour est de type NodeList qui est une liste des nodes.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire on commence par initialiser la requête qu'on va exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node";
        this.message = "La requête est initialisée avec " + req + " qui permet de sélectionner tous les éléments de type node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On exécute maintenant cette requête sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        NodeList res = r.executeNodeSetQuery(req);
        this.message = "On a exécuté la requête sur le fichier XML, on a stocké le résultat de cette exécution dans une variable res de type NodeList.";
        Logger.logMethod(this.methodName,this.message);
        this.message = "On teste maintenant si le résultat obtenu correspond bien avec le résultat attendu";
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
        this.message = "On contrôle si le nom de node est égale node ainsi qu'il a 3 attributs et chacun des ses attributs avec les valeurs attendus";
        Logger.logMethod(this.methodName, this.message);
        for (int i = 0; i < res.getLength(); i++) {
            Node n = res.item(i);
            if (n.getNodeName().equals("node")) {
                this.message = "Le nom de l'élément index " + i + " de NodeList est égale à node";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "Le nom de l'élément index " + i + " de NodeList est différent de node";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getNodeName(),"node");
            if(n.getAttributes().getLength() == 3) {
                this.message = "L'élément node a bien 3 attributs";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'élément node n'a pas 3 attributs";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getLength(),3);
            if(n.getAttributes().getNamedItem("name").getNodeValue().equals(names.get(i))) {
                this.message = "La valeur de l'attribut name de l'élémént à l'index " + i + " de NodeList est égale à " + names.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut name de l'élément à l'index " + i + " est différent de " + names.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getNamedItem("name").getNodeValue(),names.get(i));
            if (n.getAttributes().getNamedItem("id").getNodeValue().equals(ids.get(i))) {
                this.message = "L'attribut id de l'élément node à l'index " + i + " est égale à " + ids.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'attribut id de l'élément node à l'index " + i + " est différent de la valeur attendue " + ids.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
            if (n.getAttributes().getNamedItem("type").getNodeValue().equals(types.get(i))) {
                this.message = "La valeur de l'attribut type à l'index " + i + " de NodeList est égale à " + types.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut type à l'index " + i + " est différent de la valeur attendu " + types.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(types.get(i),n.getAttributes().getNamedItem("type").getNodeValue());
        }
    }

    @Test
    @DisplayName("Teste de la méthode getAllNodes")
    void getAllNodes() {
        this.message = "La méthode permet d'obtenir tous les élément de type node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour tester cette méthode, on appelle la méthode sur la variable r et on stocke le résultat de cet appel dans une variable res de type NodeList";
        Logger.logMethod(this.methodName, this.message);
        NodeList res = r.getAllNodes();
        this.message = "On teste maintenant si le résultat obtenu correspond bien avec le résultat attendu";
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
        this.message = "On contrôle si le nom de node est égale node ainsi qu'il a 3 attributs et chacun des ses attributs avec les valeurs attendus";
        Logger.logMethod(this.methodName, this.message);
        for (int i = 0; i < res.getLength(); i++) {
            Node n = res.item(i);
            if (n.getNodeName().equals("node")) {
                this.message = "Le nom de l'élément index " + i + " de NodeList est égale à node";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "Le nom de l'élément index " + i + " de NodeList est différent de node";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getNodeName(),"node");
            if(n.getAttributes().getLength() == 3) {
                this.message = "L'élément node a bien 3 attributs";
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'élément node n'a pas 3 attributs";
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getLength(),3);
            if(n.getAttributes().getNamedItem("name").getNodeValue().equals(names.get(i))) {
                this.message = "La valeur de l'attribut name de l'élémént à l'index " + i + " de NodeList est égale à " + names.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut name de l'élément à l'index " + i + " est différent de " + names.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(n.getAttributes().getNamedItem("name").getNodeValue(),names.get(i));
            if (n.getAttributes().getNamedItem("id").getNodeValue().equals(ids.get(i))) {
                this.message = "L'attribut id de l'élément node à l'index " + i + " est égale à " + ids.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "L'attribut id de l'élément node à l'index " + i + " est différent de la valeur attendue " + ids.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(ids.get(i),n.getAttributes().getNamedItem("id").getNodeValue());
            if (n.getAttributes().getNamedItem("type").getNodeValue().equals(types.get(i))) {
                this.message = "La valeur de l'attribut type à l'index " + i + " de NodeList est égale à " + types.get(i);
                Logger.logMethod(this.methodName, this.message);
            } else {
                this.message = "La valeur de l'attribut type à l'index " + i + " est différent de la valeur attendu " + types.get(i);
                Logger.logError(this.methodName, this.message);
            }
            assertEquals(types.get(i),n.getAttributes().getNamedItem("type").getNodeValue());
        }
    }

    @Test
    @DisplayName("Teste de la méthode getNbNodes()")
    void getNbNodes() {
        this.message = "Cette méthode permet d'obtenir le nombre d'éléments de type node dans le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        int resa = 8;
        this.message = "Pour tester cette méthode, on appelle cette méthode sur la variable r et on teste si le résultat obtenu est correspond bien avec le résultat attendu";
        Logger.logMethod(this.methodName, this.message);
        int res = r.getNbNodes();
        this.message = "On a appelé la méthode sur la variable r, on stocke le résultat de cet appel dans une variable res de type int.";
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

    @Test
    @DisplayName("Teste de la méthode generateNodePathWithIndex")
    void generateNodePathWithIndex() {
        this.message = "Cette méthode permet de générer un requête XPath depuis un index passé en paramètres";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        String resa = "//node[1]";
        this.message = "Pour tester cette méthode, on appelle cette méthode avec le paramètre " + i + " et on stocke le résultat de cet appel dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        String res = r.generateNodePathWithIndex(i);
        this.message = "On a bien appelé la méthode avec le paramètre " + i + " et on a stocké le résultat dans une variable de type String. On contrôle maintenant si cette valeur obtenue correspond avec la valeur attendue " + resa;
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

    @Test
    @DisplayName("Teste de la méthode getNode")
    void getNode() {
        this.message = "Cette méthode permet d'obtenir un élémént de type node par son index dans le ficier xml";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        this.message = "Pour notre exemple cette index est initialisé à " + i;
        Logger.logMethod(this.methodName, this.message);
        this.message = "On appelle cette méthode par cet index et on stocke le résultat obtenu dans une variable res de type Node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour tester si le résultat attendu est égale au résultat obtenu;";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par tester si le nom est égale à node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Puis on contrôle s'il contient 3 attributs. ";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Puis on teste chacun des ses attributs avec les valeurs attendues";
        Logger.logMethod(this.methodName, this.message);
        Node res = r.getNode(i);
        this.message = "On a appelé la méthode par le paramètre " + i +  " et on a stocké le résultat obtenue dans une paramètre res de type Node";
        Logger.logMethod(this.methodName, this.message);
        if (res.getNodeName().equals("node")) {
            this.message = "Le nom du résultat obtenu est bien égale à node";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nom du résultat attendu est différent de node";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals("node",res.getNodeName());
        if (res.getAttributes().getLength() == 3) {
            this.message = "Le nombre d'attributs du résultat obtenu est bien 3";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nombre d'attributs du résultat obtenu est différent de 3";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(3,res.getAttributes().getLength());
        NamedNodeMap atts = res.getAttributes();
        String nA = "Main";
        if (atts.getNamedItem("name").getNodeValue().equals(nA)) {
            this.message = "La valeur de l'attribut name est égale à " + nA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut name est différent de " + nA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(nA,atts.getNamedItem("name").getNodeValue());
        String iA = "1";
        if (atts.getNamedItem("id").getNodeValue().equals(iA)) {
            this.message = "La valeur de l'attribut id du résultat obtenu est égale à " + iA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id du résultat obtenu est différent de " + iA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(iA,atts.getNamedItem("id").getNodeValue());
        String tA = "class";
        if (atts.getNamedItem("type").getNodeValue().equals(tA)) {
            this.message = "La valeur de l'attribut type du résultat obtenu est égale à " + tA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut type de résultat obtenu est différent de " + tA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(tA,atts.getNamedItem("type").getNodeValue());
    }

    @Test
    @DisplayName("Teste de la méthode getNodeType")
    void getNodeType() {
        this.message = "Cette méthode permet d'obtenir la valeur de l'attribut type d'un élément de type node dont l'index est passé en paramètres";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        String rA = "class";
        this.message = "Pour la tester on va appaler cette méthode par l'index " + i + " et puis on va tester si le résultat obtenu par cet appel est égale à " + rA;
        Logger.logMethod(this.methodName, this.message);
        String res = r.getNodeType(i);
        this.message = "La méthode est appelé par le paramètre " + i + " et le résultat de cet appel est stocké dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste maintenant si la valeur de la variable res est égale à " + rA;
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(rA)) {
            this.message = "La valeur de la variable res est égale à "+ rA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de la variable res est différente de " + rA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,rA);
    }

    @Test
    @DisplayName("Teste de la méthode getNodeId")
    void getNodeId() {
        this.message = "Cette méthode permet d'obtenir la valaur de l'attribut id de l'élément de type node dont sa position est identifié dans les paramètres";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        this.message = "Pour la tester on appelle la méthode par le paramètre " + i;
        Logger.logMethod(this.methodName, this.message);
        String res = r.getNodeId(i);
        this.message = "La méthode est appelé par le paramètre " + i + " et le résultat de cet appel est stocké dans la variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        String resa = "1";
        this.message = "On teste maintenant si la valeur obtenue est égale à la valeur attendue " + resa;
        Logger.logMethod(this.methodName, this.message);
        if (res.equals(resa)) {
            this.message = "La valeur attendue est égale à la valeur obtenue";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur obtenue est différente de la valeur attendue";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(resa,res);
    }

    @Test
    @DisplayName("Teste de la méthode getNodeName")
    void getNodeName() {
        this.message = "La méthode permet d'obtenir la valeur de l'attribut name de l'élément node dont sa position est défini par le paramètre";
        Logger.logMethod(this.methodName, this.message);
        int i = 1;
        this.message = "Pour le tester on appelle cette méthode par le paramètre " + i;
        Logger.logMethod(this.methodName, this.message);
        String res = r.getNodeName(i);
        this.message = "On a bien appelé la méthode et on a stocké le résultat de cet appel dans une variable res de type String";
        Logger.logMethod(this.methodName, this.message);
        String rA = "Main";
        this.message = "On teste maintenant si le résultat obtenu correspond avec le résultat attendu";
        Logger.logMethod(this.methodName, this.message);
        if (rA.equals(res)) {
            this.message = "Le résultat attendu correspond bien avec le résultat obtenu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le résultat attendu ne correspond pas avec le résultat attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,rA);
    }

    @Test
    @Disabled("Not yet implemented")
    void getAllEdges() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getNbEdges() {
    }

    @Test
    @Disabled("Not yet implemented")
    void generateEdgePathFromIndex() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getEdge() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getEdgeId() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getEdgeType() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getEdgeSource() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getEdgeDestination() {
    }

    @Test
    @Disabled("Not yet implemented")
    void getEdgeFrom() {
    }
}