package behavior.binary;

import java.util.List;
import java.util.function.BiFunction;
import command.AbstractCommand;

public class BooleanBinaryBehavior extends BinaryBehavior<Double, Boolean> {
    private static final int INPUT1_INDEX = 0;
    private static final int INPUT2_INDEX = 1;
    
    public BooleanBinaryBehavior (BiFunction<Double, Double, Boolean> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return getExecutionResult(INPUT1_INDEX);
    }

    @Override
    protected <R> Double getInput2 () {
        return getExecutionResult(INPUT2_INDEX);
    }

    @Override
    protected double evaluateToDouble (Boolean result) {
        return result ? 1 : 0;
    }

}
