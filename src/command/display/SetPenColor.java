package command.display;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class SetPenColor extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public SetPenColor (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(cursor.getPen()::setPenColor, arguments[0]));

    }

}
