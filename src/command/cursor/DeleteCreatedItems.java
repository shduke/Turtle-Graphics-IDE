package command.cursor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.RunnableBehavior;
import behavior.binary.DoubleBinaryBehavior;
import behavior.nonexpression.MultiBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.ICursor;

public class DeleteCreatedItems extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public DeleteCreatedItems (ICursor cursor, AbstractCommand... arguments) {
        this(cursor);
    }
    
    public DeleteCreatedItems(ICursor cursor) {
        super(new RunnableBehavior(cursor::clearCreatedItems));
    }

}
