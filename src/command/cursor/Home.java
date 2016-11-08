package command.cursor;

import behavior.nonexpression.MultiBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Home extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public Home (ICursor cursor, AbstractCommand ... arguments) {
        this(cursor);
    }

    public Home (ICursor cursor) {
        super(new MultiBehavior(new SetXY(cursor, 0.0, 0.0)));
    }

}
