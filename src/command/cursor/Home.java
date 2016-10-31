package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.MultiBehavior;
import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class Home extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public Home (Cursor cursor, AbstractCommand... arguments) {
        this(cursor);
    }
    
    public Home (Cursor cursor) {
        super(new MultiBehavior(new SetXY(cursor, 0.0, 0.0)));
    }

}
