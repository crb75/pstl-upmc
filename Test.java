import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

   public static void main(String[] args) {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try {
         DocumentBuilder builder = factory.newDocumentBuilder();
         File fileXML = new File("./test.xml");
         Document xml = builder.parse(fileXML);
         Element root = xml.getDocumentElement();
         XPathFactory xpf = XPathFactory.newInstance();
         XPath path = xpf.newXPath();
                   
        String expression = "/company/staff[1]";
        String str = (String)path.evaluate(expression, root);
        System.out.println(str);
        System.out.println("-------------------------------------");
        
        expression = "/company/staff[2]";
        str = (String)path.evaluate(expression, root);        
        System.out.println(str); 
        System.out.println("-------------------------------------");

        expression = "//firstname";
      //On cast le résultat en Nodelist
        NodeList list = (NodeList)path.evaluate(expression, root, XPathConstants.NODESET);
        int nodesLength = list.getLength();

        //Parcours de la boucle
        for(int i = 0 ; i < nodesLength; i++){
           Node n = list.item(i);
           System.out.println(n.getNodeName() + " : " + n.getTextContent());
           
           //ici, en changeant de point de départ et avec cette expression
           //nous allons récupérer la liste des nœuds feuille 
           //du nœud branche actuellement utilisé
           expression = "feuille";
           path.compile(expression);
           //Nous prenons donc comme point de départ
           NodeList list2 = (NodeList)path.evaluate(expression, n, XPathConstants.NODESET);
           int nodesLength2 = list2.getLength();
           
           //nous parcourons maintenant la liste des nœuds feuille du nœud branche en cours
           for(int j = 0; j < nodesLength2; j++){
              Node n2 = list2.item(j);
              System.out.println(n2.getNodeName() + " : " + n2.getTextContent());
           }
           System.out.println("--------------------------------------");   
        }
        
        expression = "//staff";
        str = (String)path.evaluate(expression, root);        
        System.out.println(str); 
        System.out.println("-------------------------------------");
        
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      }
   }   
}