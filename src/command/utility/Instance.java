package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import behavior.nonexpression.MultiBehavior;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;

//TODO: have constant separate from the rest. Doesn't need behavior or input list.
public class Instance extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private String myKey;
    //private String myScope = "global";
    
    public Instance (Map<String, IVariable> variableMap, String key, AbstractCommand... parameterValues) {
        super(new VariableExecutionBehavior(variableMap, key));

    }

    
    @Override
    public String toString() {
        return myKey;
    }

}
