package node;

public abstract class Node {
	
	public Node myNext;
	protected String myType; 
	
	public Node(String type){
		myType = type; 
		myNext = null; 
	}
	
	public String getType(){
		return myType; 
	}
	
	public void setNext(Node next){
		myNext = next; 
	}
	
	public String toString(){
		return "Node" +"{"+this.getType()+"}";
	}
	
}
