package command.math;

import behavior.nullary.DoubleQueryBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Pi extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;

    public Pi (AbstractCommand ... arguments) {
        super(new DoubleQueryBehavior( () -> Math.PI));
    }

}
