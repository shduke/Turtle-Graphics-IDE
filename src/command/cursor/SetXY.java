package command.cursor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import behavior.binary.DoubleBinaryBehavior;
import command.AbstractCommand;
import command.utility.Constant;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.ICursor;

//TODO Maybe turn List<AbstractCommand> into an AbstractCommand...
public class SetXY extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 2;
    
    public SetXY (ICursor cursor, AbstractCommand... arguments) {
        super(new DoubleBinaryBehavior((a, b) -> cursor.applyToActive(c -> c.getCoordinate().setCoordinate(a, b)), arguments[0], arguments[1], new Constant(1.0)));
    }
    
    public SetXY(ICursor cursor, double x, double y) {
        this(cursor, new Constant(x), new Constant(y));
    }

  

}
