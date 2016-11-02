package command.utility;

import java.util.Map;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;


public class Instance extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private String myKey;

    public Instance (Map<String, IVariable> variableMap,
                     String key,
                     AbstractCommand ... parameterValues) {
        super(new VariableExecutionBehavior(variableMap, key));

    }

    @Override
    public String toString () {
        return myKey;
    }

}
