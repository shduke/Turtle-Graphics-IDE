package command.assignment;

import java.util.HashMap;
import java.util.Map;
import behavior.binary.BooleanBinaryBehavior;
import behavior.unary.VariableAssignmentBehavior;
import command.AbstractCommand;
import command.utility.Variable;

public class Set extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Set (Map<String, Variable> variableMap, AbstractCommand... arguments) {
        super(new VariableAssignmentBehavior(variableMap::get, arguments));
    }
    
}