package behavior.unary;

import java.util.List;
import java.util.function.Function;
import command.AbstractCommand;

public class DegreesBehavior extends UnaryBehavior<Double, Double> {
    private static final int ANGLE_INDEX = 0;
    
    public DegreesBehavior (Function<Double, Double> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return Math.toRadians(getExecutionResult(ANGLE_INDEX));
    }
    
    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }
    
}
