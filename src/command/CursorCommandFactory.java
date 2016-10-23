package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class CursorCommandFactory extends CommandFactory {
    private Cursor myCursor;
    
    public CursorCommandFactory (Cursor cursor) {
        super();
        myCursor = cursor;
    }

    @Override
    protected List<Class> getClassSpecificParameters () {  //TODO - should these be stored as instance vars?
        List<Class> classSpecificParameters = new ArrayList<Class>();
        classSpecificParameters.add(Cursor.class);
        return classSpecificParameters;
    }

    @Override
    protected List<Object> getClassSpecificArguments () {
        List<Object> classSpecificArguments = new ArrayList<Object>();
        classSpecificArguments.add(myCursor);
        return classSpecificArguments;
    }

    @Override
    protected List<Object> getClassCommandArgument (int numberOfParameters, Node node) {
        List<Object> classCommandArguments = new ArrayList<Object>();
        for (int i = 0; i < numberOfParameters; i++) {
            node = getNextCommandNode(node);
            AbstractCommand commandParameter = node.createCommand();
            classCommandArguments.add(commandParameter);
        }
        return classCommandArguments;
    }
    
    
    
}
