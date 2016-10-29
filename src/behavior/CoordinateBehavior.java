package behavior;

import java.util.List;
import java.util.function.BiFunction;

public class CoordinateBehavior extends BinaryBehavior<Double, Double> {
    private int XCOORDINATE_INDEX = 0;
    private int YCOORDINATE_INDEX = 1;
    
    
    public CoordinateBehavior(BiFunction<Double,Double,Double> operation) {
        super(operation);
    }

    @Override
    protected <R> Double getInput1 (List<Double> arguments) {
        return arguments.get(XCOORDINATE_INDEX);
    }

    @Override
    protected <R> Double getInput2 (List<Double> arguments) {
        return arguments.get(YCOORDINATE_INDEX);
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Double result) {
        return result;
    }

}
