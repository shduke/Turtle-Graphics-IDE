package command.multiple;

import java.util.List;
import behavior.nullary.DoubleQueryBehavior;
import behavior.unary.MovementBehavior;
import behavior.unary.MultiCursorUnaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;

public class Ask extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Ask (ICursor cursor, AbstractCommand... arguments) {
        super(new MultiCursorUnaryBehavior(cursor::activateCursors, arguments));
    }
    
}