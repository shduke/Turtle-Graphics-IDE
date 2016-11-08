package command.booleans;

import behavior.unary.DoubleUnaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Not extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Not (AbstractCommand ... arguments) {
        super(new DoubleUnaryBehavior(a -> a == 0 ? 1.0 : 0, arguments));
    }

}
