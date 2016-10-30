package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.CoordinateBehavior;
import behavior.MultiBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class ClearScreen extends CursorCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public ClearScreen (Cursor cursor, AbstractCommand... arguments) {
        super(cursor, new MultiBehavior(cursor::clearCreatedItems), new Home(cursor, arguments));


    }

}
