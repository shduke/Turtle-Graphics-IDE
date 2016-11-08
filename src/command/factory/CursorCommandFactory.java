package command.factory;

import cursor.ICursor;

/**
 * @author Sean Hudson (srh50)
 */
public class CursorCommandFactory extends CommandFactory {

    public CursorCommandFactory (ICursor cursor) {
        super();
        addClassAndValue(ICursor.class, cursor);

    }

}
