package com.puck.reader.xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class Reader {
	
	private String filePath;
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private File fileXML;
	private Document xml;
	private Element root;
	private XPathFactory xpf;
	private XPath path;
	private static String loggerName = "reader.xml";
	
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
		} catch(ParserConfigurationException|SAXException|IOException e) {
			Logger.getLogger(Reader.loggerName).log(Level.SEVERE, "Exception catched in Reader constructor method", e);
		}
	}
	
	/* Méthode permet d'exécuter un requête XPath dont le type de retour est un String sur le fichier XML */
	private String executeStringQuery(String query) {
            String expression = query;
	        String str = "";
			try {
				str = path.evaluate(expression, root);
			} catch (XPathExpressionException e) {
				Logger.getLogger(Reader.loggerName).log(Level.SEVERE, "Exception catched in executeStringQuery method", e);
			}
	        return str;
	}
	
	/* Méthode permet d'exécuter un requête XPath dont le tpe de retour est un Boolean sur le fichier XML */
	public Boolean executeBooleanQuery(String query) {
		try {
			return (Boolean)path.evaluate(query, root, XPathConstants.BOOLEAN);
		} catch (XPathExpressionException e) {

			Logger.getLogger(Reader.loggerName).log(Level.SEVERE, "Exception catched in executeBooleanQuery method", e);
		}
		return false;
	}
	
	/* Méthode permet d'exécuter un requête XPath dont le type de retour est un Node sur le fichier XML */
	private Node executeNodeQuery(String query) {
		try {
			return (Node)path.evaluate(query, root, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			Logger.getLogger(Reader.loggerName).log(Level.SEVERE, "Exception catched in executeNodeQuery method", e);
		}
		return null;
	}
	
	/* Méthode permet d'exécuter un requête XPath dont le type de retour est un NodeList sur le fichier XML */
	private NodeList executeNodeSetQuery(String query) {
		try {
			return (NodeList)path.evaluate(query, root, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			Logger.getLogger(Reader.loggerName).log(Level.SEVERE, "Exception catched in executeNodeSetQuery method", e);
		}
		return null;
	}
	
	/* Méthodes pour les éléments de type Node */
	
	/* Méthode permet de retrouver tous les éléments de type Node à partir du fichier XML qu'on a rechargé */
	public NodeList getAllNodes() {
		return this.executeNodeSetQuery("//node");
	}
	
	/* Méthode permet de retourner le nombre total des éléments Node dans le document XML*/
	public int getNbNodes() {
		return this.getAllNodes().getLength();
	}
	
	private static String generateNodePathWithIndex (int index) {
		return "//node[" + index + "]";
	}
	
	/* Méthode permet de retourner un élément de type Node dont l'index est passé en paramètres*/
	public Node getNode(int nodeIndex) {
		return this.executeNodeQuery(Reader.generateNodePathWithIndex(nodeIndex));
	}
	
	/* Méthode permet de retourner l'attribut type d'un noeud dont l'index est passé en paramètres */
	public String getNodeType(int nodeIndex) {
		String query = Reader.generateNodePathWithIndex(nodeIndex) + "/@type";
		return this.executeStringQuery(query);
	}
	
	/* Méthode permet de retourner l'attribut id d'un noeud dont l'index est passé en paramètres */
	public String getNodeId(int nodeIndex) {
		String query = Reader.generateNodePathWithIndex(nodeIndex)+"/@id";
		return this.executeStringQuery(query);
	}
	
	/* Méthode permet de retourner l'attribut name d'un noeud dont l'index est passé en paramètres */
	public String getNodeName(int nodeIndex) {
		String query = Reader.generateNodePathWithIndex(nodeIndex)+"/@name";
		return this.executeStringQuery(query);
	}
	
	/* Fin des méthodes pour les éléments de type Node*/
	
	/* Méthodes pour les éléments de type Edge */
	
	/* Méthode permet de retourner tous les éléments de type Edge à partir du fichier XML */
	public NodeList getAllEdges() {
		return this.executeNodeSetQuery("//edge");
	}
	
	/* Méthode permet de retourner le nombre des éléments Edge dans le fichier XML */
	public int getNbEdges() {
		NodeList nl = this.executeNodeSetQuery("//edge");
		return (nl==null)?-1:nl.getLength();
	}
	
	private static String generateEdgePathFromIndex(int index) {
		return "//edge["+index+"]";
	}
	/* Méthode permet de retourner un élément de type Edge dont l'index est passé en paramètres*/
	public Node getEdge(int edgeIndex) {
		return this.executeNodeQuery(Reader.generateEdgePathFromIndex(edgeIndex));
	}
	
	/* Méthode qui permet de retourner l'attribut id d'un edge dont l'index est passé en paramètres */
	public String getEdgeId(int edgeIndex) {
		String query = Reader.generateEdgePathFromIndex(edgeIndex)+"/@id";
		return this.executeStringQuery(query);
	}
	
	/* Méthode qui permet de retourner l'attribut type d'un edge dont l'index est passé en paramètres */
	public String getEdgeType(int edgeIndex) {
		String query = Reader.generateEdgePathFromIndex(edgeIndex)+"/@type";
		return this.executeStringQuery(query);
	}

	/* Méthode qui permet de retourner l'attribut source d'un edge dont l'index est passé en paramètres */
	public String getEdgeSource(int edgeIndex) {
		String query = Reader.generateEdgePathFromIndex(edgeIndex)+"/@src";
		return this.executeStringQuery(query);
	}

	/* Méthode qui permet de retourner l'attribut destination d'un edge dont l'index est passé en paramètres */
	public String getEdgeDestination(int edgeIndex) {
		String query = Reader.generateEdgePathFromIndex(edgeIndex)+"/@dest";
		return this.executeStringQuery(query);
	}
	public NodeList getEdgeFrom(String id){
		String query = "//edge[@src=\""+id+"\"]";
		return this.executeNodeSetQuery(query);
	
	}
	
	
	
}