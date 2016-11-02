package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import behavior.ICommandExecutionBehavior;
import command.utility.Variable;

//TODO: watch out for multiple parameter order of execution. Maybe use a stack
public abstract class AbstractCommand implements ICommand{
    private ICommandExecutionBehavior myCommandExecutionBehavior;

    protected AbstractCommand (ICommandExecutionBehavior commandExecutionBehavior) {
        myCommandExecutionBehavior = commandExecutionBehavior;
    }
    
    public double execute () {
        return myCommandExecutionBehavior.executeCommand();
    }

    protected void setCommandExecutionBehavior(ICommandExecutionBehavior commandExecutionBehavior) {
        myCommandExecutionBehavior = commandExecutionBehavior;
    }
    
    public List<AbstractCommand> getCommandArguments() {
        return myCommandExecutionBehavior.getArguments();
    }
    
    public List<ICommand> getInnerCommandArguments() {
        List<ICommand> myInnerCommands = new ArrayList<ICommand>();
        myInnerCommands.addAll(myCommandExecutionBehavior.getArguments());
        return myInnerCommands;
    }
    
    
    @Override
    public String toString () {
        return this.getClass().getName().toUpperCase();
    }

}
