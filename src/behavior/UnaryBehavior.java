package behavior;

import java.util.List;
import java.util.function.Function;
//TODO - maybe refactor it so that it takes in a list of commands as its input
public abstract class UnaryBehavior<E,R> implements ICommandExecutionBehavior{
    Function<E,R> myOperation;
    
    UnaryBehavior(Function<E,R> operation) {
        myOperation = operation;
    }
    
    @Override
    public double executeCommand(List<Double> arguments) {
        return evaluateToDouble(arguments, myOperation.apply(getInput1(arguments)));
    }
    
    protected abstract <R> E getInput1(List<Double> arguments);

    protected abstract double evaluateToDouble(List<Double> arguments, R result);
}
