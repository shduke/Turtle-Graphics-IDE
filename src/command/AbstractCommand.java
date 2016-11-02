package command;

import java.util.ArrayList;
import java.util.List;
import behavior.ICommandExecutionBehavior;


public abstract class AbstractCommand implements ICommand, IFirstCommand {
    private ICommandExecutionBehavior myCommandExecutionBehavior;

    protected AbstractCommand (ICommandExecutionBehavior commandExecutionBehavior) {
        myCommandExecutionBehavior = commandExecutionBehavior;
    }

    public double execute () {
        return myCommandExecutionBehavior.executeCommand();
    }

    protected void setCommandExecutionBehavior (ICommandExecutionBehavior commandExecutionBehavior) {
        myCommandExecutionBehavior = commandExecutionBehavior;
    }

    public List<AbstractCommand> getCommandArguments () {
        return myCommandExecutionBehavior.getArguments();
    }

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
