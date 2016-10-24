package node;

import java.util.HashMap;

import command.AbstractCommand;
import command.CursorCommandFactory;
import command.OperationCommandFactory;
import command.utility.Variable;


public class OperationNode extends Node {
	
	private HashMap<String,Variable>myMap; //change to variable command

    public OperationNode (String type,HashMap<String,Variable>map) {
        super(type);
        myMap = map;
    }

    public String toString () {
        return "OperationNode" + "{" + this.getType() + "}";
    }

    @Override
    public AbstractCommand createCommand () {
        OperationCommandFactory cmf = new OperationCommandFactory();
        return cmf.createCommand(this);
    }
}
