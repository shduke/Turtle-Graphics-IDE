package behavior.nonexpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import behavior.AbstractCommandBehavior;
import command.AbstractCommand;
import command.utility.IVariable;
import command.utility.Variable;

//TODO - account for 0 length multicommands (maybe a Max())
public class VariableExecutionBehavior extends AbstractCommandBehavior{
    private Map<String, IVariable> myVariableMap;
    private String myKey;
    
    public VariableExecutionBehavior(Map<String, IVariable> variableMap, String key) {
        super();
        myVariableMap = variableMap;
        myKey = key;
    }

    @Override
    public double executeCommand() {
        double blah  = myVariableMap.get(myKey).execute();
        return blah;
    }

}
