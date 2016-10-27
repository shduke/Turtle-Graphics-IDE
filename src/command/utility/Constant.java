package command.utility;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;

public class Constant extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    Double myValue;
    
    public Constant (List<AbstractCommand> inputs, double value) {
        super(inputs);
        myValue = value;
    }

    @Override
    public double execute () {
        return myValue;
    }

}
