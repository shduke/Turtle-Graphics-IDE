package behavior.binary;

import java.util.List;
import java.util.function.BiFunction;
import behavior.AbstractCommandBehavior;
import command.AbstractCommand;
//TODO - maybe refactor it so that it takes in a list of commands as its input
public abstract class BinaryBehavior<E,U,R> extends AbstractCommandBehavior {
    BiFunction<E,U,R> myOperation;
    
    BinaryBehavior(BiFunction<E,U,R> operation, AbstractCommand... arguments) {
        super(arguments);
        myOperation = operation;
    }
    
    @Override
    public double executeCommand() {
        return evaluateToDouble(myOperation.apply(getInput1(), getInput2()));
    }
    
    protected abstract <R> E getInput1();
    
    protected abstract <R> U getInput2();

    protected abstract double evaluateToDouble(R result);
}
