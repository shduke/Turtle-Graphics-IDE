package node;

import command.AbstractCommand;
import command.CursorCommandFactory;
import cursor.Cursor;

public class CursorNode extends Node {

	private Cursor myCursor;
	
	public CursorNode(String type,Cursor turtle){
		super(type);
		myCursor=turtle;
	}
	
	public Cursor getTurtle(){
		return myCursor; 
	}
	
	public String toString(){
		return "CursorNode" +"{"+this.getType()+"}";
	}

    @Override
    public AbstractCommand createCommand() {
        CursorCommandFactory cmf = new CursorCommandFactory(myCursor);
        return cmf.createCommand(this);
    }
	
}
