package command.iteration;

import java.util.Map;
import behavior.IncrementIterationBehavior;
import command.AbstractCommand;
import command.utility.IVariable;

/**
 * @author Sean Hudson (srh50)
 */
public class For extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    private static final int PARAMETER_INDEX = 0;
    private static final int BODY_INDEX = 1;
    private static final int VARIABLE_SUB_INDEX = 0;
    private static final int START_SUB_INDEX = 1;
    private static final int STOP_SUB_INDEX = 2;
    private static final int INCREMENT_SUB_INDEX = 3;
    
    public For (Map<String, IVariable> variableMap, AbstractCommand... arguments) {
        super(new IncrementIterationBehavior(variableMap, arguments[PARAMETER_INDEX].getCommandArguments().get(VARIABLE_SUB_INDEX), 
                                             arguments[PARAMETER_INDEX].getCommandArguments().get(START_SUB_INDEX),
                                             arguments[PARAMETER_INDEX].getCommandArguments().get(STOP_SUB_INDEX),
                                             arguments[PARAMETER_INDEX].getCommandArguments().get(INCREMENT_SUB_INDEX),
                                             arguments[BODY_INDEX]));
    }
    
}