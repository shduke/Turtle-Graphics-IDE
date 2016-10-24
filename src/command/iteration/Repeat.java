package command.iteration;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.ParameterCommand;
import command.assignment.Set;
import command.utility.Variable;

public class Repeat extends ParameterCommand {

    protected Repeat (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        getVariableMap().put(getFirstCommand().toString(), createVariable());
        return 0;
    }

}