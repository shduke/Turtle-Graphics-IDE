package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class MultiLineCommandFactory extends CommandFactory { 
    private static final String MULTILINE_TERMINATOR = "]";
    
    public MultiLineCommandFactory () {
        super();
    }

    @Override
    protected void getClassCommandArgument (int numberOfParameters, Node node) { //TODO - condense into operation factory
        while (node.getType() != MULTILINE_TERMINATOR) {
            node = getNextCommandNode(node);
            AbstractCommand commandParameter = node.createCommand();
            addCommandArguments(commandParameter);
        }
    }
    
    
    
}
