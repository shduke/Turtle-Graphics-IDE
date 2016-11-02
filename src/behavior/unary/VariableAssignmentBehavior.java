package behavior.unary;

import java.util.function.Function;
import command.AbstractCommand;
import command.utility.IVariable;

public class VariableAssignmentBehavior extends UnaryBehavior<String, IVariable> {
    private static final int EXPRESSION_KEY_INDEX = 0;    
    private static final int EXPRESSION_VALUE_INDEX = 1;    
    
    public VariableAssignmentBehavior(Function<String, IVariable> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> String getInput1 () {
        return getArgument(EXPRESSION_KEY_INDEX).toString();
    }

    @Override
    protected double evaluateToDouble (IVariable result) {
        result.setExpression(getArgument(EXPRESSION_VALUE_INDEX));
        return getExecutionResult(EXPRESSION_VALUE_INDEX);
    }

}