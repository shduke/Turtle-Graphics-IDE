package node;

public class NameNode extends Node {

	
	public NameNode(String type){
		super(type);
	}
	
	public String toString(){
		return "NameNode" +"{"+this.getType()+"}";
	}
}
