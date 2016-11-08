package behavior;

import java.util.List;
import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public interface ICommandExecutionBehavior {

    /**
     * Executes the command
     * @return
     */
    double executeCommand ();

    /**
     * Gets the input arguments of the outer most command
     * @return
     */
    List<AbstractCommand> getArguments ();

}
