package node;

public class ConstantNode extends Node {
	
	public ConstantNode(String type){
		super(type);
	}
	
	public String toString(){
		return "ConstantNode" +"{"+this.getType()+"}";
	}

}
