package behavior.unary;

import java.util.List;
import java.util.function.Function;
import command.AbstractCommand;

public class ConditionalUnaryBehavior extends UnaryBehavior<Double, Boolean>{
    private int IS_TRUE_INDEX = 0;
    private int TRUE_BRANCH_INDEX = 1;
    private int FALSE_BRANCH_INDEX = 2;
    
    public ConditionalUnaryBehavior (Function<Double, Boolean> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return getExecutionResult(IS_TRUE_INDEX);
    }

    @Override
    protected double evaluateToDouble (Boolean result) {
        return result ? getExecutionResult(TRUE_BRANCH_INDEX) : getExecutionResult(FALSE_BRANCH_INDEX);
    }
     
}