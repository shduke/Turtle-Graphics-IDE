package command.math;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Minus extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Minus (AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(a -> -1 * a, arguments));
    }

}
