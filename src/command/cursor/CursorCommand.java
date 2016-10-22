package command;

import cursor.Cursor;


public abstract class CursorCommand extends AbstractCommand {
    Cursor myCursor;

    CursorCommand (Cursor cursor) {
        myCursor = cursor;
    }

    @Override
    abstract double execute ();

    public Cursor getCursor () {
        return myCursor;
    }

    public void setCursor (Cursor myCursor) {
        this.myCursor = myCursor;
    }

}
