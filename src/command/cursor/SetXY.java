package command.cursor;

import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;


public class SetXY extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public SetXY (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleBinaryBehavior( (a, b) -> cursor
                .applyToActive(c -> c.getCoordinate().setCoordinate(a, b)), arguments[0],
                                        arguments[1], new Constant(1.0)));
    }

    public SetXY (ICursor cursor, double x, double y) {
        this(cursor, new Constant(x), new Constant(y));
    }

}
