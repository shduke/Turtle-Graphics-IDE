package behavior.unary;

import java.util.function.Function;
import command.AbstractCommand;


public class DoubleUnaryBehavior extends UnaryBehavior<Double, Double> {
    private static final int INPUT1_INDEX = 0;

    public DoubleUnaryBehavior (Function<Double, Double> operation, AbstractCommand ... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return getExecutionResult(INPUT1_INDEX);
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }

}
