package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import command.AbstractCommand;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

//TODO - use more lambdas
public class SetXY extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public SetXY (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        Coordinate newCoordinate = new Coordinate(getCommandFromIndex(0).execute(), getCommandFromIndex(1).execute());
        double distance = getCursor().getCoordinate().calculateDistance(newCoordinate);
        getCursor().setCoordinate(newCoordinate);
        return distance;
    }
    
}
