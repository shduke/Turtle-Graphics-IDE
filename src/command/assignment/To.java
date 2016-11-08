package command.assignment;

import java.util.Map;
import behavior.unary.FunctionAssignmentBehavior;
import command.AbstractCommand;
import command.utility.IVariable;

/**
 * @author Sean Hudson (srh50)
 */
public class To extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;

    public To (Map<String, IVariable> variableMap, AbstractCommand ... arguments) {
        super(new FunctionAssignmentBehavior(variableMap::get, variableMap, arguments));
    }

}
