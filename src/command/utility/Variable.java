package command.utility;

import java.util.Map;
import java.util.function.BiFunction;
import behavior.nonexpression.MultiBehavior;
import command.AbstractCommand;


public class Variable extends AbstractCommand implements IVariable {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private String myKey;
    private double myLastResult;

    public Variable (Map<String, IVariable> variableMap,
                     String key,
                     AbstractCommand ... parameterValues) {
        this(variableMap::put, key);
    }

    public Variable (BiFunction<String, IVariable, IVariable> operation, String key) {
        super(new MultiBehavior());
        operation.apply(key, this);
        myKey = key;
    }

    private void setValue (AbstractCommand value) {
        setCommandExecutionBehavior(new MultiBehavior(value));
    }

    @Override
    public void setExpression (AbstractCommand value, IVariable ... parameters) {
        setValue(value);
    }

    @Override
    public void updateParameterValues (int index, AbstractCommand abstractCommand) {
        return;
    }

    @Override
    public String toString () {
        return myKey;
    }

    @Override
    public int getNumberOfParameters () {
        return MY_NUMBER_OF_COMMAND_PARAMETERS;
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
