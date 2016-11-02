package node;

import command.AbstractCommand;
import command.MultiLineCommandFactory;
import exception.SyntaxException;

public class BracketNode extends Node {
        
        public BracketNode(String type){
                super(type);
        }
        
        public String toString(){
                return "BracketNode" +"{"+this.getType()+"}";
        }

    @Override
    public AbstractCommand createCommand(INode node) throws SyntaxException {
       try{
	    	MultiLineCommandFactory cmf = new MultiLineCommandFactory();
	        return cmf.createCommand(node);
       }
       catch(SyntaxException e){
    	   throw e; 
       }
    }
        
}
