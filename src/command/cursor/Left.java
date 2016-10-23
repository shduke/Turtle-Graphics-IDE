package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import command.AbstractCommand;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

//TODO - use more lambdas
public class Left extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Left (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        double degrees = getFirstCommand().execute();
        getCursor().setOrientation(getCursor().getOrientation() + degrees);
        return degrees;
    }
    
}
