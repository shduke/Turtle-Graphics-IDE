package command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import command.utility.Variable;

public abstract class ParameterCommand extends AbstractCommand {
    HashMap<String, Variable> myParameterMap;
    
    protected ParameterCommand(Map<String, Variable> variableMap, List<AbstractCommand> inputs) {//myParameterMap = inputs[1]
        super(variableMap, inputs);
    }

    protected AbstractCommand getCommand(String commandKey) {
        return myParameterMap.get(commandKey);
    }

    protected Variable createVariable(AbstractCommand expression, String variableName) {
        return new Variable(getVariableMap(), Arrays.asList(expression), variableName);
    }
    
    @Override
    public abstract double execute();
    
    
}
