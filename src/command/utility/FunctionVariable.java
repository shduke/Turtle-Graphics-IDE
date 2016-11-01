package command.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import behavior.nonexpression.MultiBehavior;
import behavior.nonexpression.VariableExecutionBehavior;
import command.AbstractCommand;

//TODO: have constant separate from the rest. Doesn't need behavior or input list.
public class FunctionVariable extends AbstractCommand implements IVariable {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    private List<IVariable> myParameters;
    private String myKey;
    //private String myScope = "global";
    
    public FunctionVariable (Map<String, IVariable> variableMap, String key, AbstractCommand... parameterValues) {
          this(variableMap, key);
//        super(new VariableExecutionBehavior(variableMap, key));
//        myVariableMap = variableMap;
//        IntStream.rangeClosed(0, MY_NUMBER_OF_COMMAND_PARAMETERS).forEach(a -> myParameters.get(a).setParameters(parameterValues[a]));

    }
    
    public FunctionVariable (Map<String, IVariable> variableMap, String key, Double value) {
        this(variableMap, key, new Constant(value));
    }
    
    public FunctionVariable (Map<String, IVariable> variableMap, String key) {
        //this(variableMap, key, 0.0);
        super(new MultiBehavior());
        variableMap.put(key, this);
        myKey = key;
    }
    
    @Override
    public void setExpression(AbstractCommand value, IVariable... parameters) {
        setValue(value);
        setParameters(parameters);
    }
    
    
    private void setValue(AbstractCommand value) {
        setCommandExecutionBehavior(new MultiBehavior(value));
        //set scope here from assignment commands
    }
    
    private void setParameters(IVariable... parameters) {
        //IntStream.rangeClosed(0, MY_NUMBER_OF_COMMAND_PARAMETERS).forEach(a -> myParameters.get(a).setParameters(parameterValues[a]));
        myParameters = Arrays.asList(parameters);
    }
    
    @Override
    public String toString() {
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
    

}
