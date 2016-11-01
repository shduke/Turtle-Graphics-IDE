package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.unary.CursorBehavior;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.ICursor;

public class PenUp extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public PenUp (ICursor cursor, AbstractCommand... arguments) {
        super(new CursorBehavior(cursor.getPen()::setIsPenDown, new Constant(0.0)));
    }
    
}