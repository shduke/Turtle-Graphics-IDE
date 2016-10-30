package behavior;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
//TODO - maybe refactor it so that it takes in a list of commands as its input
public abstract class QueryBehavior<R> implements ICommandExecutionBehavior{
    Supplier<R> myOperation;
    
    QueryBehavior(Supplier<R> operation) {
        myOperation = operation;
    }
    
    @Override
    public double executeCommand(List<Double> arguments) {
        return evaluateToDouble(arguments, myOperation.get());
    }
    
    protected abstract double evaluateToDouble(List<Double> arguments, R result);
}
