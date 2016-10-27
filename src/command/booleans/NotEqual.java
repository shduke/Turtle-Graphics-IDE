package command.booleans;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class NotEqual extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public NotEqual (List<AbstractCommand> inputs) {
        super(inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        return getCommandFromIndex(0).execute() != getCommandFromIndex(1).execute() ? 1 : 0;
    }
    
}
