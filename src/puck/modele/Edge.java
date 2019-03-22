package puck.modele;



public class Edge {
	private String type ; 
	private String id;
	private String from ;
	private String to ;
	
	
	public Edge(){
		this.type = "";
		this.id = "";
		this.from = "";
		this.to = "";
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
}
