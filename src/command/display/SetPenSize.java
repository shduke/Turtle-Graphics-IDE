package command.display;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class SetPenSize extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public SetPenSize (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(cursor.getPen()::setPenSize, arguments[0]));

    }

}
