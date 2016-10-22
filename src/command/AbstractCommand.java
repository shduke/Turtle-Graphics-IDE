package command;

import java.util.List;
import java.util.Map;

public abstract class AbstractCommand {
    private Map<String, Variable> myVariableMap;
    private List<AbstractCommand> myInputs;
    
    public AbstractCommand(Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
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
