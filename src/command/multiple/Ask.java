package command.multiple;

import java.util.List;
import behavior.nonexpression.AskBehavior;
import behavior.nullary.DoubleQueryBehavior;
import behavior.unary.MovementBehavior;
import behavior.unary.MultiCursorUnaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.MultiLine;
import cursor.ICursor;

public class Ask extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    private static final int CURSORS_INDEX = 0;
    private static final int COMMANDS_INDEX = 1;
    
    public Ask (ICursor cursor, AbstractCommand... arguments) {
        super(new AskBehavior(new Tell(cursor, arguments[CURSORS_INDEX]), arguments[COMMANDS_INDEX], new Tell(cursor, new MultiLine(cursor.getActiveCursorConstants()))));
    }
    
}