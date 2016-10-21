package command;

import java.util.HashMap;
import java.util.Queue;

public class To extends DeclarationCommand{

    To(VariableName variableName, Queue<Variable> parameterNames, Queue<AbstractCommand> command, HashMap<String, AbstractCommand> commandMap) {
        super(commandMap);
    }
    
    private void createVariable() {
        
    }
}
