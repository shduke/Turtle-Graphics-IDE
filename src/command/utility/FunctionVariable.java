package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import behavior.nonexpression.MultiBehavior;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;


/**
 * @author Sean Hudson (srh50)
 */
public class FunctionVariable extends AbstractCommand implements IVariable {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private List<IVariable> myParameters;
    private String myKey;
    private Double myLastResult;

    public FunctionVariable (Map<String, IVariable> variableMap,
                             String key,
                             AbstractCommand ... parameterValues) {
        this(variableMap, key);
    }

    public FunctionVariable (Map<String, IVariable> variableMap, String key, Double value) {
        this(variableMap, key, new Constant(value));
    }

    public FunctionVariable (Map<String, IVariable> variableMap, String key) {
        super(new MultiBehavior());
        variableMap.put(key, this);
        myKey = key;
    }

    @Override
    public void setExpression (AbstractCommand value, IVariable ... parameters) {
        setValue(value);
        setParameters(parameters);
    }

    private void setValue (AbstractCommand value) {
        setCommandExecutionBehavior(new MultiBehavior(value));
    }

    private void setParameters (IVariable ... parameters) {
        myParameters = Arrays.asList(parameters);
    }

    @Override
    public String toString () {
        return myKey;
    }

    @Override
    public void updateParameterValues (int index, AbstractCommand abstractCommand) {
        myParameters.get(index).setExpression(abstractCommand);
    }

    @Override
    public int getNumberOfParameters () {
        return myParameters.size();
    }

    @Override
    public Double getLastResult () {
        return myLastResult;
    }

    @Override
    public void setlastResult (double lastResult) {
        myLastResult = lastResult;
    }

}
