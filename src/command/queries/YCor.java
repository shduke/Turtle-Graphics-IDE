package command.queries;

import behavior.nullary.DoubleQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class YCor extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public YCor (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleQueryBehavior( () -> cursor.applyToActive(b -> b.getCoordinate().getY())));
    }

}
