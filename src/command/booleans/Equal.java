package command.booleans;

import behavior.binary.BooleanBinaryBehavior;
import command.AbstractCommand;


public class Equal extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Equal (AbstractCommand ... arguments) {
        super(new BooleanBinaryBehavior( (a, b) -> (a.equals(b)), arguments));
    }

}
