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
public class Forward extends CursorCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Forward (List<AbstractCommand> inputs, Cursor cursor) {
        super(cursor, inputs);
        //addToInPutMap("distance", input[0])
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        double distance = getFirstCommand().execute();
        getCursor().setCoordinate(getCursor().getCoordinate().translate(distance, getCursor().getOrientation()));
        return distance;
    }
    
}
