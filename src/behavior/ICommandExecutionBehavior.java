package behavior;

import java.util.List;
import command.AbstractCommand;


public interface ICommandExecutionBehavior {

    double executeCommand ();

    List<AbstractCommand> getArguments ();

}
