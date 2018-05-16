package com.puck.nodes.piccolo2d;

import com.puck.utilities.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class EdgeTest {
    private Edge e;
    private String message;
    private String methodName;

    @BeforeMethod
    public void setUp(Method method) {
        this.methodName = method.getName();
        this.message = "Debut de la teste de methode";
        Logger.logMethod(this.methodName, this.message);
        this.message = "On commence par creer une variable e de type Edge en l'initialisant par le constructeur Edge";
        Logger.logMethod(this.methodName, this.message);
        e = new Edge();
        this.message = "La variable e de type Edge est bien initialisee";
        Logger.logMethod(this.methodName, this.message);
    }

    @AfterMethod
    public void tearDown(Method method) {
        this.methodName = method.getName();
        this.message = "Fin de teste de la methode";
        Logger.logMethod(this.methodName, this.message);
    }

    @Test(
            description = "Cette méthode permet de tester la méthode getType de la classe Edge, qui permet d'obtenir l'attribut type." +
                    "Pour tester cette méthode, on commence par initialiser une variable e de type Edge" +
                    "Puis on appel la méthode getType sur la variable e." +
                    "Par défaut l'attribut type d'une objet de type Edge est la chaîne de caractères vide." +
                    "On teste alors si la valeur par défaut est égale à la valeur retournée par l'appel de la méthode getType sur la variable e.",
            groups = {"simple", "edge", "getEdge"}
    )
    public void testGetType() {
        message = "Par défaut la valeur de l'attribut type d'une objet de type Edge est la chaîne des caractères vide";
        Logger.logMethod(methodName, message);
        message = "On appelle maintent la méthode getType() sur la variable e";
        Logger.logMethod(methodName, message);
        String actual = e.getType();
        message = "La valeur retourné par cette méthode est " + actual;
        Logger.logMethod(methodName, message);
        message = "On teste maintenant si la valeur retourné par cette méthode correspond avec le résultat attendu";
        Logger.logMethod(methodName, message);
        if ("".equals(actual))
        {
            message = "Le résultat retourné par l'appel de la méthode correspond bien avec le résultat attendu";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Le résultat attendu ne correspond pas avec le résultat obtenu";
            Logger.logError(methodName, message);
        }
        assertEquals("", actual);
    }

    @Test(
            description = "Cette méthode permet de tester la méthode setType(type: String) de la classe Edge qui permet de changer la valeur de l'attribut type." +
                    "Pour tester cette méthode on commence par initialiser une variable e de type Edge." +
                    "Puis on appel la méthode setType avec le paramètre type = \"Test type\" qui nous permet de changer le type de l'objet de \"\" à \"Test type\"" +
                    "Puis on teste si le résultat retourné par l'appel de la méthode getType() sur l'objet manipulé retourne bien la valeur \"Test type\".",
            groups = {"simple", "edge", "setType"}
    )
    public void testSetType() {
        String type = "Test type";
        message = "Puis on appelle la méthode setType sur cette variable e avec le paramètre type=" + type + " qui permet de changer la valeur de l'attribut type de \"\" à  \"" + type + "\"";
        Logger.logMethod(methodName, message);
        e.setType(type);
        message = "La méthode setType est bien appelée";
        Logger.logMethod(methodName, message);
        message = "On teste maintenant le résultat retourné par la méthode getType() sur la variable e manipulé retourne bien le résultat attendu " + type;
        Logger.logMethod(methodName, message);
        boolean result = type.equals(e.getType());
        if (result)
        {
            message = "Le changement de la valeur de l'attribut type est bien passé";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Les valeues ne correspondent pas il y a un problème quelque part";
            Logger.logError(methodName, message);
        }
        assertEquals(true,result);
    }

    @Test(
            description = "Cette méthode permet de tester la méthode getId() de la classe Edge qui permet de retourner la valeur de l'attribut id." +
                    "Pour tester cette méthode on commence par initialiser une variable e de type Edge." +
                    "Puis on appelle la méthode getId() sur cette variable r" +
                    "Par défaaut l'attribut id vaut la chaîne de caractères vide" +
                    "On teste le résultat obtenu par l'appel de la méthode correspond bien avec le résultat attendu la chaîne des caraxtères vide",
            groups = {"simple", "edge", "getId"}
    )
    public void testGetId() {
        message = "La valeur par défaut de la valeur de l'attribut id d'une objet de type Edge est la chaîne des caractères vide";
        Logger.logMethod(methodName, message);
        message = "On appelle la méthode getId() sur la variable e";
        Logger.logMethod(methodName, message);
        String actual = e.getId();
        message = "La méthode getId() est bien appellé sur la variable e et le résultat obtenu est  \"" + actual + "\"";
        Logger.logMethod(methodName, message);
        message = "On teste maintenant si le résultat obtenu par l'appel de la méthode correspond bien avec le résultat attendu";
        Logger.logMethod(methodName, message);
        if ("".equals(actual))
        {
            message = "Le résultat attendu correspond bien avec le résultat obtenu";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Les deux résultats ne se correspondent pas";
            Logger.logError(methodName, message);
        }
        assertEquals("",actual);
    }

    @Test(
            description = "Cette méthode permet de tester la méthode setId(id:String) de la classe Edge qui permet de changer la valeur de l'attribut id d'une objet de type Edge." +
            "Pour tester cette méthode on commence par initialiser une variable e de type Edge" +
            "Puis on appelle la méthode setId(\"id\") qui est censé de changer la valeur de l'attribut id avec la chaîne des caractères id" +
            "On teste si le changement est bien fait avec un appel de la méthode getId() sur la variable e manipulée",
            groups = {"simple", "setId", "edge"}
    )
    public void testSetId() {
        message = "On appelle maintenant la méthode setId avec le paramètre id=\"id\" qui permet de changer la valeur de l'attribut id à chaîne des caractères id.";
        Logger.logMethod(methodName, message);
        e.setId("id");
        message = "La méthode setId(\"id\") est bien été appelé sur la variable e";
        Logger.logMethod(methodName, message);
        message = "On teste maintenant si le résultat de l'appel de la méthode getId() sur cette variable e manipulé correspond bien avec la valeur de nouvel attribut id qu'on vient de passer en paramètre";
        Logger.logMethod(methodName, message);
        if ("id".equals(e.getId()))
        {
            message = "Le changement de la valeur de l'attribut id est bien passé";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Ces deux valeurs ne correspondent pas";
            Logger.logError(methodName, message);
        }
        assertEquals("id", e.getId());
    }

    @Test(
            description = "Cette méthode permet de tester la méthode getFrom() de la classe Edge qui permet de retourner la valeur de l'attribut from" +
                    "Pour tester cette méthode, on commence par initialiser une variable e de type Edge" +
                    "La valeur par défaut de l'attribut from est une chaîne de caractères vide" +
                    "On appelle la méthode getFrom() sur cette variable e" +
                    "Et on teste si la valeur obtenu par l'appel de cette méthode correspond bien avec le résultat attendu, la chaîne des caractères vide",
            groups = {"simple","edge","getFrom"}
    )
    public void testGetFrom() {
        message = "La valeur par défaut de l'attribut from est la chaîne des caractères vide";
        Logger.logMethod(methodName, message);
        message = "On appelle la méthode getFrom() sur cette variable e";
        Logger.logMethod(methodName, message);
        String actual = e.getFrom();
        message = "Appel de la méthode getFrom a bien été faite. La valeur retourné par cet appel est \"" + "\"";
        Logger.logMethod(methodName, message);
        message = "On teste maintenant le résultat attendu correspond bien avec le résultat obtenu";
        Logger.logMethod(methodName, message);
        if ("".equals(actual))
        {
            message = "Les deux résultats se correspondent";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Ces deux résultats ne correspondent pas";
            Logger.logError(methodName, message);
        }
        assertEquals("", e.getFrom());
    }

    @Test(
            description = "Cette méthode permet de tester la méthode setFrom(from:String) de la classe Edge qui permet de changer la valeur de l'attribut from par la nouvelle valeur passée en paramètres" +
                    "Pour tester cette méthode on commence par initialiser une variable e de type Edge." +
                    "On appelle la méthode setFrom(\"from\") sur la variable e qui permet de changer la valeur de l'attribut from avec la chaîne des caractères \"from\"" +
                    "On contrôle maintenant si le changement de la valeur de l'attribut from est bien passé en testant si la valeur retourné pas l'appel de méthode getFrom() correspond bien avec la nouvelle valeur de l'attribut from qu'on vient de passer en paramètres",
            groups = {"simple","edge","setFrom"}
    )
    public void testSetFrom() {
        message = "On appelle la méthode setFrom(\"from\") sur la variable e qui permet de changer la valeur de l'attribut from avec la chaîne des caractères \"from\"";
        Logger.logMethod(methodName, message);
        e.setFrom("from");
        message = "L'appel de la méthode setFrom(\"from\") est bien passée";
        Logger.logMethod(methodName, message);
        message = "On contrôle maintenant si le changement de la valeur de l'attribut from est bien passé en testant si la valeur retourné pas l'appel de méthode getFrom() correspond bien avec la nouvelle valeur de l'attribut from qu'on vient de passer en paramètres";
        Logger.logMethod(methodName, message);
        String actual = e.getFrom();
        if ("from".equals(actual))
        {
            message = "La nouvelle valeur de l'attribut from correspond bien avec le résultat attendu. Donc le changement est bien passée";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "La valeur de la nouvelle attribut from ne correspond pas avec le résultat attendu. Il y a eu un problème lors de la changement de valeur";
            Logger.logError(methodName, message);
        }
        assertEquals("from", e.getFrom());
    }

    @Test(
            description = "Cette méthode permet de tester la méthode getTo() de la classe Edge qui permet de retourner l'attribut to." +
                    "Pour tester cette méthode on commence par initialiser une variable e de type Edge" +
                    "La valeur par défaut de l'attribut to est une chaîne de caractères vide" +
                    "On appelle la méthode getTo() sur la variable e" +
                    "On teste si le résultat obtenu correspond bien avec le résultat attendu",
            groups = {"edge","simple","getTo"}
    )
    public void testGetTo() {
        message = "La valeur par défaut de l'attribut to est une chaîne de caractères vide";
        Logger.logMethod(methodName, message);
        message = "On appelle la méthode getTo() sur la variable e";
        Logger.logMethod(methodName, message);
        String actual = e.getTo();
        message = "Le résultat de l'appel est " + actual;
        Logger.logMethod(methodName, message);
        message = "On teste si le résultat obtenu correspond bien avec le résultat attendu";
        Logger.logMethod(methodName, message);
        if (actual.equals(""))
        {
            message = "Le résultat attendu correspond bien avec le résultat obtenu";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
            Logger.logMethod(methodName, message);
        }

        assertEquals("", e.getTo());
    }

    @Test(
            description = "Cette méthode permet de tester la méthode setTo(to:String) qui permet de changer la valeur de l'attribut to avec la nouvelle valeur passée en paramètres" +
                    "Pour tester cette méthode, on commence par initialiser une variable e de type Edge" +
                    "Puis on appelle la méthode setTo(\"to\") sur cette variable r, qui nous permet de changer la valeur de l'attribut to avec la chaîne de caractères \"to\"" +
                    "Au final, pour tester si le changement est bien passé, on teste si le résultat de l'appel de la méthode getTo() sur la nouvelle variable e correspond bien avec le résutlat attendu \"to\" "
    )
    public void testSetTo() {
        message = "Puis on appelle la méthode setTo(\"to\") sur cette variable r, qui nous permet de changer la valeur de l'attribut to avec la chaîne de caractères \"to\"";
        Logger.logMethod(methodName, message);
        e.setTo("to");
        message = "L'appel de la méthode setTo(\"to\") est bien passé";
        Logger.logMethod(methodName, message);
        message = "Au final, pour tester si le changement est bien passé, on teste si le résultat de l'appel de la méthode getTo() sur la nouvelle variable e correspond bien avec le résutlat attendu \"to\"";
        Logger.logMethod(methodName, message);
        if ("to".equals(e.getTo()))
        {
            message = "Le résultat obtenu correspond bien avec le résultat attendu";
            Logger.logMethod(methodName, message);
        }
        else
        {
            message = "Le résultat obtenu ne correspond pas avec le résultat attendu";
            Logger.logError(methodName, message);
        }
        assertEquals("to", e.getTo());
    }
}