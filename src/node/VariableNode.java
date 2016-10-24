package node;

import java.util.HashMap;

import command.utility.Variable;

public class VariableNode extends Node {
	private String myValue; 
	private String myName; //make this
	
	public VariableNode(String myName, String value, String name){
		super(myName);
		myValue = value; 
		myName = name;
	}
	
	public String getValue(){
		return myValue; 
	}
	
	public String getName(){
		return myName;
	}
	
	public String toString(){
		return "VariableNode" +"{"+this.getType()+"}";
	}
	
}
