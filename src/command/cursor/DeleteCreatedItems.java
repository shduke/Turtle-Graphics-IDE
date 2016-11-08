package command.cursor;

import behavior.RunnableBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class DeleteCreatedItems extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public DeleteCreatedItems (ICursor cursor, AbstractCommand ... arguments) {
        this(cursor);
    }

    public DeleteCreatedItems (ICursor cursor) {
        super(new RunnableBehavior(cursor::clearCreatedItems));
    }

}
