package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import behavior.nonexpression.MultiBehavior;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;

//TODO: have constant separate from the rest. Doesn't need behavior or input list.
public class FunctionInstance extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = -1;
    private String myKey;
    //private String myScope = "global";
    
    public FunctionInstance (Map<String, IVariable> variableMap, String key, AbstractCommand... parameterValues) {
        super(new VariableExecutionBehavior(variableMap, key));
        IntStream.rangeClosed(0, parameterValues.length-1).forEach(a -> variableMap.get(key).updateParameterValues(a, parameterValues[a]));
        myKey = key;
    }

//    public void setNumberOfParameters(int numberOfParameters) {
//        MY_NUMBER_OF_COMMAND_PARAMETERS = numberOfParameters;
//    }
    
    @Override
    public String toString() {
        return myKey;
    }

}
