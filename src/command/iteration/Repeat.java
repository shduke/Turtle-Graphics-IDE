package command.iteration;

import java.util.Map;
import behavior.IncrementIterationBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.IVariable;
import command.utility.Variable;

/**
 * @author Sean Hudson (srh50)
 */
public class Repeat extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    private static final int LIMIT_INDEX = 0;
    private static final int BODY_INDEX = 1;
    
    public Repeat (Map<String, IVariable> variableMap, AbstractCommand... arguments) {
        super(new IncrementIterationBehavior(variableMap, new Variable(variableMap::put, ":repcount"),
                                             new Constant(1.0),
                                             new Constant(arguments[LIMIT_INDEX].execute() + 1), 
                                             new Constant(1.0),
                                             arguments[BODY_INDEX]));
    }
    
}