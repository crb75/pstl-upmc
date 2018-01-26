package modals.piccolo2d;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	private String name ; 
	private String id;
	private String type ;
	private HashMap<String, Edge> relation ;
	
	public Node(){
		
		relation = new HashMap<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, Edge> getRelation() {
		return relation;
	}
	public void setRelation(Map<String, Edge> relation) {
		this.relation = new HashMap<>(relation);
	}
	
	
}
