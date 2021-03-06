package command.cursor;

import behavior.unary.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Back extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Back (ICursor cursor, AbstractCommand ... arguments) {
        super(new MovementBehavior(cursor::move, arguments[0], new Constant(-1.0)));

    }

}
