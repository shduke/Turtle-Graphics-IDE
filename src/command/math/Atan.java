package command.math;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Atan extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Atan (AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(p -> Math.toDegrees(Math.atan(p)), arguments));
    }

}
