package puck.gui.plan;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class PlanReader {

	private String filePath;
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private File fileXML;
	private Document xml;
	private Element root;
	private XPathFactory xpf;
	private XPath path;

	/* Permet d'initialiser un objet de type Reader */
	public PlanReader(String path) {
		try {
			this.filePath = path;
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = this.factory.newDocumentBuilder();
			this.fileXML = new File(this.filePath);
			this.xml = this.builder.parse(fileXML);
			this.root = this.xml.getDocumentElement();
			this.xpf = XPathFactory.newInstance();
			this.path = xpf.newXPath();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public String executeStringQuery(String query) {
		String expression = query;
		String str = "";
		try {
			str = path.evaluate(expression, root);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return str;
	}

	/*
	 * Méthode permet d'exécuter un requête XPath dont le tpe de retour est un
	 * Boolean sur le fichier XML
	 */
	public Boolean executeBooleanQuery(String query) {
		try {
			return (Boolean) path.evaluate(query, root, XPathConstants.BOOLEAN);
		} catch (XPathExpressionException e) {
			e.printStackTrace();

		}
		return false;
	}

	/*
	 * Méthode permet d'exécuter un requête XPath dont le type de retour est un
	 * Node sur le fichier XML
	 */
	public Node executeNodeQuery(String query) {
		try {
			return (Node) path.evaluate(query, root, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();

		}
		return null;
	}

	/*
	 * Méthode permet d'exécuter un requête XPath dont le type de retour est un
	 * NodeList sur le fichier XML
	 */
	public NodeList executeNodeSetQuery(String query) {
		try {
			return (NodeList) path.evaluate(query, root, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();

		}
		return null;
	}
	// retrouv� toute les commande de refactoring
	public NodeList getAllNodesRename() {
		return this.executeNodeSetQuery("//Rename");
	}
	
	public String getNodeId(int nodeIndex) {
		String query = PlanReader.generateNodePathWithIndex("Rename",nodeIndex)+"/@id";
		return this.executeStringQuery(query);
	}
	
	public String getNodeNewName(int nodeIndex) {
		String query = PlanReader.generateNodePathWithIndex("Rename",nodeIndex)+"/@newName";
		return this.executeStringQuery(query);
	}
	
	public int getNbNodesRename() {
		return this.getAllNodesRename().getLength();
	}
	
	public static String generateNodePathWithIndex(String nodeType, int index) {
		return "//"+nodeType+"[" + index + "]";
	}
}
