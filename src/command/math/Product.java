package command.math;

import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;
import cursor.Cursor;

public class Product extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Product (AbstractCommand... arguments) {
        super(new DoubleBinaryBehavior((a, b) -> a * b, arguments));
    }
    
}