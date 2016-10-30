package node;

import command.AbstractCommand;

//TODO: Mask in an interface
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
    public AbstractCommand createCommand () {
        return myCurrentNode.createCommand(this);
    }
    
}
