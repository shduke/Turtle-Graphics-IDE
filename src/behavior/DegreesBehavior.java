package behavior;

import java.util.List;
import java.util.function.Function;

public class DegreesBehavior extends UnaryBehavior<Double, Double> {
    private static final int ANGLE_INDEX = 0;
    
    public DegreesBehavior (Function<Double, Double> operation) {
        super(operation);
    }

    @Override
    protected <R> Double getInput1 (List<Double> arguments) {
        return Math.toRadians(arguments.get(ANGLE_INDEX));
    }
    
    @Override
    protected double evaluateToDouble (List<Double> arguments, Double result) {
        return result;
    }
    
}
