package behavior;

import java.util.List;
import java.util.function.Function;

public class DoubleUnaryBehavior extends UnaryBehavior<Double, Double>{
    private static final int INPUT1_INDEX = 0;
    
    public DoubleUnaryBehavior (Function<Double, Double> operation) {
        super(operation);
    }

    @Override
    protected <R> Double getInput1 (List<Double> arguments) {
        return arguments.get(INPUT1_INDEX);
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Double result) {
        return result;
    }

}
