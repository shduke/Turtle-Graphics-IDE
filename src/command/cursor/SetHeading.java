package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.CursorCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;


public class SetHeading extends CursorCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;

    public SetHeading (List<AbstractCommand> inputs, Cursor cursor) {
        super(cursor, new MovementBehavior(cursor::setOrientation), inputs.get(0), new Constant(1.0));


    }

}
