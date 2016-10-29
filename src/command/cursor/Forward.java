package command.cursor;

import java.util.List;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import cursor.Cursor;

public class Forward extends CursorCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Forward (List<AbstractCommand> inputs, Cursor cursor) {
        super(cursor, new MovementBehavior(cursor::move), inputs.get(0), new Constant(1.0));
    }
    
}