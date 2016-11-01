package behavior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO - maybe refactor it so that it takes in a list of commands as its input
public class MultiBehavior implements ICommandExecutionBehavior{
    List<Runnable> myOperation;
    
    public MultiBehavior(Runnable... operation) {
        myOperation = Arrays.asList(operation);
    }
    
    public MultiBehavior() {
        myOperation = new ArrayList<Runnable>();
    }
    
    @Override
    public double executeCommand(List<Double> arguments) {
        myOperation.forEach(Runnable::run);
        return arguments.get(arguments.size()-1);
    }
}
