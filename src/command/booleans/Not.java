package command.booleans;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class Not extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Not (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        return getFirstCommand().execute() == 0 ? 1 : 0;
    }
    
}
