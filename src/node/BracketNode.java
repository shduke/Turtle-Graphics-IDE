package node;

public class BracketNode extends Node{
	public String myBracket;
	
	public BracketNode(String type, String bracket){
		super(type);
		myBracket = bracket; 
	}
	
	public String getValue(){
		return myBracket;  
	}


}
