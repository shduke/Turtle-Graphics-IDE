package command.control;

import behavior.unary.ConditionalUnaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;

public class If extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public If (AbstractCommand... arguments) {
        super(new ConditionalUnaryBehavior(a -> a != 0, arguments[0], arguments[1], new Constant(0.0)));
    }

}