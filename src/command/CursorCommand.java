package command.cursor;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.utility.Variable;
import cursor.Cursor;


public abstract class CursorCommand extends AbstractCommand {
    Cursor myCursor;

    protected CursorCommand (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs);
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
