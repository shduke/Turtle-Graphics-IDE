package node;

import java.util.Map;
import command.AbstractCommand;
import command.factory.ParameterCommandFactory;
import command.utility.IVariable;
import command.utility.Variable;
import exception.SyntaxException;


public class ParameterNode extends Node {

    private Map<String, IVariable> myVariableMap;

    public ParameterNode (String type, Map<String, IVariable> variableMap) {
        super(type);
        myVariableMap = variableMap;
    }

    public Map<String, IVariable> getVariableMap () {
        return myVariableMap;
    }

    public String toString () {
        return "ParameterNode" + "{" + this.getType() + "}";
    }

    @Override
    public AbstractCommand createCommand (INode node)  throws SyntaxException {
    	try{
	        ParameterCommandFactory cmf = new ParameterCommandFactory(myVariableMap);
	        return cmf.createCommand(node);
    	}
    	catch(SyntaxException e){
    		throw e; 
    	}
    }

}
