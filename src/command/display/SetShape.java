package command.display;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class SetShape extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public SetShape (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(cursor::setShape, arguments[0]));

    }

}
