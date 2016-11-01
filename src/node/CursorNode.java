package node;

import command.AbstractCommand;
import command.CursorCommandFactory;
import cursor.ICursor;

public class CursorNode extends Node {

	private ICursor myCursor;
	
	public CursorNode(String type,ICursor turtle){
		super(type);
		myCursor=turtle;
	}
	
	public ICursor getTurtle(){
		return myCursor; 
	}
	
	public String toString(){
		return "CursorNode" +"{"+this.getType()+"}";
	}

    @Override
    public AbstractCommand createCommand(INode node) {
        CursorCommandFactory cmf = new CursorCommandFactory(myCursor);
        return cmf.createCommand(node);
    }
	
}
