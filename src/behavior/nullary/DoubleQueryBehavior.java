package behavior.nullary;

import java.util.function.Supplier;


public class DoubleQueryBehavior extends QueryBehavior<Double> {

    public DoubleQueryBehavior (Supplier<Double> operation) {
        super(operation);
    }

    @Override
    protected double evaluateToDouble (Double result) {
        return result;
    }

}
