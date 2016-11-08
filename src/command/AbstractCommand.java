package command;

import java.util.ArrayList;
import java.util.List;
import behavior.ICommandExecutionBehavior;

/**
 * @author Sean Hudson (srh50)
 */
public abstract class AbstractCommand implements ICommand, IFirstCommand {
    private ICommandExecutionBehavior myCommandExecutionBehavior;

    protected AbstractCommand (ICommandExecutionBehavior commandExecutionBehavior) {
        myCommandExecutionBehavior = commandExecutionBehavior;
    }

    /**
     * Executes the command
     */
    public double execute () {
        return myCommandExecutionBehavior.executeCommand();
    }

    /**
     * Sets the behavior for how the command will be executed
     * @param commandExecutionBehavior
     */
    protected void setCommandExecutionBehavior (ICommandExecutionBehavior commandExecutionBehavior) {
        myCommandExecutionBehavior = commandExecutionBehavior;
    }

    /**
     * Gets command arguments that make up this command
     * @return
     */
    public List<AbstractCommand> getCommandArguments () {
        return myCommandExecutionBehavior.getArguments();
    }

    /**
     * Gets the first inner command arguments, to see what they are
     */
    public List<ICommand> getInnerCommands () {
        List<ICommand> myInnerCommands = new ArrayList<ICommand>();
        myInnerCommands.addAll(myCommandExecutionBehavior.getArguments());
        return myInnerCommands;
    }

    @Override
    public String toString () {
        return this.getClass().getName().toUpperCase();
    }

}
