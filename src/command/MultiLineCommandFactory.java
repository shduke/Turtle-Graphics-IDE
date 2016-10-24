package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class MultiLineCommandFactory extends CommandFactory {
    private static final String MULTILINE_TERMINATOR = "ENDMULTILINE";
    
    public MultiLineCommandFactory () {
        super();
    }

    @Override
    protected List<Class> getClassSpecificParameters () {  //TODO - should these be stored as instance vars?
        List<Class> classSpecificParameters = new ArrayList<Class>();
        return classSpecificParameters;
    }

    @Override
    protected List<Object> getClassSpecificArguments () {
        List<Object> classSpecificArguments = new ArrayList<Object>();
        return classSpecificArguments;
    }

    @Override
    protected List<Object> getClassCommandArgument (int numberOfParameters, Node node) {
        List<Object> classCommandArguments = new ArrayList<Object>();
        while (node.getType() != MULTILINE_TERMINATOR) {
            node = getNextCommandNode(node);
            AbstractCommand commandParameter = node.createCommand();
            classCommandArguments.add(commandParameter);
        }
        return classCommandArguments;
    }
    
    
    
}
