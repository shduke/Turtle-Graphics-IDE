package behavior.nullary;

import java.util.function.Supplier;

/**
 * @author Sean Hudson (srh50)
 */
public class DoubleQueryBehavior extends QueryBehavior<Double> {

    public DoubleQueryBehavior (Supplier<Double> operation) {
        super(operation);
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }

}
