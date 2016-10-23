package command;

import java.util.List;
import java.util.Map;
import command.utility.Variable;

public abstract class AbstractCommand {
    private Map<String, Variable> myVariableMap;
    private List<AbstractCommand> myInputs;
    
    protected AbstractCommand(Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        myVariableMap = variableMap;
        myInputs = inputs;
    }
    
    public abstract double execute();

    protected List<AbstractCommand> getInputs () {
        return myInputs;
    }
    
    protected List<AbstractCommand> getVariableMap () {
        return myInputs;
    }
    

}
