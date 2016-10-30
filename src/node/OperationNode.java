package node;

import command.AbstractCommand;
import command.OperationCommandFactory;

public class OperationNode extends Node {
        
        public OperationNode(String type){
                super(type);
        }
        
        public String toString(){
                return "OperationNode" +"{"+this.getType()+"}";
        }

    @Override
    public AbstractCommand createCommand(INode node) {
        OperationCommandFactory cmf = new OperationCommandFactory();
        return cmf.createCommand(node);
    }
        
}
