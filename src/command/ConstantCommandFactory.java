package command;

import java.util.ArrayList;
import java.util.List;
import command.utility.MultiLine;
import cursor.Cursor;
import node.Node;

public class ConstantCommandFactory extends CommandFactory {
    private double myValue;
    
    public ConstantCommandFactory (double value) {
        super();
        myValue = value;
        addParameterAndValues(myValue);
    }  
    
}
