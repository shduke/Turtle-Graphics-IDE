package behavior.unary;

import java.util.function.Function;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public class CursorBehavior extends UnaryBehavior<Boolean, Boolean> {
    private static final int IS_TRUE_INDEX = 0;

    public CursorBehavior (Function<Boolean, Boolean> operation, AbstractCommand ... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> Boolean getInput1 () {
        return getExecutionResult(IS_TRUE_INDEX) == 1;
    }

    @Override
    protected double evaluateToDouble (Boolean result) {
        return result ? 1 : 0;
    }

}
