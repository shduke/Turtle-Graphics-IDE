package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;
import behavior.nonexpression.MultiBehavior;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;

//TODO: have constant separate from the rest. Doesn't need behavior or input list.
public class Variable extends AbstractCommand implements IVariable {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private String myKey;
    private double myLastResult;
    //private String myScope = "global";
    
    public Variable (Map<String, IVariable> variableMap, String key, AbstractCommand... parameterValues) {
          this(variableMap::put, key);
    }
          
    public Variable (BiFunction<String,IVariable, IVariable> operation, String key) {
        super(new MultiBehavior());
        operation.apply(key, this);
        myKey = key;
    }
          //        super(new VariableExecutionBehavior(variableMap, key));
//        myVariableMap = variableMap;
//        IntStream.rangeClosed(0, MY_NUMBER_OF_COMMAND_PARAMETERS).forEach(a -> myParameters.get(a).setParameters(parameterValues[a]));

    
    
    private void setValue(AbstractCommand value) {
        setCommandExecutionBehavior(new MultiBehavior(value));
        //set scope here from assignment commands
    }
    
    @Override
    public void setExpression(AbstractCommand value, IVariable... parameters) {
        setValue(value);
    }

    @Override
    public void updateParameterValues (int index, AbstractCommand abstractCommand) {
        return;
    }
    
    @Override
    public String toString() {
        return myKey;
    }

    @Override
    public int getNumberOfParameters () {
        return MY_NUMBER_OF_COMMAND_PARAMETERS;
    }

    @Override
    public double getLastResult () {
        return myLastResult;
    }

    @Override
    public void setlastResult (double lastResult) {
        myLastResult = lastResult;
    }


}
