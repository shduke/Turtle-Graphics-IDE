package behavior;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import command.AbstractCommand;

public class MovementBehavior extends UnaryBehavior<Double, Double>{
    private int DISTANCE_INDEX = 0;
    private int SCALEFACTOR_INDEX = 1;
    
    public MovementBehavior (Function<Double, Double> operation) {
        super(operation);
    }

    @Override
    protected <R> Double getInput1 (List<Double> arguments) {
        double blah = arguments.get(SCALEFACTOR_INDEX) * arguments.get(DISTANCE_INDEX);
        return arguments.get(SCALEFACTOR_INDEX) * arguments.get(DISTANCE_INDEX);
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Double result) {
        double blah = result * Math.signum(arguments.get(DISTANCE_INDEX));
        return result * Math.signum(arguments.get(DISTANCE_INDEX));
    }
    
    
    
}