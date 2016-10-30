package node;

import command.AbstractCommand;

public interface INode {

    Node current();
    
    Node next();
    
    AbstractCommand createCommand();
}