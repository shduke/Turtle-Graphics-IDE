package command.cursor;

import behavior.unary.CursorBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;


public class PenDown extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public PenDown (ICursor cursor, AbstractCommand ... arguments) {
        super(new CursorBehavior(cursor.getPen()::setIsPenDown, new Constant(1.0)));
    }

}
