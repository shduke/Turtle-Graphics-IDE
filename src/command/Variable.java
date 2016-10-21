package command;

import java.util.Queue;

public class Variable extends AbstractCommand{
    Queue<AbstractCommand> myCommand;
    String myVariableName;
    
    Variable(String variableName, Queue<Variable> parameters, Queue<AbstractCommand> command) {
        myCommand = command;
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
