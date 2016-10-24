package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import command.AbstractCommand;

public class Variable extends AbstractCommand{
    String myVariableName;
    
    public Variable(Map<String, Variable> variableMap, List<AbstractCommand> inputs, String variableName) {
        super(variableMap, inputs);
        myVariableName = variableName.toString();
    }
    
    @Override
    public String toString() {
        return myVariableName;
    }

    @Override
    public double execute () { //execute every command in the queue
        return getFirstCommand().execute();
    }
    
    public void setExpressione(AbstractCommand expression) {
        setExpression(Arrays.asList(expression));
    }
        
}
