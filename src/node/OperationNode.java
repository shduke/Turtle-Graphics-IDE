package node;

public class OperationNode extends Node {

	public OperationNode(String type){
		super(type);
	}
	
	public String toString(){
		return "OperationNode" +"{"+this.getType()+"}";
	}
}
