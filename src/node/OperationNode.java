package node;

import command.AbstractCommand;
import command.factory.OperationCommandFactory;
import exception.SyntaxException;

public class OperationNode extends Node {
        
        public OperationNode(String type){
                super(type);
        }
        
        public String toString(){
                return "OperationNode" +"{"+this.getType()+"}";
        }

    @Override
    public AbstractCommand createCommand(INode node) throws SyntaxException {
        try{
	    	OperationCommandFactory cmf = new OperationCommandFactory();
	        return cmf.createCommand(node);
        }
        catch(SyntaxException e){
        	throw e; 
        }
    }
        
}
