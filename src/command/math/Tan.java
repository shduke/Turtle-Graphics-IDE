package command.math;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.BooleanQueryBehavior;
import behavior.CursorBehavior;
import behavior.DegreesBehavior;
import behavior.DoubleQueryBehavior;
import behavior.DoubleUnaryBehavior;
import behavior.MovementBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Cursor;
import cursor.Coordinate;

public class Tan extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Tan (AbstractCommand... arguments) {
        super(new DegreesBehavior(Math::tan), arguments);
    }
    
}