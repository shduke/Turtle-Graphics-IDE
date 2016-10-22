package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParameterCommand extends AbstractCommand {
    HashMap<String, Variable> myParameterMap;
    
    ParameterCommand(Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
    }

    protected AbstractCommand getCommand(String commandKey) {
        return myParameterMap.get(commandKey);
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
