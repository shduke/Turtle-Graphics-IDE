package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;


public class Right extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Right (Cursor cursor, AbstractCommand... arguments) {
        super(cursor, new MovementBehavior(cursor.getAngle()::rotate), arguments[0], new Constant(-1.0));

    }

}
