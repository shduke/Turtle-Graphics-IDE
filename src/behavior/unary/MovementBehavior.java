package behavior.unary;

import java.util.function.Function;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class MovementBehavior extends UnaryBehavior<Double, Double> {
    private static final int DISTANCE_INDEX = 0;
    private static final int SCALEFACTOR_INDEX = 1;

    public MovementBehavior (Function<Double, Double> operation, AbstractCommand ... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return getExecutionResult(SCALEFACTOR_INDEX) * getExecutionResult(DISTANCE_INDEX);
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result * Math.signum(getCachedValue(DISTANCE_INDEX));
    }

}
