package reader.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Reader {
	
	private String filePath;
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private File fileXML;
	private Document xml;
	private Element root;
	private XPathFactory xpf;
	private XPath path;
	
	/* Permet d'initialiser un objet de type Reader */
	public Reader (String path) {
		try {
			this.filePath = path;
			this.factory = DocumentBuilderFactory.newInstance();
		    this.builder = this.factory.newDocumentBuilder();
		    this.fileXML = new File(this.filePath);
		    this.xml = this.builder.parse(fileXML);
		    this.root = this.xml.getDocumentElement();
		    this.xpf = XPathFactory.newInstance();
		    this.path = xpf.newXPath();
		} catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Fonction permet d'exécuter un requête XPath dont le type de retour est un String sur le fichier XML */
	private String executeStringQuery(String query) {
            String expression = query;
	        String str = "";
			try {
				str = (String)path.evaluate(expression, root);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return str;
	}
	
	/* Méthode permet de retourner l'attribut type d'un noeud dont l'index est passé en paramètres */
	public String getNodeType(int nodeIndex) {
		String query = "//Node["+nodeIndex+"]/@type";
		return this.executeStringQuery(query);
	}
	
	/* Méthode permet de retourner l'attribut id d'un noeud dont l'index est passé en paramètres */
	public String getNodeId(int nodeIndex) {
		String query = "//Node["+nodeIndex+"]/@id";
		return this.executeStringQuery(query);
	}
	
	/* Méthode permet de retourner l'attribut name d'un noeud dont l'index est passé en paramètres */
	public String getNodeName(int nodeIndex) {
		String query = "//Node["+nodeIndex+"]/@name";
		return this.executeStringQuery(query);
	}
	
	/* Méthode qui permet de retourner l'attribut id d'un edge dont l'index est passé en paramètres */
	public String getEdgeId(int edgeIndex) {
		String query = "//Edge["+edgeIndex+"]/@id";
		return this.executeStringQuery(query);
	}
	
	/* Méthode qui permet de retourner l'attribut type d'un edge dont l'index est passé en paramètres */
	public String getEdgeType(int edgeIndex) {
		String query = "//Edge["+edgeIndex+"]/@type";
		return this.executeStringQuery(query);
	}

	/* Méthode qui permet de retourner l'attribut source d'un edge dont l'index est passé en paramètres */
	public String getEdgeSource(int edgeIndex) {
		String query = "//Edge["+edgeIndex+"]/@src";
		return this.executeStringQuery(query);
	}

	/* Méthode qui permet de retourner l'attribut destination d'un edge dont l'index est passé en paramètres */
	public String getEdgeDestination(int edgeIndex) {
		String query = "//Edge["+edgeIndex+"]/@dest";
		return this.executeStringQuery(query);
	}
	
	
}