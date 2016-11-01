package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import command.utility.IVariable;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Cursor;
import node.Node;


public class ParameterCommandFactory extends CommandFactory {
    
    private Map<String, IVariable> myVariableMap;

    public ParameterCommandFactory (Map<String, IVariable> variableMap) {
        super();
        myVariableMap = variableMap;
        addClassAndValue(Map.class, myVariableMap);
    }

}
