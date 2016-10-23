package node;

public class VariableNode extends Node {
	private String myValue; 
	
	public VariableNode(String myName, String value){
		super(myName);
		myValue = value; 
	}
	
	public String getValue(){
		return myValue; 
	}
	
}
