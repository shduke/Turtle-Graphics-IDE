package command.queries;

import behavior.nullary.DoubleQueryBehavior;
import command.AbstractCommand;
import cursor.ICursor;


public class XCor extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public XCor (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleQueryBehavior( () -> cursor.applyToActive(b -> b.getCoordinate().getX())));
    }

}
