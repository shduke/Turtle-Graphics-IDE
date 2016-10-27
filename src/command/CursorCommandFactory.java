package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class CursorCommandFactory extends CommandFactory {
    private Cursor myCursor;
    
    public CursorCommandFactory (Cursor cursor) {
        super();
        myCursor = cursor;
        addParameterTypes(Cursor.class);
        addArguments(myCursor);
    }  
    
}
