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
		return "ConstantNode" +"{"+this.getType()+"}";
	}

        @Override
        public AbstractCommand createCommand() {
            ConstantCommandFactory cmf = new ConstantCommandFactory(myValue);
            return cmf.createCommand(this);
        }
}
