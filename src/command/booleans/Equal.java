package command.booleans;

import behavior.BooleanBinaryBehavior;
import command.AbstractCommand;

public class Equal extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Equal (AbstractCommand... arguments) {
        super(new BooleanBinaryBehavior((a, b) -> (a.equals(b))), arguments);
    }
    
}