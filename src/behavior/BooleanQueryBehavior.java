package behavior;

import java.util.List;
import java.util.function.Supplier;

public class BooleanQueryBehavior extends QueryBehavior<Boolean>{

    public BooleanQueryBehavior (Supplier operation) {
        super(operation);
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Boolean result) {
        return result ? 1 : 0;
    }

}
