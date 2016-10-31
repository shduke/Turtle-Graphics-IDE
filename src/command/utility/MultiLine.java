package command.utility;

import behavior.MultiBehavior;
import command.AbstractCommand;

public class MultiLine extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = Integer.MAX_VALUE;
    
    public MultiLine (AbstractCommand... arguments) {
        super(new MultiBehavior(arguments));
    }
    
}