package command.utility;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;

public class Constant extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    double myValue;
    
    public Constant (List<AbstractCommand> inputs, Double value) {
        this(value);
    }
    
    public Constant (Double value) {
        myValue = value;
    }
    

    @Override
    public double execute () {
        return myValue;
    }

}
