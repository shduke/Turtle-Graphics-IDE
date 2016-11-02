package behavior.unary;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import command.AbstractCommand;
import command.utility.IVariable;
import command.utility.Variable;


public class FunctionAssignmentBehavior extends UnaryBehavior<String, IVariable> {
    private static final int EXPRESSION_KEY_INDEX = 0;
    private static final int EXPRESSION_PARAMETER_INDEX = 1;
    private static final int EXPRESSION_VALUE_INDEX = 2;
    private IVariable[] myParameters;

    public FunctionAssignmentBehavior (Function<String, IVariable> operation,
                                       Map<String, IVariable> variableMap,
                                       AbstractCommand ... arguments) {
        super(operation, arguments);
        myParameters =
                arguments[EXPRESSION_PARAMETER_INDEX].getCommandArguments().stream()
                        .map(p -> (new Variable(variableMap::put, p.toString())))
                        .toArray(IVariable[]::new);
        Arrays.asList(myParameters).stream().forEach(p -> p.execute());
    }

    @Override
    protected <R> String getInput1 () {
        return getArgument(EXPRESSION_KEY_INDEX).toString();
    }

    @Override
    protected double evaluateToDouble (IVariable result) {
        result.setExpression(getArgument(EXPRESSION_VALUE_INDEX), myParameters);
        return 1;
    }

}
