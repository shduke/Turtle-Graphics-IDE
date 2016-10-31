package node;

import java.util.Map;
import command.AbstractCommand;
import command.ParameterCommandFactory;
import command.VariableCommandFactory;
import command.utility.Variable;


public class VariableNode extends Node {
    private Map<String, Variable> myVariableMap;
    private String myKey;

    public VariableNode (String type, String key, Map<String, Variable> variableMap) {
        super(type);
        myKey = key;
        myVariableMap = variableMap;
    }

    public String getKey () {
        return myKey;
    }

    public String toString () {
        return "VariableNode" + "{" + this.getType() + "}";
    }

    @Override
    public AbstractCommand createCommand (INode node) {
        VariableCommandFactory cmf = new VariableCommandFactory(myVariableMap, myKey);
        return cmf.createCommand(node);
    }

}
