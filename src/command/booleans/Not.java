package command.booleans;

import behavior.BooleanBinaryBehavior;
import behavior.BooleanQueryBehavior;
import behavior.DoubleUnaryBehavior;
import command.AbstractCommand;

public class Not extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Not (AbstractCommand... arguments) {
        super(new DoubleUnaryBehavior(a -> a == 0 ? 1.0 : 0), arguments);
    }
    
}