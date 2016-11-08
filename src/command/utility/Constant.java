package command.utility;

import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class Constant extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    double myValue;

    public Constant (Double value, AbstractCommand ... arguments) {
        this(value);
    }

    public Constant (Double value) {
        super(null);
        myValue = value;
    }

    @Override
    public double execute () {
        return myValue;
    }

}
