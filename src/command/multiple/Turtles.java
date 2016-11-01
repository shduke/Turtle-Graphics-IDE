package command.multiple;

import java.util.List;
import behavior.nullary.DoubleQueryBehavior;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;

public class Turtles extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public Turtles (ICursor cursor, AbstractCommand... arguments) {
        super(new DoubleQueryBehavior(cursor::getId));
    }
    
}