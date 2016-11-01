package command.math;

import behavior.DoubleBinaryBehavior;
import command.AbstractCommand;

public class Remainder extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Remainder (AbstractCommand... arguments) {
        super(new DoubleBinaryBehavior((a, b) -> a % b), arguments);
    }
    
}