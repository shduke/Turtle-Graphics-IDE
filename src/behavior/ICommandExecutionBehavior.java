package behavior;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;

public interface ICommandExecutionBehavior {
    
    double executeCommand(List<Double> arguments);

}
