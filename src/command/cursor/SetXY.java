package command.cursor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.CoordinateBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

//TODO - use more lambdas
public class SetXY extends CursorCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public SetXY (List<AbstractCommand> inputs, Cursor cursor) {
        super(cursor, new CoordinateBehavior(cursor.getCoordinate()::setCoordinate), inputs.get(0), inputs.get(1), new Constant(1.0));
    }
    
    public SetXY(double x, double y, Cursor cursor) {
//        AbstractCommand[] blah = new AbstractCommand[]{new Constant(x), new Constant(y)};
//        Arrays.asList(blah);
//        Arrays.asList(new AbstractCommand[]{new Constant(x), new Constant(y)});
        super(toList(new Constant(x), new Constant(y)), cursor)
    }

  

}
