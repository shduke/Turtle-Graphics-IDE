package command.iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.ParameterCommand;
import command.assignment.Set;
import command.utility.Constant;
import command.utility.Variable;

public class For extends ParameterCommand { //TODO - maybe subclass based on iteration
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    protected For (Map<String, IVariable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }
    
    //TODO-Make more readable by flattening data and extending command hierarchy
    @Override
    public double execute () {
        String variableName = getExpression().get(0).getExpression().get(0).toString();
        double start = getExpression().get(0).getExpression().get(1).execute();
        double end = getExpression().get(0).getExpression().get(2).execute();
        double increment = getExpression().get(0).getExpression().get(3).execute();
        getVariableMap().put(variableName, createVariable(null, variableName));
        double value = 0;
        for(double i = start; i < end; i += increment) {
            getVariableMap().get(variableName).setExpressione(new Constant(getVariableMap(), new ArrayList<AbstractCommand>(), i));
            value = getCommandFromIndex(2).execute();
        }
        return value;
    }

}