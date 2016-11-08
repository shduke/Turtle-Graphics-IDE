package command.display;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class SetBackground extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public SetBackground (ICursor cursor, AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(cursor::setBackground, arguments[0], new Constant(-1.0)));

    }

}
