package command.assignment;

import java.util.HashMap;
import java.util.Map;
import behavior.binary.BooleanBinaryBehavior;
import behavior.unary.FunctionAssignmentBehavior;
import behavior.unary.VariableAssignmentBehavior;
import command.AbstractCommand;
import command.utility.IVariable;
import command.utility.Variable;

public class To extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;
    
    public To (Map<String, IVariable> variableMap, AbstractCommand... arguments) {
        super(new FunctionAssignmentBehavior(variableMap::get, variableMap, arguments));
    }
    
}