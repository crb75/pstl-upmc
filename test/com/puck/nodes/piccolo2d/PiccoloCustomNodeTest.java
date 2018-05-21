package com.puck.nodes.piccolo2d;

import com.puck.utilities.Logger;
import org.piccolo2d.nodes.PText;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class PiccoloCustomNodeTest {

    private String methodName;
    private String message;
    private NodeContent nc;
    @BeforeMethod
    public void setUp(Method method) {
        this.methodName = method.getName();
        message = "Début de l'appel de la méthode";
        Logger.logMethod(methodName, message);
        this.message = "On commence par initialiser une variable nc de type NodeContent avec une variable de type PText qui contient le text \"Test avec une variable de type String initialisée a 'package' pour definir le type du noeud\"";
        Logger.logMethod(this.methodName, this.message);
        String nct1 = "Test";
        NodeContent nc = new NodeContent(new PText(nct1), "package");
        message = "La variable nc est bien été initialisé";
        Logger.logMethod(methodName, message);

    }

    @AfterMethod
    public void tearDown(Method method) {
        message = "Fin d'appel de la méthode";
        Logger.logMethod(methodName, message);
    }

    @Test
    public void testGetHiddenchildren() {

    }

    @Test
    public void testSetHiddenchildren() {
    }

    @Test
    public void testGetRect() {
    }

    @Test
    public void testGetContent() {
    }

    @Test(
            description = "Cette méthode permet de tester la méthode getMargin de la classe NodeContent." +
                    "La méthide getMargin de la classe NodeContent permet de retourner l'attribut margin de la classe." +
                    "Pour tester cette méthode on suit les démarches suivantes: " +
                    " - On initialise une variable nc de type NodeContent avec une variable de type PText qui contient le text \"Test\" et avec une variable de type String" +
                    "initialisée à 'package' pour définir le type de noeud." +
                    " - Puis on appel la méthode getMargin sur cette objet nc." +
                    " - On sait que l'attribut margun par défaut vaut 10." +
                    " - Pour conclure le teste on contrôle si la valeur retourné par la méthode est bien égale à 10.",
            groups = {"simple","getMargin","nodeContent"}
    )
    public void testGetMargin() {
        message = "On sait que la marge par défaut est 10. On teste maintenant si le résultat retourné par cet appel est bien 10";
        Logger.logMethod(methodName, message);
        if (nc.getMargin() == 10)
        {
            message = "La valeur retournée par cet appel de la méthode est égale à 10";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Les résultats ne correspondent pas. Il doit avoir un problème quelque part.";
            Logger.logError(methodName, message);
        }
        assertEquals(10, nc.getMargin());
    }

    @Test(
            description = "Cette méthode permet de tester la méthode setMargin(margin: int) de la classe NodeContent." +
                    "Cette méthode permet de changer la valeur de l'attribut margin de la classe NodeContent par la nouvelle " +
                    " valeur margin passée en paramètres. Pour tester cette méthide on commence par créer une variable nc de type NodeContent " +
                    "en passant une variable de type PText initialisé avec le String \"Test\" en paramètres ainsi que la chaîne de caractères 'package' pour" +
                    "définir le type du noeud. On appel en suite la méthode setMargin avec margin = 1000 qui permet de changer la valeur de l'attribut margin de 10 à 10000" +
                    "Pour tester si toute est bien passée, on test si la valeur retourné par la méthode getMargin() est égale à la nouvelle valeur de la margin.",
            groups = {"simple", "setMargin", "nodeContent"}
    )
    public void testSetMargin() {
        int margin = 10000;
        message = "On appelle en suite la méthode setMargin avec margin = 10000 qui permet de changer la valeur de l'attribut margin de 10 à 10000.";
        Logger.logMethod(methodName, message);
        nc.setMargin(margin);
        message = "La méthode setMargin est bien appelée avec la nouvelle valeur de margin " + margin;
        Logger.logMethod(methodName, message);
        message = "On teste maintenant si le résultat retourné par la méthode getMargin() sur cette nouvelle variable NodeContent est égale à la valeur de la nouvelle margin";
        Logger.logMethod(methodName, message);
        if (nc.getMargin() == margin)
        {
            message = "La valeur de la nouvelle margin correspond bien avec la valeur attendue " + margin;
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Les valeurs ne correspondent pas";
            Logger.logMethod(methodName, message);
        }
        assertEquals(margin, nc.getMargin());

    }

    @Test
    public void testGetidNode() {
    }

    @Test(
            description = "Cette méthode permet de tester la méthode toString() de la classe NodeContent, qui permet de donner une affichage en chaîne des caractères " +
                    "d'un objet de type NodeContent. Plus précisement, cette méthode retourne le text contenu dans cette objet. Pour tester cette méthode, on eommence par " +
                    "initialiser une variable nc de type NodeContent avec le text 'Test' et avec le type 'package'. Puis on appel la méthode toString() sur cette variable " +
                    "nc qui doit normalement retourner la chaîne de caracatères Test. On teste si la valeur retournée par l'appel de la méthode correspond bien avec le résultat attendu.",
            groups = {"simple", "toString", "nodeContent"}
    )
    public void testToString() {
        message = "Puis on appelle la méthode toString() sur cette variable nc qui doit normalement retourner la chaîne des caractères Test.";
        Logger.logMethod(methodName, message);
        String actual = nc.toString();
        message = "La méthode toString() est bien appelée sur la variable nc";
        Logger.logMethod(methodName, message);
        message = "On teste si la valeur retournée par l'appel de la méthode correspond bien avec le résultat attendu.";
        Logger.logMethod(methodName, message);
        if (actual.equals("Test"))
        {
            message = "Le résultat obtenu correspond bien avec le résultat attendu";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
            Logger.logError(methodName, message);
        }
        assertEquals("Test",nc.toString());
    }

    @Test
    public void testIsHidden() {
    }

    @Test
    public void testSetParentNode() {
    }

    @Test
    public void testGetParentNode() {
    }

    @Test
    public void testNewInstance() {
    }

    @Test
    public void testSetChilldren() {
    }

    @Test
    public void testGetChildren() {
    }

    @Test
    public void testGetAllChildren() {
    }

    @Test
    public void testGetAllChildrenCopy() {
    }

    @Test
    public void testGetHierarchy() {
    }

    @Test
    public void testShowChildren() {
    }

    @Test
    public void testHideChildren() {
    }

    @Test
    public void testToggleChildren() {
    }

    @Test
    public void testSetLayout() {
    }

    @Test
    public void testSetGridLayoutH() {
    }

    @Test
    public void testSetGridLayoutV() {
    }

    @Test
    public void testSetGridLayout() {
    }

    @Test
    public void testBevelOut() {
    }

    @Test
    public void testBevelIn() {
    }

    @Test
    public void testUpdateContentBoundingBoxes() {
    }

    @Test
    public void testUpdateTextBoundingBoxes() {
    }

    @Test
    public void testExpandAll() {
    }

    @Test
    public void testCollapseAll() {
    }

    @Test
    public void testGetHigherParent() {
    }

    @Test
    public void testGetAscendency() {
    }

    @Test
    public void testFocus() {
    }

    @Test
    public void testGetOutgoing() {
    }

    @Test
    public void testSetOutgoing() {
    }

    @Test
    public void testGetIngoing() {
    }

    @Test
    public void testSetIngoing() {
    }

    @Test
    public void testSetContent() {
    }
}