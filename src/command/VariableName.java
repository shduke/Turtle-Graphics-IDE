package command;

import java.util.List;
import java.util.Map;

public class VariableName extends AbstractCommand {
    String myVariableName;

    VariableName (Map<String, Variable> variableMap, List<AbstractCommand> inputs, String variableName) {
        super(variableMap, inputs);
        myVariableName = variableName;
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String toString() {
        return myVariableName;
    }

}
