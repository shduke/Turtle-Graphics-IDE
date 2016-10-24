package node;

import command.AbstractCommand;
import command.MultiLineCommandFactory;
import command.VariableCommandFactory;

public class BracketNode extends Node{
	
	public BracketNode(String type){
		super(type);
	}
	
	public String toString(){
		return "BracketNode" +"{"+this.getType()+"}";
	}

    @Override
    public AbstractCommand createCommand () {
        MultiLineCommandFactory cmf = new MultiLineCommandFactory();
        return cmf.createCommand(this);
    }
	
	
}
