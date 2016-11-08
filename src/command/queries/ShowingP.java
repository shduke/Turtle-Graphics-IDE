package command.queries;

import behavior.nullary.BooleanQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class ShowingP extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public ShowingP (ICursor cursor, AbstractCommand ... arguments) {
        super(new BooleanQueryBehavior(cursor::getIsVisible));
    }

}
