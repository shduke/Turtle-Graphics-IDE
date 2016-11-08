package command.multiple;

import behavior.unary.MultiCursorUnaryBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Tell extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Tell (ICursor cursor, AbstractCommand ... arguments) {
        super(new MultiCursorUnaryBehavior(cursor::activateCursors, arguments));
    }

}
