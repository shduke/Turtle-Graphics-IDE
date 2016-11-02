package node;

import command.AbstractCommand;
import command.MultiLineCommandFactory;

public class BracketNode extends Node {
        
        public BracketNode(String type){
                super(type);
        }
        
        public String toString(){
                return "BracketNode" +"{"+this.getType()+"}";
        }

    @Override
    public AbstractCommand createCommand(INode node) {
        MultiLineCommandFactory cmf = new MultiLineCommandFactory();
        return cmf.createCommand(node);
    }
        
}
