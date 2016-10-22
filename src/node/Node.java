package node;

public class Node {
	
	private String myType; 
	private String myValue; 
	
	public Node(String type, String value){
		myType = type; 
		myValue = value; 
	}
	
	public String getType(){
		return myType; 
	}
	
	public String getValue(){
		return myValue; 
	}
	
	
}
