package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

//TODO - use more lambdas
public class HideTurtle extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public HideTurtle (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        getCursor().setIsVisible(false);
        return 0;
    }
    
}
