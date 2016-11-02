package command.cursor;

import behavior.nonexpression.MultiBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class ClearScreen extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public ClearScreen (ICursor cursor, AbstractCommand ... arguments) {
        super(new MultiBehavior(new DeleteCreatedItems(cursor), new Home(cursor, arguments)));

    }

}
