package command.iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.ParameterCommand;
import command.assignment.Set;
import command.utility.Constant;
import command.utility.Variable;

public class DoTimes extends ParameterCommand { //TODO - maybe subclass based on iteration
    private static final String DEFAULT_LOOP_VARIABLE = ":repcount";
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2; //replace indicies with names
    
    protected DoTimes (Map<String, IVariable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    //TODO-Make more readable by flattening data and extending command hierarchy
    @Override
    public double execute () {
        double value = 0;
        String variable = getCommandFromIndex(0).toString().split(",")[0];
        double limit = getCommandFromIndex(0).getExpression().get(1).execute();
        getVariableMap().put(variable, createVariable(createConstant(value), variable));
        while(getVariableMap().get(variable).execute() < limit) {
            getVariableMap().get(variable).setExpressione(new Constant(getVariableMap(), new ArrayList<AbstractCommand>(), value));
            value = getCommandFromIndex(1).execute();
        }
        return value;
    }

    public Constant createConstant(double value) {
        return new Constant(getVariableMap(), new ArrayList<AbstractCommand>(), value);
    }
    
}