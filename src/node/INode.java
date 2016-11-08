package node;

/**
 * @author Sean Hudson (srh50)
 */
import command.AbstractCommand;
import exception.SyntaxException;


public interface INode {

    /**
     * Gets the current node
     * @return
     */
    Node current ();

    /**
     * Gets the next node
     * @return
     */
    Node next ();

    /**
     * Creates the command
     * @return
     * @throws SyntaxException
     */
    AbstractCommand createCommand () throws SyntaxException;
}
