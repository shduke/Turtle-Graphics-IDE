package command.cursor;


import behavior.unary.CursorBehavior;
import command.AbstractCommand;
import command.utility.Constant;

import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class PenUp extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 0;
    
    public PenUp (ICursor cursor, AbstractCommand... arguments) {
        super(new CursorBehavior(cursor.getPen()::setIsPenDown, new Constant(0.0)));
    }
    
}