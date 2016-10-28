package behavior;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import command.AbstractCommand;

public class MovementBehavior implements ICommandExecutionBehavior{
    private DoubleUnaryOperator myOperation;
    private int DISTANCE_INDEX = 0;
    private int SCALEFACTOR_INDEX = 1;

    
    public MovementBehavior(DoubleUnaryOperator operation) {
        myOperation = operation;
    }
    
    @Override
    public double executeCommand (List<Double> arguments) {
        return myOperation.applyAsDouble(arguments.get(SCALEFACTOR_INDEX) * arguments.get(DISTANCE_INDEX) * Math.signum(arguments.get(SCALEFACTOR_INDEX)));
    }

}
