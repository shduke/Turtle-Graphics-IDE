package behavior.nullary;

import java.util.function.Supplier;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class BooleanQueryBehavior extends QueryBehavior<Boolean> {

    public BooleanQueryBehavior (Supplier<Boolean> operation, AbstractCommand ... arguments) {
        super(operation);
    }

    @Override
    protected double evaluateToDouble (Boolean result) {
        return result ? 1 : 0;
    }

}
