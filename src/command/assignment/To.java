package command.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import command.AbstractCommand;
import command.ParameterCommand;
import command.utility.Variable;

public class To extends ParameterCommand{
    private static int MY_NUMBER_OF_COMMAND_PARAMETERS = 0; //maybe switch to getNumberOfParameter()
    
    To(Map<String, Variable> variableMap, List<AbstractCommand> inputs) { //inputs[NameCommand, MultiLine, MultiLine ]
        super(variableMap, inputs);
    }
    
    @Override
    public double execute () {
        getVariableMap().put(getCommandFromIndex(0).toString(), createVariable());
        return getVariableMap().get(getCommandFromIndex(0).toString()).execute();
    }
    
}
