package command.control;

import behavior.unary.ConditionalUnaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;

/**
 * @author Sean Hudson (srh50)
 */
public class If extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public If (AbstractCommand... arguments) {
        super(new ConditionalUnaryBehavior(a -> a != 0, arguments[0], arguments[1], new Constant(0.0)));
    }

}