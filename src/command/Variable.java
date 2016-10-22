package command;

import java.util.Queue;

public class Variable extends AbstractCommand{
    Queue<AbstractCommand> myCommand;
    Queue<AbstractCommand> myParameters;
    String myVariableName;
    
    Variable(VariableName variableName, Queue<VariableName> parameters, Queue<AbstractCommand> command) {
        myCommand = command;
        myVariableName = variableName.toString();
    }
    
    @Override
    public String toString() {
        return myVariableName;
    }

    @Override
    double execute () { //execute every command in the queue
        // TODO Auto-generated method stub
        return 0;
    }
}
