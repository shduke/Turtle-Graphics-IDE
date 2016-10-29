package behavior;

import java.util.List;
import java.util.function.BiFunction;
import command.AbstractCommand;

//TODO: Handle empty multiBehaviors
public class MultiBehavior implements ICommandExecutionBehavior{
    
    @Override
    public double executeCommand(List<Double> arguments) {
        return arguments.get(arguments.size() - 1);
    }

}
