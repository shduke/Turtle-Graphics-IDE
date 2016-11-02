package command.display;

import behavior.nullary.DoubleQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class PenColor extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public PenColor (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleQueryBehavior(cursor.getPen()::getPenColor));

    }

}
