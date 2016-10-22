package cursor;

import java.util.ArrayList;
import java.util.List;

public class Cursor {
    private List<CursorCreatedItem> myCreatedItems;
    private Coordinate myCoordinate;
    private double myOrientation;
    private Boolean myIsPenUp;
    private Boolean myIsVisible;
    private String myColor;
    
    Cursor(Coordinate coordinate) {
        myCreatedItems = new ArrayList<CursorCreatedItem>();
        myOrientation = 90;
        setCoordinate(coordinate);
        myIsPenUp = false;
        myIsVisible = true;
        myColor = "Black";
    }

    public Coordinate getCoordinate () {
        return myCoordinate;
    }

    public void setCoordinate (Coordinate myCoordinate) {
        this.myCoordinate = myCoordinate;
    }
}
