package command.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import command.AbstractCommand;
import command.ParameterCommand;
import command.utility.Variable;

public class Set extends ParameterCommand{
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    Set(Map<String, Variable> variableMap, List<AbstractCommand> inputs) { //inputs[NameCommand, MultiLine, MultiLine ] change inputs to commandParameters
        super(variableMap, inputs);
    }
    
    @Override
    public double execute () {
        getVariableMap().put(getCommandFromIndex(0).toString(), createVariable());
        return getVariableMap().get(getCommandFromIndex(0).toString()).execute();
    }

}
