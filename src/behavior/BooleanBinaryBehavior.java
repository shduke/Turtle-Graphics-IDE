package behavior;

import java.util.List;
import java.util.function.BiFunction;

public class BooleanBinaryBehavior extends BinaryBehavior<Double, Boolean> {
    private static final int INPUT1_INDEX = 0;
    private static final int INPUT2_INDEX = 1;
    
    public BooleanBinaryBehavior (BiFunction<Double, Double, Boolean> operation) {
        super(operation);
    }

    @Override
    protected <R> Double getInput1 (List<Double> arguments) {
        return arguments.get(INPUT1_INDEX);
    }

    @Override
    protected <R> Double getInput2 (List<Double> arguments) {
        return arguments.get(INPUT2_INDEX);
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Boolean result) {
        return result ? 1 : 0;
    }

}
