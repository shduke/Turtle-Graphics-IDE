package command.math;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Random extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Random (AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(a -> Math.random() * a, arguments));
    }

}
