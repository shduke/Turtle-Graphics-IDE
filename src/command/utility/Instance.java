package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import behavior.binary.VariableInitializationBehavior;
import behavior.nonexpression.MultiBehavior;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;

//TODO: have constant separate from the rest. Doesn't need behavior or input list.
public class Instance extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private String myKey;
    //private String myScope = "global";
    
    public Instance (Map<String, Variable> variableMap, String key, AbstractCommand... parameterValues) {
          this(variableMap, key);

    }
    
    public Instance (Map<String, Variable> variableMap, String key) {
        super(new VariableExecutionBehavior(variableMap, key));
    }

    
    @Override
    public String toString() {
        return myKey;
    }

}
