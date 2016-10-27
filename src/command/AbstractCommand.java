package command;

import java.util.List;
import java.util.Map;
import command.utility.Variable;

public abstract class AbstractCommand {
    private List<AbstractCommand> myExpression;
    private Map<String, AbstractCommand> myArguments;
    
    protected AbstractCommand(List<AbstractCommand> inputs) {
        myExpression = inputs;
    }
    
    public abstract double execute();

    public List<AbstractCommand> getExpression () {
        return myExpression;
    }
    
    protected void setExpression(List<AbstractCommand> command) {
        myExpression = command;
    }
    
    protected AbstractCommand getFirstCommand() {
        return getCommandFromIndex(0);
    }
    
    protected AbstractCommand getCommandFromIndex(int index) {
        return myExpression.get(index);
    }
        
    protected void setArgument(String key, AbstractCommand value) {
        myArguments.put(key, value);
    }
    
    @Override
    public String toString() {
        return this.getClass().getName().toUpperCase();
    }

}
