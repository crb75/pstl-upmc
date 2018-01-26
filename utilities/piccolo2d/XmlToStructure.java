package utilities.piccolo2d;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;


import modals.piccolo2d.Edge;
import modals.piccolo2d.Node;
import reader.xml.Reader;

public  class XmlToStructure {

	public XmlToStructure() {
		parseNode();
	}
	
enum AttributTypes {
	id,to,from,type;
}

private static Edge parseAttributs(NamedNodeMap attrs) {
	String edgeId = "";
	String edgeDestId = "";
	String edgeSrcId ="";
	String edgetype ="";
	
	Edge edge = new Edge() ;
	for (int k = 0; k < attrs.getLength(); k++) {
		Attr attribut = (Attr) (attrs.item(k));
		switch (attribut.getName()) {
			case "id":
				edgeId = attribut.getValue();
				edge.setId(edgeId);
				break;
			case "to":
				edgeDestId = attribut.getValue();
				edge.setTo(edgeDestId);
				break;
			case "from":
				edgeSrcId = attribut.getValue();
				edge.setFrom(edgeSrcId);
				break;
			case "type":
				edgetype = attribut.getValue();
				edge.setType(edgetype);
				break;
	
			default:
				break;
		}
	}
	return edge;
}

	public Map<String, Node> parseNode() {
		HashMap<String, Node> listNode = new HashMap<>();

		Reader reader = new Reader("./mongraph.xml");
		int listLength = reader.getNbNodes();
		for (int i = 1; i <= listLength; i++) {
			Node n = new Node();
			n.setId(reader.getNodeId(i));
			n.setName(reader.getNodeName(i));
			n.setType(reader.getNodeType(i));
			NodeList listEdge = reader.getEdgeFrom(n.getId());
			if (listEdge.getLength() != 0) {
				// dest-id / type
				HashMap<String, Edge> relation = new HashMap<>(n.getRelation());
				for (int j = 0; j < listEdge.getLength(); j++) {
					NamedNodeMap attrs = listEdge.item(j).getAttributes();
					Edge edge = XmlToStructure.parseAttributs(attrs);
					relation.put(edge.getId(), edge);
				}
				n.setRelation(relation);
			}

			listNode.put(n.getId(), n);

		}
		return listNode;
	}

	public static void main(String[] args) {
		HashMap<String, Node> listNode;
		listNode = new HashMap<>(new XmlToStructure().parseNode());
	}

}
