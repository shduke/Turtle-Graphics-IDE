package behavior.unary;

import java.util.function.Function;
import behavior.AbstractCommandBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public abstract class UnaryBehavior<E, R> extends AbstractCommandBehavior {
    Function<E, R> myOperation;

    UnaryBehavior (Function<E, R> operation, AbstractCommand ... arguments) {
        super(arguments);
        myOperation = operation;
    }

    @Override
    public double executeCommand () {
        return evaluateToDouble(myOperation.apply(getInput1()));
    }

    protected abstract <R> E getInput1 ();

    protected abstract double evaluateToDouble (R result);
}
