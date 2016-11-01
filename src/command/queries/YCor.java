package command.queries;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.nullary.BooleanQueryBehavior;
import behavior.nullary.DoubleQueryBehavior;
import behavior.unary.CursorBehavior;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.ICursor;

public class YCor extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public YCor (ICursor cursor, AbstractCommand... arguments) {
        super(new DoubleQueryBehavior(cursor.getCoordinate()::getY));
    }
    
}