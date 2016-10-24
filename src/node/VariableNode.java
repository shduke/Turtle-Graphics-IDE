package node;

import java.util.HashMap;
import command.AbstractCommand;
import command.ConstantCommandFactory;
import command.VariableCommandFactory;
import command.utility.Variable;

public class VariableNode extends Node {
	private String myName; //make this
	
	public VariableNode(String myName, String value, String name){
		super(myName);
		myName = name;
	}
	
	public String getName(){
		return myName;
	}
	
	public String toString(){
		return "VariableNode" +"{"+this.getType()+"}";
	}

    @Override
    public AbstractCommand createCommand () {
        VariableCommandFactory cmf = new VariableCommandFactory(myName);
        return cmf.createCommand(this);
    }
	
}
