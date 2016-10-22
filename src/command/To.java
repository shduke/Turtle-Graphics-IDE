package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class To extends ParameterCommand{
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;
    HashMap<String, Variable> variableMap = new HashMap<String, Variable>();
    
    To(Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
    }
    
    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }
    
    private void createVariable() {
        
    }
}
