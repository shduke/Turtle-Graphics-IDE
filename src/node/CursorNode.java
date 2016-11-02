package node;

import command.AbstractCommand;
import command.CursorCommandFactory;
import cursor.ICursor;
import exception.SyntaxException;

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
    public AbstractCommand createCommand(INode node) throws SyntaxException {
        try{
        	CursorCommandFactory cmf = new CursorCommandFactory(myCursor);
        	return cmf.createCommand(node);
        }
        catch(SyntaxException e){
        	throw e;
        }
    }
	
}
