package command.multiple;

import behavior.nonexpression.AskBehavior;
import command.AbstractCommand;
import command.utility.MultiLine;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Ask extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Ask (ICursor cursor, AbstractCommand ... arguments) {
        super(new AskBehavior(new Tell(cursor, arguments[0]), arguments[1],
                              new Tell(cursor, new MultiLine(cursor.getActiveCursorConstants()))));
    }

}
