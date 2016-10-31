package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.MultiBehavior;
import behavior.RunnableBehavior;
import behavior.binary.DoubleBinaryBehavior;
import behavior.nullary.DoubleNullaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class DeleteCreatedItems extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public DeleteCreatedItems (Cursor cursor, AbstractCommand... arguments) {
        this(cursor);
    }
    
    public DeleteCreatedItems(Cursor cursor) {
        super(new RunnableBehavior(cursor::clearCreatedItems));
    }

}
