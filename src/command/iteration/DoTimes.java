package command.iteration;

import java.util.HashMap;
import java.util.Map;
import behavior.IncrementIterationBehavior;
import behavior.binary.BooleanBinaryBehavior;
import behavior.unary.FunctionAssignmentBehavior;
import behavior.unary.VariableAssignmentBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.IVariable;
import command.utility.Variable;

public class DoTimes extends AbstractCommand {//TODO: refactor into parameter object
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    private static final int PARAMETER_INDEX = 0;
    private static final int BODY_INDEX = 1;
    private static final int VARIABLE_SUB_INDEX = 0;
    private static final int STOP_SUB_INDEX = 1;
    
    public DoTimes (Map<String, IVariable> variableMap, AbstractCommand... arguments) {
        super(new IncrementIterationBehavior(variableMap, arguments[PARAMETER_INDEX].getCommandArguments().get(VARIABLE_SUB_INDEX), 
                                             new Constant(1.0),
                                             arguments[PARAMETER_INDEX].getCommandArguments().get(STOP_SUB_INDEX),
                                             new Constant(1.0),
                                             arguments[BODY_INDEX]));
    }
    
}