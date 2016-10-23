package node;

public class ConstantNode extends Node {
	private int myValue;
	
	public ConstantNode(String type, int value){
		super(type);
		myValue = value; 
	}
	
	public int getValue(){
		return myValue; 
	}
	
}
