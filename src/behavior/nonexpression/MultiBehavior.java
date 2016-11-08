package behavior.nonexpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import behavior.AbstractCommandBehavior;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class MultiBehavior extends AbstractCommandBehavior {
    private int myNumberOfCommands;

    public MultiBehavior (AbstractCommand ... arguments) {
        super(arguments);
        myNumberOfCommands = arguments.length - 1;
    }

    @Override
    public double executeCommand () {
        IntStream.rangeClosed(0, myNumberOfCommands).forEach(this::executeCommand);
        return getCachedValue(myNumberOfCommands);
    }

}
