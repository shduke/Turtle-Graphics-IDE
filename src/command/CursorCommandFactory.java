package command;

import cursor.ICursor;


public class CursorCommandFactory extends CommandFactory {

    public CursorCommandFactory (ICursor cursor) {
        super();
        addClassAndValue(ICursor.class, cursor);

    }

}
