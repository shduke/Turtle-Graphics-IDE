package command;

import java.util.HashMap;
import java.util.Queue;

public class DeclarationCommand extends AbstractCommand {
    HashMap<String, AbstractCommand> myCommandMap;
    
    DeclarationCommand(HashMap<String, AbstractCommand> commandMap) {
        myCommandMap = commandMap;
    }
    
    @Override
    double execute () {
        // TODO Auto-generated method stub
        return 0;
    }

}
