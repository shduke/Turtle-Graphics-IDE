package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import command.utility.MultiLine;
import cursor.ICursor;
import node.Node;

public class CursorCommandFactory extends CommandFactory {
    private ICursor myCursor;
    
    public CursorCommandFactory (ICursor cursor) {
        super();
        myCursor = cursor;
        addClassAndValue(ICursor.class, cursor);

    }  
    
}
