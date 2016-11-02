package command.math;

import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;


public class Sum extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Sum (AbstractCommand ... arguments) {
        super(new DoubleBinaryBehavior( (a, b) -> a + b, arguments));
    }

}
