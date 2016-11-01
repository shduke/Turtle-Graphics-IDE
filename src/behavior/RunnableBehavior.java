package behavior;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class RunnableBehavior extends AbstractCommandBehavior {
    Runnable myOperation;
    
    public RunnableBehavior(Runnable operation) {
        myOperation = operation;
    }

    @Override
    public double executeCommand () {
        myOperation.run();
        return 0;
    }
}
