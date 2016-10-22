package command.cursor;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.Variable;
import cursor.Cursor;

public class Forward extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Forward (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        double distance = getInputs().get(0).execute();
        getCursor().setCoordinate(getCursor().getCoordinate().translate(distance, getCursor().getOrientation()));
        return distance;
    }
    
}
