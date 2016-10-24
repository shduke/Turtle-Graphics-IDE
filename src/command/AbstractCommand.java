package command;

import java.util.List;
import java.util.Map;
import command.utility.Variable;

public abstract class AbstractCommand {
    private Map<String, Variable> myVariableMap;
    private List<AbstractCommand> myExpression;
    
    protected AbstractCommand(Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        myVariableMap = variableMap;
        myExpression = inputs;
    }
    
    public abstract double execute();

    protected List<AbstractCommand> getExpression () {
        return myExpression;
    }
    
    protected void setExpression(List<AbstractCommand> command) {
        myExpression = command;
    }
    
    protected Map<String, Variable> getVariableMap () {
        return myVariableMap;
    }
    
    protected AbstractCommand getFirstCommand() {
        return getCommandFromIndex(0);
    }
    
    protected AbstractCommand getCommandFromIndex(int index) {
        return myExpression.get(index);
    }
        
    @Override
    public String toString() {
        return this.getClass().getName().toUpperCase();
    }

}
