//package behavior.unary;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import command.AbstractCommand;
//
//public class MultiCursorBinaryBehavior extends BinaryBehavior<List<Double>, Double>{
//    private static final int INPUT1_INDEX = 0;
//    
//    public MultiCursorBinaryBehavior (Function<List<Double>, Double> operation, AbstractCommand... arguments) {
//        super(operation, arguments);
//    }
//
//    @Override
//    protected <R> List<Double> getInput1 () {
//        //return getArguments().stream().map(AbstractCommand::execute).collect(Collectors.toList());
//        return getArgument(INPUT1_INDEX).getCommandArguments().stream().map(AbstractCommand::execute).collect(Collectors.toList());
//    }
//
//    @Override
//    protected double evaluateToDouble (Double result) {
//        return result;
//    }
//
//}
