package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.binary.DoubleBinaryBehavior;
import behavior.nonexpression.MultiBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class ClearScreen extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public ClearScreen (Cursor cursor, AbstractCommand... arguments) {
        super(new MultiBehavior( new DeleteCreatedItems(cursor), new Home(cursor, arguments)));


    }

}
