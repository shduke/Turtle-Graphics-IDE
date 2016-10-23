package command.utility;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import command.AbstractCommand;

public class Variable extends AbstractCommand{
    Queue<AbstractCommand> myCommand;
    Queue<AbstractCommand> myParameters;
    String myVariableName;
    
    Variable(Map<String, Variable> variableMap, List<AbstractCommand> inputs, Queue<AbstractCommand> command, String variableName) {
        super(variableMap, inputs);
        myCommand = command;
        myVariableName = variableName.toString();
    }
    
    @Override
    public String toString() {
        return myVariableName;
    }

    @Override
    public double execute () { //execute every command in the queue
        // TODO Auto-generated method stub
        return 0;
    }
}
