package node;

public abstract class Node {
	
	public Node myNext;
	protected String myType; 
	
	public Node(String type){
		myType = type; 
	}
	
	public String getType(){
		return myType; 
	}
	
	public void setNext(Node next){
		myNext = next; 
	}
	
}
