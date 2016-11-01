package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.utility.IVariable;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Cursor;
import node.Node;


public class VariableCommandFactory extends CommandFactory {
    private String myVariableName;
    private Map<String, IVariable> myVariableMap;
    
    public VariableCommandFactory (Map<String, IVariable> variableMap, String variableName) {
        super();
        myVariableName = variableName;
        myVariableMap = variableMap;
        addClassAndValue(Map.class, variableMap);
        addParameterAndValues(variableName);
    }

    @Override
    protected int getNumberOfParameters (Class commandClass) throws NoSuchFieldException,
                                                             IllegalAccessException {
        int numberOfParameters = super.getNumberOfParameters(commandClass);
        //System.out.print(myVariableMap.get(myVariableName).getNumberOfParameters());
        return numberOfParameters != -1 ? numberOfParameters : myVariableMap.get(myVariableName).getNumberOfParameters();
    }

}
