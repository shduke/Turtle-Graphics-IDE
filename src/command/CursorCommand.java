package command;

import java.util.List;
import java.util.Map;
import command.utility.Variable;
import cursor.Cursor;


public abstract class CursorCommand extends AbstractCommand {
    Cursor myCursor;

    protected CursorCommand (Cursor cursor, List<AbstractCommand> inputs) {
        super(inputs);
        myCursor = cursor;
    }
    
    public Cursor getCursor () {
        return myCursor;
    }
    
    public abstract double execute();

    public void setCursor (Cursor myCursor) {
        this.myCursor = myCursor;
    }

}
