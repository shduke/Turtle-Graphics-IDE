package command.booleans;

import behavior.BooleanBinaryBehavior;
import command.AbstractCommand;

public class Less extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Less (AbstractCommand... arguments) {
        super(new BooleanBinaryBehavior((a, b) -> (a < b)), arguments);
    }
    
}