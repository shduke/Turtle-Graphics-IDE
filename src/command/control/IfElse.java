package command.control;

import behavior.unary.ConditionalUnaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;

public class IfElse extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;
    
    public IfElse (AbstractCommand... arguments) {
        super(new ConditionalUnaryBehavior(a -> a != 0, arguments));
    }

}