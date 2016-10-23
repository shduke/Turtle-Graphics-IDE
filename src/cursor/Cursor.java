package cursor;

import java.util.ArrayList;
import java.util.List;

public class Cursor implements Drawable{
    private List<CreatedItem> myCreatedItems; //maybe create a drawableObject?
    private Coordinate myCoordinate;
    private double myOrientation;
    private Boolean myIsPenUp;
    private Boolean myIsVisible;
    private String myColor;
    //private String dog
    
    public Cursor() {
        myCreatedItems = new ArrayList<CreatedItem>();
        myOrientation = 90;
        myCoordinate = new Coordinate(0,0);
        myIsPenUp = false;
        myIsVisible = true;
        myColor = "Black";
    }

    public Coordinate getCoordinate () {
        return myCoordinate;
    }

    public double getOrientation() {
        return myOrientation;
    }
    
    public void setCoordinate (Coordinate coordinate) {
        createItem(coordinate);
        myCoordinate = coordinate;
        System.out.println(myCoordinate);
    }
    
    
    public void createItem(Coordinate nextCoordinate) {
        if(!myIsPenUp){
            myCreatedItems.add(new CreatedItem(myCoordinate, nextCoordinate));
        }
    }

    @Override
    public List<Coordinate> getCreateItems () {
        List<Coordinate> drawCoordinates = new ArrayList<Coordinate>();
        return drawCoordinates;
    }
    
}
