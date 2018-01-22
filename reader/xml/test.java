package reader.xml;

public class test {
	  public static void main(String[] args) {
	     Reader r = new Reader("./mongraph.xml");
	     
	     /* On teste les fonctions getters */
	     /* On teste d'abord pour les éléments Node*/
	     /* On teste le cas dont l'index du noeud correspond bien a un noeud */
	     System.out.println("Type du premier noeud : " + r.getNodeType(1));
	     System.out.println("Id du premier noeud : " + r.getNodeId(1));
	     System.out.println("Name du premier noeud : " + r.getNodeName(1));
	     
	     /* On teste le cas dont l'index du noeud ne correspond à aucun noeud */
	     System.out.println("Type du centième noeud : " + r.getNodeType(100));
	     System.out.println("Id du centième noeud : " + r.getNodeId(100));
	     System.out.println("Name du centième noeud : " + r.getNodeName(100));

	     /* On teste pour les éléments Edge */
	     /* On teste pour les cas dont l'index de l'Edge corresponde bien a un élément de type Edge */
	     System.out.println("Id du premier edge : " + r.getEdgeId(1));
	     System.out.println("Type du premier edge : " + r.getEdgeType(1));
	     System.out.println("Source du premier edge : " + r.getEdgeSource(1));
	     System.out.println("Destination du premier edge : " + r.getEdgeDestination(1));
	     
	     /* On teste pour les cas dont l'index de l'Edge ne correspond à aucun élément de type Edge */
	     System.out.println("Id du centième Edge : " + r.getEdgeId(100));
	     System.out.println("Type du centième Edge : " + r.getEdgeType(100));
	     System.out.println("Source du centième Edge : " + r.getEdgeSource(100));
	     System.out.println("Destination du centième Edge : " + r.getEdgeDestination(100));
	     
	     /*On teste les fonctions prédicats */
	     System.out.println("2ème élément Node existe? " + r.executeBooleanQuery("//Node[2]"));
	     System.out.println("100ème élément Node existe? " + r.executeBooleanQuery("//Node[100]"));
	     
	     /* On teste les fonctions getters */
	     System.out.println("Premier élément de type Node : " + r.getNode(1));
	     System.out.println("Centième élément de type Node : " + r.getNode(100));
	     System.out.println("Premier élément de type Edge : " + r.getEdge(1));
	     System.out.println("Centième élément de type Edge : " + r.getEdge(100));
	     
	     /* On teste les fonctions pour détecter les nombres */
	     System.out.println("Le nombre des éléments Node dans le graph : " + r.getNbNodes());
	     System.out.println("Le nombre des éléments Edge dans le graph : " + r.getNbEdges());

	   }   
}
