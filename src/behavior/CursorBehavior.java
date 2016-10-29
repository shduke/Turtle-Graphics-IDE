package behavior;

import java.util.List;
import java.util.function.Function;

public class CursorBehavior extends UnaryBehavior<Boolean, Boolean>{
    private int IS_TRUE_INDEX = 0;
    
    public CursorBehavior (Function<Boolean, Boolean> operation) {
        super(operation);
    }

    @Override
    protected <R> Boolean getInput1 (List<Double> arguments) {
        return arguments.get(IS_TRUE_INDEX) == 1;
    }

    @Override
    protected double evaluateToDouble (List<Double> arguments, Boolean result) {
        return result ? 1 : 0;
    }
    
    
    
}

//return myOperation.test(arguments.get(IS_TRUE_INDEX)) ? 1 : 0;

