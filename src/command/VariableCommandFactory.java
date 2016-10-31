package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Cursor;
import node.Node;

public class VariableCommandFactory extends CommandFactory {
    private String myVariableName;
    
    public VariableCommandFactory (Map<String, Variable> variableMap, String variableName) {
        super();
        myVariableName = variableName;
        addClassAndValue(Map.class, variableMap);
        addParameterAndValues(variableName);
    }
    
    
}