package command.display;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.unary.CursorBehavior;
import behavior.unary.DoubleUnaryBehavior;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.ICursor;

public class SetPenColor extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public SetPenColor (ICursor cursor, AbstractCommand... arguments) {
        super(new DoubleUnaryBehavior(cursor.getPen()::setPenColor, arguments[0]));

    }
    
}