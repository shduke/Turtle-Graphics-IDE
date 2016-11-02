package command;

import java.util.Map;
import command.utility.IVariable;


public class ParameterCommandFactory extends CommandFactory {

    private Map<String, IVariable> myVariableMap;

    public ParameterCommandFactory (Map<String, IVariable> variableMap) {
        super();
        myVariableMap = variableMap;
        addClassAndValue(Map.class, myVariableMap);
    }

}
