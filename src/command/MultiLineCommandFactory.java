package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class MultiLineCommandFactory extends CommandFactory { 
    private static final String MULTILINE_TERMINATOR = "]";
    
    public MultiLineCommandFactory () {
        super();
    }

//    @Override
//    protected int getLimit(Node commandNode, Class commandClass) throws NoSuchFieldException, IllegalAccessException {
//        int count = 0;
//        while(commandNode.getType() != MULTILINE_TERMINATOR) {
//            count++;
//            commandNode = commandNode.getNext();
//        }
//        return count;
//    }
 
    @Override
    protected boolean getLoopCondition(Node commandNode, Class commandClass, int index) throws NoSuchFieldException, IllegalAccessException {
        return true;//!commandNode.getType().equals(MULTILINE_TERMINATOR);
    }
}
