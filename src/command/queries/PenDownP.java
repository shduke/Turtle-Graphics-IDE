package command.queries;

import behavior.nullary.BooleanQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class PenDownP extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public PenDownP (ICursor cursor, AbstractCommand ... arguments) {
        super(new BooleanQueryBehavior(cursor.getPen()::getIsPenDown));
    }

}
