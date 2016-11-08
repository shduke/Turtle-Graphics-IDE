package command.assignment;

import java.util.Map;
import java.util.function.Function;
import behavior.unary.VariableAssignmentBehavior;
import command.AbstractCommand;
import command.utility.IVariable;

/**
 * @author Sean Hudson (srh50)
 */
public class Set extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Set (Map<String, IVariable> variableMap, AbstractCommand ... arguments) {
        this(variableMap::get, arguments);
    }

    public Set (Function<String, IVariable> operation, AbstractCommand ... arguments) {
        super(new VariableAssignmentBehavior(operation, arguments));
    }

}
