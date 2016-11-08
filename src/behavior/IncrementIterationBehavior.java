package behavior;

import java.util.Map;
import command.AbstractCommand;
import command.assignment.Set;
import command.utility.Constant;
import command.utility.IVariable;

/**
 * @author Sean Hudson (srh50)
 */
public class IncrementIterationBehavior extends IterationBehavior {
    private static final int VARIABLE_INDEX = 0;
    private static final int START_INDEX = 1;
    private static final int STOP_INDEX = 2;
    private static final int INCREMENT_INDEX = 3;
    private static final int BODY_INDEX = 4;

    Map<String, IVariable> myVariableMap;

    public IncrementIterationBehavior (Map<String, IVariable> variableMap,
                                       AbstractCommand ... arguments) {
        super(arguments);
        myVariableMap = variableMap;
        assignVariable(VARIABLE_INDEX);
    }

    @Override
    protected double getStart () {
        return getCachedValue(START_INDEX);
    }

    @Override
    protected double getStop () {
        return getCachedValue(STOP_INDEX);
    }

    @Override
    protected double getIncrement () {
        return getCachedValue(INCREMENT_INDEX);
    }

    @Override
    protected void assignVariable (double index) {
        nullifyExecutionResult(VARIABLE_INDEX);
        (new Set(myVariableMap, getArgument(VARIABLE_INDEX), new Constant(index))).execute();
    }

    @Override
    protected void loopBody (double index) {
        nullifyExecutionResult(BODY_INDEX);
        getExecutionResult(BODY_INDEX);
    }

    @Override
    protected double getResult () {
        return getCachedValue(BODY_INDEX);
    }

}
