package behavior;

import java.util.List;
import java.util.function.BiFunction;
//TODO - maybe refactor it so that it takes in a list of commands as its input
public abstract class BinaryBehavior<E,R> implements ICommandExecutionBehavior{
    BiFunction<E,E,R> myOperation;
    
    BinaryBehavior(BiFunction<E,E,R> operation) {
        myOperation = operation;
    }
    
    @Override
    public double executeCommand(List<Double> arguments) {
        return evaluateToDouble(arguments, myOperation.apply(getInput1(arguments), getInput2(arguments)));
    }
    
    protected abstract <R> E getInput1(List<Double> arguments);
    
    protected abstract <R> E getInput2(List<Double> arguments);

    protected abstract double evaluateToDouble(List<Double> arguments, R result);
}
