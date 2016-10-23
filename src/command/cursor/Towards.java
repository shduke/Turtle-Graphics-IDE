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
public class Towards extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Towards (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        double theta = (getCommandFromIndex(1).execute() - getCursor().getCoordinate().getY()) / (getCommandFromIndex(0).execute() - getCursor().getCoordinate().getX());
        getCursor().setOrientation(Math.atan(theta));
        return Math.toDegrees(theta);
    }
    
}
