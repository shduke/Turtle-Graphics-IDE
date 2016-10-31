package node;

import java.util.Map;
import command.AbstractCommand;
import command.ParameterCommandFactory;
import command.utility.Variable;


public class ParameterNode extends Node {

    private Map<String, Variable> myVariableMap;

    public ParameterNode (String type, Map<String, Variable> variableMap) {
        super(type);
        myVariableMap = variableMap;
    }

    public Map<String, Variable> getVariableMap () {
        return myVariableMap;
    }

    public String toString () {
        return "ParameterNode" + "{" + this.getType() + "}";
    }

    @Override
    public AbstractCommand createCommand (INode node) {
        ParameterCommandFactory cmf = new ParameterCommandFactory(myVariableMap);
        return cmf.createCommand(node);
    }

}
