package behavior;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.utility.Constant;

/**
 * @author Sean Hudson (srh50)
 */
public abstract class AbstractCommandBehavior implements ICommandExecutionBehavior {

    private List<AbstractCommand> myArguments;
    private Map<Integer, ValueHolder> myExecutionResults;

    protected AbstractCommandBehavior (AbstractCommand ... arguments) {
        myArguments = Arrays.asList(arguments);
        initializeExecutionResults();
    }
    
    /**
     * Initializes the results map with null objects
     */
    private void initializeExecutionResults () {
        myExecutionResults = new HashMap<Integer, ValueHolder>();
        myExecutionResults.put(-1, new ValueHolder(0.0, new Constant(0.0)));
        myArguments.forEach(value -> nullifyExecutionResult(myExecutionResults.size() - 1));
    }

    /**
     * executes command and stores its result
     * 
     * @param index
     * @return
     */
    protected double executeCommand (int index) {
        double value = myArguments.get(index).execute();
        myExecutionResults.put(index, new ValueHolder(value, myArguments.get(index)));
        return value;
    }

    /**
     * Executes the command again
     * 
     * @param index
     * @return
     */
    protected double getExecutionResult (int index) {
        return myExecutionResults.get(index).getValue();
    }

    /**
     * Gets the saved result of the command
     * 
     * @param index
     * @return
     */
    protected double getCachedValue (int index) {
        return myExecutionResults.get(index).getCachedValue();
    }

    /**
     * Replaces the result with a Null object
     * 
     * @param index
     */
    protected void nullifyExecutionResult (int index) {
        myExecutionResults.put(index, new NullValueHolder(index));
    }

    /**
     * Gets a specific command to be executed
     * 
     * @param index
     * @return
     */
    protected AbstractCommand getArgument (int index) {
        return myArguments.get(index);
    }

    /**
     * Gets all of the commands to be executed
     */
    @Override
    public List<AbstractCommand> getArguments () {
        return myArguments;
    }

    
    /**
     * Executes the command arguments
     */
    @Override
    public abstract double executeCommand ();

    
    /**
     * Class for holding the results of a command execution
     * 
     * @author Sean Hudson (srh50)
     */
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
