package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class ConstantCommandFactory extends CommandFactory {
    private double myValue;
    
    public ConstantCommandFactory (double value) {
        super();
        myValue = value;
    }

    @Override //TODO - Constants don't need to take in any expressions, re-order hierarchy, ask if subclassing based on parameters is bad?
    protected List<Class> getClassSpecificParameters () {  //TODO - should these be stored as instance vars? Probably, then I can iterate over them and reduce code
        List<Class> classSpecificParameters = new ArrayList<Class>();
        classSpecificParameters.add(double.class);
        return classSpecificParameters;
    }

    @Override
    protected List<Object> getClassSpecificArguments () {
        List<Object> classSpecificArguments = new ArrayList<Object>();
        classSpecificArguments.add(myValue);
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