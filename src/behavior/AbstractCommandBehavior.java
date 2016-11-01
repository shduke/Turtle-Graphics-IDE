package behavior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.AbstractCommand;

public abstract class AbstractCommandBehavior implements ICommandExecutionBehavior {

    private List<AbstractCommand> myArguments;
    private Map<Integer, ValueHolder> myExecutionResults;
    
    protected AbstractCommandBehavior(AbstractCommand... arguments) {
        myArguments = Arrays.asList(arguments);
        initializeExecutionResults();
    }

    private void initializeExecutionResults() {
        myExecutionResults = new HashMap<Integer, ValueHolder>();
        myExecutionResults.put(-1, new ValueHolder(0.0));
        myArguments.forEach(value -> nullifyExecutionResult(myExecutionResults.size()-1));
    }
    
    private double executeCommand(int index) {
        myExecutionResults.put(index, new ValueHolder(myArguments.get(index).execute()));
        return getExecutionResult(index);
    }
    
    protected double getExecutionResult(int index) {
        return myExecutionResults.get(index).getValue();
    }
    
    protected void nullifyExecutionResult(int index) {
        myExecutionResults.put(index, new NullValueHolder(index));
    }
    
    protected AbstractCommand getArgument(int index) {
        return myArguments.get(index);
    }
    
    @Override
    public List<AbstractCommand> getArguments() {
        return myArguments;
    }
    
    @Override
    public abstract double executeCommand ();
    
    private class ValueHolder {
        private Double myValue;
        
        ValueHolder(Double value) {
            myValue = value;
        }
        
        public double getValue() {
            return myValue;
        }
        
     }
     private class NullValueHolder extends ValueHolder{
         private int myIndex;
        
         NullValueHolder (int index) {
             super(null);
             myIndex = index;
         }
         
         @Override
         public double getValue() {
             return executeCommand(myIndex);
         }
            
        }
}
