package command.math;

import behavior.unary.DegreesBehavior;
import command.AbstractCommand;


public class Cos extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public Cos (AbstractCommand ... arguments) {
        super(new DegreesBehavior(Math::cos, arguments));
    }

}
