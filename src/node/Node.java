package node;

import java.util.stream.Stream;
import command.AbstractCommand;

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
	
	public Node getNext() {
	    return myNext;
	}
	
	public String toString(){
		return "Node" +"{"+this.getType()+"}";
	}
	
	public abstract AbstractCommand createCommand(INode node);
	
}
