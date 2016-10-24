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
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    protected DoTimes (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        getVariableMap().put(DEFAULT_LOOP_VARIABLE, createVariable());
        double expr = getFirstCommand().execute();
        double value = 0;
        for(double i = 0; i < expr; i++) {
            getVariableMap().get(DEFAULT_LOOP_VARIABLE).setExpressione(new Constant(getVariableMap(), new ArrayList<AbstractCommand>(), i));
            value = getCommandFromIndex(2).execute();
        }
        return value;
    }

}