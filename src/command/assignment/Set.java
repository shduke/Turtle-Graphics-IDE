package command.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import behavior.binary.BooleanBinaryBehavior;
import behavior.unary.VariableAssignmentBehavior;
import command.AbstractCommand;
import command.utility.IVariable;
import command.utility.Variable;

public class Set extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Set (Map<String, IVariable> variableMap, AbstractCommand... arguments) {
        this(variableMap::get, arguments);
    }
    
    public Set(Function<String,IVariable> operation, AbstractCommand... arguments) {
        super(new VariableAssignmentBehavior(operation, arguments));
    }
    
}