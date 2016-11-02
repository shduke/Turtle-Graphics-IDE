package behavior.nonexpression;

import java.util.stream.IntStream;
import behavior.AbstractCommandBehavior;
import command.AbstractCommand;


public class AskBehavior extends AbstractCommandBehavior {
    private static final int RETURN_VALUE_INDEX = 1;
    private int myNumberOfCommands;

    public AskBehavior (AbstractCommand ... arguments) {
        super(arguments);
        myNumberOfCommands = arguments.length - 1;
    }

    @Override
    public double executeCommand () {
        IntStream.rangeClosed(0, myNumberOfCommands).forEach(this::executeCommand);
        return getCachedValue(RETURN_VALUE_INDEX);
    }

}
