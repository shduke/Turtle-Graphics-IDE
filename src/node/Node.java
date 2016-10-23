package node;

public class Node {
	
	private String myType; 
	private String myValue; 
	private Node myNext; 
	
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
	
	@Override 
	public String toString(){
		String toReturn = "";
		toReturn +="{"+myType+","+myValue+"}";
		return toReturn; 
	}
	
	
}
