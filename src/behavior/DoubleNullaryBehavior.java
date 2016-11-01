package behavior;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class DoubleNullaryBehavior extends QueryBehavior<Double> {
    
    public DoubleNullaryBehavior(Supplier<Double> operation) {
        super(operation);
    }
    
    @Override
    protected double evaluateToDouble(List<Double> arguments, Double result) {
        return result;
    }
}
