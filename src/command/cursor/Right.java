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


public class Right extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Right (ICursor cursor, AbstractCommand... arguments) {
        //super(new MovementBehavior(cursor.getAngle()::rotate, arguments[0], new Constant(-1.0)));
        super(new MovementBehavior(cursor.applyToActive(mapping), arguments[0], new Constant(-1.0)));


    }

}
