package command.cursor;

import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;


public class Left extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Left (ICursor cursor, AbstractCommand ... arguments) {
        super(new MovementBehavior(a -> cursor.applyToActive(b -> b.getAngle().rotate(a)),
                                   arguments[0], new Constant(1.0)));

    }

}
