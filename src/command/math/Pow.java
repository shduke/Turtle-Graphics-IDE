package command.math;

import behavior.DoubleBinaryBehavior;
import command.AbstractCommand;
import cursor.Cursor;

public class Pow extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Pow (AbstractCommand... arguments) {
        super(new DoubleBinaryBehavior(Math::pow), arguments);
    }
    
}