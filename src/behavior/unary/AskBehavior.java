package behavior.unary;

import java.util.List;
import java.util.function.Function;
import command.AbstractCommand;

public class AskBehavior extends MultiCursorUnaryBehavior{
    private static final int COMMAND_INDEX = 0;
    private static final int TELL_INDEX = 1;
    
    public AskBehavior (Function<List<Double>, Double> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }
    
    @Override
    protected double evaluateToDouble (Double result) {
        getExecutionResult(COMMAND_INDEX);
        getExecutionResult(TELL_INDEX);
        return getCachedValue(COMMAND_INDEX);
    }

}
