package command.cursor;

import java.util.List;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.Cursor;

public class Forward extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Forward (Cursor cursor, AbstractCommand... arguments) {
        super(new MovementBehavior(cursor::move), arguments[0], new Constant(1.0));
    }
    
}