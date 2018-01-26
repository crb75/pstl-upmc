package modals.piccolo2d;

import java.util.HashMap;

public class node {
	
	private String name ; 
	private String id;
	private String type ;
	private HashMap<String, edge> relation ;
	
	public node(){
		
		relation = new HashMap<String, edge>();
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
	public HashMap<String, edge> getRelation() {
		return relation;
	}
	public void setRelation(HashMap<String, edge> relation) {
		this.relation = relation;
	}
	
	
}
