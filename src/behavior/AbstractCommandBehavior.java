package behavior;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.utility.Constant;


public abstract class AbstractCommandBehavior implements ICommandExecutionBehavior {

    private List<AbstractCommand> myArguments;
    private Map<Integer, ValueHolder> myExecutionResults;

    protected AbstractCommandBehavior (AbstractCommand ... arguments) {
        myArguments = Arrays.asList(arguments);
        initializeExecutionResults();
    }

    private void initializeExecutionResults () {
        myExecutionResults = new HashMap<Integer, ValueHolder>();
        myExecutionResults.put(-1, new ValueHolder(0.0, new Constant(0.0)));
        myArguments.forEach(value -> nullifyExecutionResult(myExecutionResults.size() - 1));
    }

    protected double executeCommand (int index) {
        double value = myArguments.get(index).execute();
        myExecutionResults.put(index, new ValueHolder(value, myArguments.get(index)));
        return value;
    }

    protected double getExecutionResult (int index) {
        return myExecutionResults.get(index).getValue();
    }

    protected double getCachedValue (int index) {
        return myExecutionResults.get(index).getCachedValue();
    }

    protected void nullifyExecutionResult (int index) {
        myExecutionResults.put(index, new NullValueHolder(index));
    }

    protected AbstractCommand getArgument (int index) {
        return myArguments.get(index);
    }

    @Override
    public List<AbstractCommand> getArguments () {
        return myArguments;
    }

    @Override
    public abstract double executeCommand ();

    private class ValueHolder {
        private Double myValue;
        private AbstractCommand myExpression;

        ValueHolder (Double value, AbstractCommand expression) {
            myValue = value;
            myExpression = expression;
        }

        public double getValue () {
            return reEvaluateExpression();
        }

        public double getCachedValue () {
            return myValue;
        }

        private double reEvaluateExpression () {
            return myExpression.execute();
        }

    }

    private class NullValueHolder extends ValueHolder {
        private int myIndex;

        NullValueHolder (int index) {
            super(null, null);
            myIndex = index;
        }

        @Override
        public double getCachedValue () {
            return getValue();
        }

        @Override
        public double getValue () {
            return executeCommand(myIndex);
        }

    }
}
