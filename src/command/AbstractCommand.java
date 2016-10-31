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
public abstract class AbstractCommand {
    protected List<AbstractCommand> myArguments;//TODO: temporary until move commands into execution
    private ICommandExecutionBehavior myCommandExecutionBehavior;

    protected AbstractCommand (ICommandExecutionBehavior commandExecutionBehavior, AbstractCommand... arguments) {
        myCommandExecutionBehavior = commandExecutionBehavior;
        myArguments = Arrays.asList(arguments); // Need to preserve insertion order
    }

    protected List<Double> executeCommands() {
        return myArguments.stream().map(AbstractCommand::execute).collect(Collectors.toList());
    }
    
    public double execute () {
        return myCommandExecutionBehavior.executeCommand();
    }

    @Override
    public String toString () {
        return this.getClass().getName().toUpperCase();
    }

}
