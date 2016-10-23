package command;

import java.util.List;
import java.util.Map;
import command.utility.Variable;

//TODO - put execution logic here
public abstract class CalculationCommand extends AbstractCommand {

    protected CalculationCommand (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
    }

}
