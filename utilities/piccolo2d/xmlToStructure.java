package utilities.piccolo2d;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import modals.piccolo2d.edge;
import modals.piccolo2d.node;
import reader.xml.Reader;

public  class xmlToStructure {

	public xmlToStructure() {
		parseNode();
	}

	public HashMap<String, node> parseNode() {
		HashMap<String, node> listNode = new HashMap();

		Reader reader = new Reader("./mongraph.xml");
		int listLength = reader.getNbNodes();
		for (int i = 1; i <= listLength; i++) {
			node n = new node();
			n.setId(reader.getNodeId(i));
			n.setName(reader.getNodeName(i));
			n.setType(reader.getNodeType(i));
			NodeList listEdge = reader.getEdgeFrom(n.getId());
			if (listEdge.getLength() != 0) {
				// dest-id / type
				HashMap<String, edge> relation = n.getRelation();
				for (int j = 0; j < listEdge.getLength(); j++) {
					NamedNodeMap attrs = listEdge.item(j).getAttributes();
					String edgeId = "";
					String edgeDestId = "";
					String edgeSrcId ="";
					String edgetype ="";
					edge edge = new edge() ;
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
				// System.out.println(((Attr)(listEdge.item(0).getAttributes().item(0))).getValue());
			}

			listNode.put(n.getId(), n);

		}
		return listNode;
	}

	public static void main(String[] args) {
		HashMap<String, node> listNode = new HashMap<String, node>();
		listNode = new xmlToStructure().parseNode();
		System.out.println(listNode.get("c01").getRelation().get("e01").getTo());
	}

}
