package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import command.utility.Variable;

//TODO: watch out for multiple parameter order of execution. Maybe use a stack
public abstract class AbstractCommand {
    private List<AbstractCommand> myArguments;

    protected AbstractCommand () {
        myArguments = new ArrayList<AbstractCommand>(); // Need to preserve insertion order
    }

    protected void setArgument(AbstractCommand ... command) {
        myArguments.addAll(Arrays.asList(command));
    }
    
    protected List<Double> executeCommands() {
        return myArguments.stream().map(AbstractCommand::execute).collect(Collectors.toList());
    }
    
    public abstract double execute ();

    @Override
    public String toString () {
        return this.getClass().getName().toUpperCase();
    }

}
