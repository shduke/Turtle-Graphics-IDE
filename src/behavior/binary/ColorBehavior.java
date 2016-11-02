package behavior.binary;

import java.util.List;
import java.util.function.BiFunction;
import command.AbstractCommand;

public class ColorBehavior extends BinaryBehavior<Double, String, Double> {
    private static final int COLOR_INDEX = 1;
    private static final int R_INDEX = 1;
    private static final int G_INDEX = 2;
    private static final int B_INDEX = 3;
    
    public ColorBehavior (BiFunction<Double, String, Double> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Double getInput1 () {
        return getExecutionResult(COLOR_INDEX);
    }

    @Override
    protected <R> String getInput2 () {
        return toColorString(getExecutionResult(R_INDEX), getExecutionResult(G_INDEX), getExecutionResult(B_INDEX));
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }
    
    private String toColorString(Double r, Double g, Double b) {
        return ":"+ r.toString() + ":" + g.toString() + ":" + b.toString();
    }

}
