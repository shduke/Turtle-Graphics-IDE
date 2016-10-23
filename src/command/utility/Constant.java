package command.utility;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;

public class Constant extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    Double myValue;
    
    public Constant (Map<String, Variable> variableMap, List<AbstractCommand> inputs, double value) {
        super(variableMap, inputs);
        myValue = value;
    }

    @Override
    public double execute () {
        return myValue;
    }

}