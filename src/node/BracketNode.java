package node;

public class BracketNode extends Node{
	
	public BracketNode(String type){
		super(type);
	}
	
	public String toString(){
		return "BracketNode" +"{"+this.getType()+"}";
	}
	
	
}
