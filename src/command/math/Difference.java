package command.math;

import behavior.DoubleBinaryBehavior;
import command.AbstractCommand;
import cursor.Cursor;

public class Difference extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Difference (AbstractCommand... arguments) {
        super(new DoubleBinaryBehavior((a, b) -> a - b), arguments);
    }
    
}