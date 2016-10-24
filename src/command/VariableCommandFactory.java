package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Cursor;
import node.Node;

public class VariableCommandFactory extends CommandFactory {
    private String myVariableName;
    
    public VariableCommandFactory (String variableName) {
        super();
        myVariableName = variableName;
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
        for (int i = 0; i < numberOfParameters; i++) {
            node = getNextCommandNode(node);
            AbstractCommand commandParameter = node.createCommand();
            classCommandArguments.add(commandParameter);
        }
        return classCommandArguments;
    }
    
    
    
    
}