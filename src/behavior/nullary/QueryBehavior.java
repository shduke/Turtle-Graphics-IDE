package behavior.nullary;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import behavior.ICommandExecutionBehavior;
import command.AbstractCommand;
//TODO - maybe refactor it so that it takes in a list of commands as its input
public abstract class QueryBehavior<R> implements ICommandExecutionBehavior{
    Supplier<R> myOperation;
    
    QueryBehavior(Supplier<R> operation) {
        myOperation = operation;
    }
    
    @Override
    public double executeCommand() {
        return evaluateToDouble(myOperation.get());
    }

    @Override
    public List<AbstractCommand> getArguments () {
        return null;
    }
    
    protected abstract double evaluateToDouble(R result);
}