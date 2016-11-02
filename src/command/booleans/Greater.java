package command.booleans;

import behavior.binary.BooleanBinaryBehavior;
import command.AbstractCommand;


public class Greater extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Greater (AbstractCommand ... arguments) {
        super(new BooleanBinaryBehavior( (a, b) -> (a > b), arguments));
    }

}
