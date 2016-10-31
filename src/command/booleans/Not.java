package command.booleans;

import behavior.binary.BooleanBinaryBehavior;
import behavior.nullary.BooleanQueryBehavior;
import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;

public class Not extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Not (AbstractCommand... arguments) {
        super(new DoubleUnaryBehavior(a -> a == 0 ? 1.0 : 0, arguments));
    }
    
}