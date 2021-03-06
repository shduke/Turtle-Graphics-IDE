package node;

import command.AbstractCommand;
import exception.SyntaxException;

/**
 * @author Sean Hudson (srh50)
 */
public class NodeIterator implements INode{
    private Node myCurrentNode;
    
    public NodeIterator(Node headNode) {
        myCurrentNode = headNode;
    }
    
    public Node current() {
        return myCurrentNode;
    }
    
    public Node next() {
        myCurrentNode = myCurrentNode.myNext;
        return current();
    }

    @Override
    public AbstractCommand createCommand () throws SyntaxException {
       try{
    	return myCurrentNode.createCommand(this);
       }
       catch(SyntaxException e){
    	   throw e; 
       }
    }
    
}
