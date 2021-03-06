package node;

import java.util.Map;
import command.AbstractCommand;
import command.factory.ParameterCommandFactory;
import command.factory.VariableCommandFactory;
import command.utility.IVariable;
import command.utility.Variable;
import exception.SyntaxException;


public class VariableNode extends Node {
    private Map<String, IVariable> myVariableMap;
    private String myKey;

    public VariableNode (String type, String key, Map<String, IVariable> variableMap) {
        super(type);
        myKey = key;
        myVariableMap = variableMap;
    }

    public String getKey () {
        return myKey;
    }

    public String toString () {
        return "VariableNode" + "{" + this.getType()+", "+myKey+" " + "}";
    }

    @Override
    public AbstractCommand createCommand (INode node) throws SyntaxException {
    	try{
	        VariableCommandFactory cmf = new VariableCommandFactory(myVariableMap, myKey);
	        return cmf.createCommand(node);
    	}
    	catch(SyntaxException e){
    		throw e; 
    	}
    }

}
