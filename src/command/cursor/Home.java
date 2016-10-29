package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.CoordinateBehavior;
import behavior.MultiBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

//TODO - use more lambdas
public class Home extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public Home (List<AbstractCommand> inputs, Cursor cursor) {
        super(cursor, new MultiBehavior(), inputs.get(0), inputs.get(1), new Constant(1.0));


    }

}
