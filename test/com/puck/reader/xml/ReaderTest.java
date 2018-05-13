package com.puck.reader.xml;

import com.puck.utilities.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Node;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class ReaderTest {

    private Reader r;
    private String message;
    private String methodName;

    @BeforeMethod
    public void setUp(Method method) {
        this.methodName = method.getName();
        this.message = "Début de la teste de méthode";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par créer une variable r de type Reader en l'initialisant par le constructeur Reader avec le fichier xml test_assets/mongraph.xml";
        Logger.logMethod(this.methodName, this.message);
        this.r = new Reader("./test_assets/mongraph.xml");
        this.message = "La variable r de type Reader est bien initialisée";
        Logger.logMethod(this.methodName, this.message);
    }

    @AfterMethod
    public void tearDown(Method method) {
        this.methodName = method.getName();
        this.message = "Fin de teste de la méthode";
        Logger.logMethod(this.methodName, this.message);
    }

    @Test(
            description = "Teste de la méthode executeStringQuery",
            groups = {"reader","simple","executeStringQuery"}
    )
    public void testExecuteStringQuery() {
        String resa = "1";
        this.message = "Cette méthode pet d'exécuter une requête XPath dont le type de retour est String sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par créer notre requête à exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node[1]/@id";
        this.message = "La requête qu'on va exécuter est " +
                        req +
                        " qui permet d'obtenir id de premier élément node";
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
            this.message = "Le résultat attendu ne correspond pas avec le résultat obtenu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(resa,res);
    }

    @Test(
            description = "Teste de la méthode executeBooleanQuery",
            groups = {"reader","simple","executeBooleanQuery"}
    )
    public void testExecuteBooleanQuery() {
        Boolean resa = false;
        this.message = "Cette méthode permet d'exécuter une requête XPath dont le type de retour est booléen sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par initialiser la requête qu'on va exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//edge[1]/@id = 197";
        this.message = "La requête qu'on va exécuter est " +
                        req +
                        " qui permet de tester sur l'identifiant du premier d'élément de type edge est égale à 197";
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
        } else {
            this.message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res,resa);
    }

    @Test(
            description = "Teste de la méthode executeNodeQuery",
            groups = {"reader","simple","executeNodeQuery"}
    )
    public void testExecuteNodeQuery() {
        this.message = "La méthode permet d'exécuter une requête dont le type de retour est Node sur le fichier XML";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par initialiser la requête que nous allons exécuter";
        Logger.logMethod(this.methodName, this.message);
        String req = "//node[1]";
        this.message = "La requête est bien initialisé avec " +
                        req +
                        " qui permet de sélectionner le premier élément de type Node";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On exécute maintenant cette requête";
        Logger.logMethod(this.methodName, this.message);
        Node res = this.r.executeNodeQuery(req);
        this.message = "LA requête est bien exécuté et le résultat de cette exécution est stocké dans une variable res de type Node";
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
        this.message = "Une fois qu'on a vérifié que la variable res est non null. On continue par tester si le nom de Node obtenu est bien le nom qu'on attend qui est " + nnA;
        Logger.logMethod(this.methodName, this.message);
        if (res.getNodeName().equals(nnA)) {
            this.message = "Le nom du resultat obtenu est bien le nom attendu qui est " + nnA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "Le nom de l'élément obtenu est différent du nom attendu " + nnA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getNodeName(),nnA);
        this.message = "Une fois qu'on a vérifié que l'élément obtenu a bien comme nom le nom qu'on a attendu. On passe maintenant tester ces attributs.";
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
            this.message = "Le nombre d'attibutes de l'élément res est différente de " +
                            lA;
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(lA,res.getAttributes().getLength());
        this.message = "Une fois qu'on a vérifié que la variable res contient bien le nombre d'élements attendu " +
                        lA +
                        " on commence a tester chacun des ses " +
                        lA +
                        " attributs";
        Logger.logMethod(this.methodName, this.message);
        this.message = "Pour ce faire, on commence d'abord par l'attribut id.";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On teste si l'attribut id de l'élément obtenu res est bien " + iA;
        Logger.logMethod(this.methodName, this.message);
        if (iA.equals(res.getAttributes().getNamedItem("id").getNodeValue())) {
            this.message = "La valeur de l'attribut id de l'élément obtenu, res est bien égale à la valeur attendu " +
                            iA;
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id de l'élément obtenu, res est différent de la valeur attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getAttributes().getNamedItem("id").getNodeValue(),iA);
        this.message = "Une fois qu'on a vérifié que la valeur de l'attribut id est bien la valeur id attendu. On passe maintenant à vérifier si la valeur de l'attribut name est bien la valeur attendu " +
                        nA;
        Logger.logMethod(this.methodName, this.message);
        if (res.getAttributes().getNamedItem("name").getNodeValue().equals(nA)) {
            this.message = "La valeur de l'attribut name de l'élement obtenu, res est égale à la valeur name attendu";
            Logger.logMethod(this.methodName, this.message);
        } else {
            this.message = "La valeur de l'attribut id de l'élément obtenu, rest est différents de la valeur attendu";
            Logger.logError(this.methodName, this.message);
        }
        assertEquals(res.getAttributes().getNamedItem("name").getNodeValue(), nA);
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
    public void testExecuteNodeSetQuery() {
    }

    @Test
    public void testGetAllNodes() {
    }

    @Test
    public void testGetNbNodes() {
    }

    @Test
    public void testGenerateNodePathWithIndex() {
    }

    @Test
    public void testGetNode() {
    }

    @Test
    public void testGetNodeType() {
    }

    @Test
    public void testGetNodeId() {
    }

    @Test
    public void testGetNodeName() {
    }

    @Test
    public void testGetAllEdges() {
    }

    @Test
    public void testGetNbEdges() {
    }

    @Test
    public void testGenerateEdgePathFromIndex() {
    }

    @Test
    public void testGetEdge() {
    }

    @Test
    public void testGetEdgeId() {
    }

    @Test
    public void testGetEdgeType() {
    }

    @Test
    public void testGetEdgeSource() {
    }

    @Test
    public void testGetEdgeDestination() {
    }

    @Test
    public void testGetEdgeFrom() {
    }
}