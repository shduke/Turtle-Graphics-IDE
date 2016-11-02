package command.math;

import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;


public class Pow extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;

    public Pow (AbstractCommand ... arguments) {
        super(new DoubleBinaryBehavior(Math::pow, arguments));
    }

}
