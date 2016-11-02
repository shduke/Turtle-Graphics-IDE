package behavior.nonexpression;

import java.util.Map;
import behavior.AbstractCommandBehavior;
import command.utility.IVariable;


public class VariableExecutionBehavior extends AbstractCommandBehavior {
    private Map<String, IVariable> myVariableMap;
    private String myKey;

    public VariableExecutionBehavior (Map<String, IVariable> variableMap, String key) {
        super();
        myVariableMap = variableMap;
        myKey = key;
    }

    @Override
    public double executeCommand () {
        double lastResult = myVariableMap.get(myKey).execute();
        myVariableMap.get(myKey).setlastResult(lastResult);
        return lastResult;
    }

}
