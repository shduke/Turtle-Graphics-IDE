package command.queries;

import behavior.nullary.DoubleQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Id extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public Id (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleQueryBehavior(cursor::getId));
    }

}
