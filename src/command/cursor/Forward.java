package command.cursor;

import java.util.List;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import cursor.Cursor;

public class Forward extends CursorCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Forward (Cursor cursor, AbstractCommand... arguments) {
        super(cursor, new MovementBehavior(cursor::move), arguments[0], new Constant(1.0));
    }
    
}