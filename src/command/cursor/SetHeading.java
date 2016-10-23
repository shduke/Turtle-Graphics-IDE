package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import command.AbstractCommand;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

//TODO - use more lambdas
public class SetHeading extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public SetHeading (Map<String, Variable> variableMap, List<AbstractCommand> inputs, Cursor cursor) {
        super(variableMap, inputs, cursor);
        // TODO Auto-generated constructor stub
    }

    @Override //TODO assume less than 360? of over 360 is it mod or absolute?
    public double execute() {
        double orientation = getFirstCommand().execute();
        double degreesMoved = (orientation % 360) - getCursor().getOrientation();
        getCursor().setOrientation(orientation);
        return degreesMoved;
    }
    
}
