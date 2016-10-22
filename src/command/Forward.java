package command;

import cursor.Cursor;

public class Forward extends CursorCommand {

    Forward (Cursor cursor) {
        super(cursor);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute() {
        //getCursor().setCoordinate(getCursor().getCoordinate().translate(10, 10));
        return 0;
    }
    
}
