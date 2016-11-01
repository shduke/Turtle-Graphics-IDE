package behavior;

import java.util.List;
import java.util.function.Supplier;

public class DoubleQueryBehavior extends QueryBehavior<Double>{

    public DoubleQueryBehavior (Supplier operation) {
        super(operation);
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Double result) {
        return result;
    }

}
