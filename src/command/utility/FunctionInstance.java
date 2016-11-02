package command.utility;

import java.util.Map;
import java.util.stream.IntStream;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;


public class FunctionInstance extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = -1;
    private String myKey;

    public FunctionInstance (Map<String, IVariable> variableMap,
                             String key,
                             AbstractCommand ... parameterValues) {
        super(new VariableExecutionBehavior(variableMap, key));
        IntStream.rangeClosed(0, parameterValues.length - 1)
                .forEach(a -> variableMap.get(key).updateParameterValues(a, parameterValues[a]));
        myKey = key;
    }

    @Override
    public String toString () {
        return myKey;
    }

}
