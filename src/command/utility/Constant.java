package command.utility;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;

//TODO: have constant separate from the rest. Doesn't need behavior or input list.
public class Constant extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    double myValue;
    
    public Constant (Double value, AbstractCommand... arguments) {
        this(value);
    }
    
    public Constant (Double value) {
        super(null, new AbstractCommand[0]);
        myValue = value;
    }
    

    @Override
    public double execute () {
        return myValue;
    }

}
