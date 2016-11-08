package command.math;

import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Remainder extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Remainder (AbstractCommand ... arguments) {
        super(new DoubleBinaryBehavior( (a, b) -> a % b, arguments));
    }

}
