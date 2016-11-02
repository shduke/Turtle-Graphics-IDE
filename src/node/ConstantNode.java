package node;

import command.AbstractCommand;
import command.ConstantCommandFactory;
import exception.SyntaxException;

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
        public AbstractCommand createCommand(INode node) throws SyntaxException {
            try{
	        	ConstantCommandFactory cmf = new ConstantCommandFactory(myValue);
	            return cmf.createCommand(node);
            }
            catch(SyntaxException e){
            	throw e; 
            }
        }
}
