package behavior.unary;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import command.AbstractCommand;

public class MovementBehavior extends UnaryBehavior<Double, Double>{
    private int DISTANCE_INDEX = 0;
    private int SCALEFACTOR_INDEX = 1;
    
    public MovementBehavior (Function<Double, Double> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return getExecutionResult(SCALEFACTOR_INDEX) * getExecutionResult(DISTANCE_INDEX);
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result * Math.signum(getExecutionResult(DISTANCE_INDEX));
    }
     
    
}