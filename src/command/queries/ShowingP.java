package command.queries;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.nullary.BooleanQueryBehavior;
import behavior.unary.CursorBehavior;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class ShowingP extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public ShowingP (Cursor cursor, AbstractCommand... arguments) {
        super(new BooleanQueryBehavior(cursor::getIsVisible));
    }
    
}