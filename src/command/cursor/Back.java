package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.ICursor;

public class Back extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Back (ICursor cursor, AbstractCommand... arguments) {
        super(new MovementBehavior(cursor::move, arguments[0], new Constant(-1.0)));

    }
    
}