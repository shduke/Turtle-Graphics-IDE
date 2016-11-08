package command.factory;

import command.AbstractCommand;
import exception.SyntaxException;
import node.INode;

/**
 * @author Sean Hudson (srh50)
 */
public interface ICommandFactory {
    /**
     * Creates the command
     * @param node
     * @return
     * @throws SyntaxException
     */
    AbstractCommand createCommand(INode node) throws SyntaxException;
}
