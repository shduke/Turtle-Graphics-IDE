package behavior.unary;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class ConditionalMultiCursorBehavior extends UnaryBehavior<List<Double>, Double> {
    private static final int CONDITIONS_INDEX = 0;

    public ConditionalMultiCursorBehavior (Function<List<Double>, Double> operation,
                                           AbstractCommand ... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> List<Double> getInput1 () {
        return getArgument(CONDITIONS_INDEX).getCommandArguments().stream()
                .map(AbstractCommand::execute).collect(Collectors.toList());
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }

}
