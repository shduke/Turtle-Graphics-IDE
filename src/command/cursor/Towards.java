package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.binary.DoubleBinaryBehavior;
import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class Towards extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Towards (Cursor cursor, AbstractCommand... arguments) {
        super(new DoubleBinaryBehavior(cursor.getAngle()::setAngle, arguments[0], arguments[1], new Constant(1.0)));


    }

}
