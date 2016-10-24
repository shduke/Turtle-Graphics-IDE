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
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3; //maybe switch to getNumberOfParameter()
    
    To(Map<String, Variable> variableMap, List<AbstractCommand> inputs) { //inputs[NameCommand, MultiLine, MultiLine ]
        super(variableMap, inputs);
    }
    
    @Override
    public double execute () {
        String methodName = getCommandFromIndex(0).toString();
        getVariableMap().put(methodName, createVariable( getCommandFromIndex(2), methodName));
        for(int i = 0; i < getExpression().size(); i++) {
            String parameter = getCommandFromIndex(1).getExpression().get(i).toString();
            getVariableMap().put(parameter, createVariable(null, parameter));
        }
        return 1;
    }
    
}
