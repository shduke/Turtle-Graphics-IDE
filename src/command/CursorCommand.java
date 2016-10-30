package command;

import java.util.List;
import java.util.Map;
import behavior.ICommandExecutionBehavior;
import command.utility.Variable;
import cursor.Cursor;


public abstract class CursorCommand extends AbstractCommand {
    Cursor myCursor;
    ICommandExecutionBehavior myCommandExecutionBehavior;

    protected CursorCommand (Cursor cursor, ICommandExecutionBehavior commandExecutionBehavior, AbstractCommand ... arguments) {
        super(arguments);
        myCursor = cursor;
        myCommandExecutionBehavior = commandExecutionBehavior;
        //setArgument(arguments);
    }
    
    public double execute() {
        return myCommandExecutionBehavior.executeCommand(executeCommands());
    }
    
    protected Cursor getCursor () {
        return myCursor;
    }

    public void setCursor (Cursor myCursor) {
        this.myCursor = myCursor;
    }

}
