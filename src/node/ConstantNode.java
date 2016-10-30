package node;

import command.AbstractCommand;
import command.ConstantCommandFactory;

public class ConstantNode extends Node {
	double myValue;
    
	public ConstantNode(String type, double value){
		super(type);
		myValue = value;
	}
	
	public String toString(){
		return "ConstantNode" +"{"+myValue+"}";
	}

        @Override
        public AbstractCommand createCommand(INode node) {
            ConstantCommandFactory cmf = new ConstantCommandFactory(myValue);
            return cmf.createCommand(node);
        }
}
