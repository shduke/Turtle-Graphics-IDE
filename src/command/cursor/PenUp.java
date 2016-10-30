package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.CursorBehavior;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class PenUp extends CursorCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public PenUp (Cursor cursor, AbstractCommand... arguments) {
        super(cursor, new CursorBehavior(cursor.getPen()::setIsPenDown), new Constant(0.0));
    }
    
}