package utilities.piccolo2d;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import modals.piccolo2d.Edge;
import modals.piccolo2d.Node;
import reader.xml.Reader;

public  class xmlToStructure {

	public xmlToStructure() {
		parseNode();
	}

	public HashMap<String, Node> parseNode() {
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
				HashMap<String, Edge> relation = n.getRelation();
				for (int j = 0; j < listEdge.getLength(); j++) {
					NamedNodeMap attrs = listEdge.item(j).getAttributes();
					String edgeId = "";
					String edgeDestId = "";
					String edgeSrcId ="";
					String edgetype ="";
					Edge Edge = new Edge() ;
					for (int k = 0; k < attrs.getLength(); k++) {
						Attr attribut = (Attr) (attrs.item(k));
						if (attribut.getName().equals("id")) {
							edgeId = attribut.getValue();
							Edge.setId(edgeId);
							
						}
						if (attribut.getName().equals("to")) {
							edgeDestId = attribut.getValue();
							Edge.setTo(edgeDestId);
							
						}
						if (attribut.getName().equals("from")) {
							edgeSrcId = attribut.getValue();
							Edge.setFrom(edgeSrcId);
							
						}
						if (attribut.getName().equals("type")) {
							edgetype = attribut.getValue();
							Edge.setType(edgetype);
							
						}
					}
					relation.put(edgeId, Edge);

				}
				n.setRelation(relation);
				// System.out.println(((Attr)(listEdge.item(0).getAttributes().item(0))).getValue());
			}

			listNode.put(n.getId(), n);

		}
		return listNode;
	}

	public static void main(String[] args) {
		HashMap<String, Node> listNode = new HashMap<String, Node>();
		listNode = new xmlToStructure().parseNode();
		System.out.println(listNode.get("c01").getRelation().get("e01").getTo());
	}

}
