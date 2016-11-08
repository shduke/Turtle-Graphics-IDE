package command.control;

import behavior.unary.ConditionalUnaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class IfElse extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;

    public IfElse (AbstractCommand ... arguments) {
        super(new ConditionalUnaryBehavior(a -> a != 0, arguments));
    }

}
