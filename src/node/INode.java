package node;

import command.AbstractCommand;
import exception.SyntaxException;


public interface INode {

    Node current ();

    Node next ();

    AbstractCommand createCommand () throws SyntaxException;
}
