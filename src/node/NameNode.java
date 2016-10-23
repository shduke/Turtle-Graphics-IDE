package node;

public class NameNode extends Node {

	private String myName;
	
	public NameNode(String type, String name){
		super(type);
		myName = name; 
	}
	
	public String getName(){
		return myName; 
	}
}
