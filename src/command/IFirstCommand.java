package command;

import java.util.List;

/**
 * @author Sean Hudson (srh50)
 */
public interface IFirstCommand {
    /**
     * Executes the command
     * @return
     */
    double execute ();

    /**
     * Gets the first inner command arguments
     * useful for commands where the identities of the inner arguments are needed (e.g. Multiline command)
     * @return
     */
    List<ICommand> getInnerCommands ();
}
