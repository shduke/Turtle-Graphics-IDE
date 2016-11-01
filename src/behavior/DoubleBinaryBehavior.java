package behavior;

import java.util.List;
import java.util.function.BiFunction;

public class DoubleBinaryBehavior extends BinaryBehavior<Double, Double> {
    private int INPUT1_INDEX = 0;
    private int INPUT2_INDEX = 1;
    
    
    public DoubleBinaryBehavior(BiFunction<Double,Double,Double> operation) {
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
    protected double evaluateToDouble (List<Double> arguments, Double result) {
        return result;
    }

}
