package command.booleans;

import behavior.binary.BooleanBinaryBehavior;
import command.AbstractCommand;


public class And extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public And (AbstractCommand ... arguments) {
        super(new BooleanBinaryBehavior( (a, b) -> (a != 0 && b != 0), arguments));
    }

}
