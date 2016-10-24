package command.control;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.utility.Variable;

public class IfElse extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    protected IfElse (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return getExpression().get(0).execute() != 0 ? getExpression().get(1).execute() : getExpression().get(2).execute();
    }

}