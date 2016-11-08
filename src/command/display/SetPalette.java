package command.display;

/**
 * @author Sean Hudson (srh50)
 */
import behavior.binary.ColorBehavior;
import command.AbstractCommand;
import cursor.ICursor;

public class SetPalette extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 4;
    
    public SetPalette (ICursor cursor, AbstractCommand... arguments) {
        super(new ColorBehavior(cursor::setPalette, arguments));

    }
    
}