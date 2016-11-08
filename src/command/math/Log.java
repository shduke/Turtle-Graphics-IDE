package command.math;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Log extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Log (AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(Math::log, arguments));
    }

}
