package command.queries;

import behavior.nullary.DoubleQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class Heading extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public Heading (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleQueryBehavior( () -> cursor.applyToActive(b -> b.getAngle().getAngle())));
    }

}
