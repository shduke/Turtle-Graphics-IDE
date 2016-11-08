package command.cursor;

import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Towards extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Towards (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleBinaryBehavior( (a, b) -> cursor
                .applyToActive(c -> c.getAngle().setAngle(a, b)), arguments[0], arguments[1],
                                        new Constant(1.0)));

    }

}
