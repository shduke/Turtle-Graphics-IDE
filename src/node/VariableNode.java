package node;

public class VariableNode extends Node {
	private String myValue; 
	private String myName; //make this
	
	public VariableNode(String myName, String value){
		super(myName);
		myValue = value; 
	}
	
	public String getValue(){
		return myValue; 
	}
	
	public String toString(){
		return "VariableNode" +"{"+this.getType()+"}";
	}
	
}
