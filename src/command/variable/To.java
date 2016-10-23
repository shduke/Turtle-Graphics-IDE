package command.variable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import command.AbstractCommand;
import command.ParameterCommand;
import command.utility.Variable;

public class To extends ParameterCommand{
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;
    HashMap<String, Variable> variableMap = new HashMap<String, Variable>();
    //variableMap.put(mlc1.toString(), mlc1) override tostring in MLC
    
    To(Map<String, Variable> variableMap, List<AbstractCommand> inputs) { //inputs[NameCommand, MultiLine, MultiLine ]
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
