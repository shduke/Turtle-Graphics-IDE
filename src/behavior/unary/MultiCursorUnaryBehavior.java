package behavior.unary;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import command.AbstractCommand;

public class MultiCursorUnaryBehavior extends UnaryBehavior<List<Double>, Double>{
    private static final int INPUT1_INDEX = 0;
    
    public MultiCursorUnaryBehavior (Function<List<Double>, Double> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> List<Double> getInput1 () {
        List<Double> blah = getArgument(INPUT1_INDEX).getCommandArguments().stream().map(AbstractCommand::execute).collect(Collectors.toList());
        //return getArguments().stream().map(AbstractCommand::execute).collect(Collectors.toList());
        return blah;
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }

}
