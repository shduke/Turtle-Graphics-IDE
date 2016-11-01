package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.CursorBehavior;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class ShowTurtle extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public ShowTurtle (Cursor cursor, AbstractCommand... arguments) {
        super(new CursorBehavior(cursor::setIsVisible), new Constant(1.0));
    }
    
}