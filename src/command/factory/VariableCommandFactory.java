package command.factory;

import java.util.Map;
import command.utility.IVariable;

/**
 * @author Sean Hudson (srh50)
 */
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
        return numberOfParameters != -1 ? numberOfParameters
                                        : myVariableMap.get(myVariableName).getNumberOfParameters();
    }

}
