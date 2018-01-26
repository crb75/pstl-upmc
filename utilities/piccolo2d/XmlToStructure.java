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

	public Map<String, Node> parseNode() {
		HashMap<String, Node> listNode = new HashMap();

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
					String edgeId = "";
					String edgeDestId = "";
					String edgeSrcId ="";
					String edgetype ="";
					Edge edge = new Edge() ;
					for (int k = 0; k < attrs.getLength(); k++) {
						Attr attribut = (Attr) (attrs.item(k));
						if (attribut.getName().equals("id")) {
							edgeId = attribut.getValue();
							edge.setId(edgeId);
							
						}
						if (attribut.getName().equals("to")) {
							edgeDestId = attribut.getValue();
							edge.setTo(edgeDestId);
							
						}
						if (attribut.getName().equals("from")) {
							edgeSrcId = attribut.getValue();
							edge.setFrom(edgeSrcId);
							
						}
						if (attribut.getName().equals("type")) {
							edgetype = attribut.getValue();
							edge.setType(edgetype);
							
						}
					}
					relation.put(edgeId, edge);

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
