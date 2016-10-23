package cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Cursor implements Drawable{
    private List<CreatedItem> myCreatedItems; //maybe create a drawableObject?
    private Coordinate myCoordinate;
    private double myOrientation;
    private Boolean isPenDown;
    private Boolean myIsVisible;
    private String myColor;
    //private String dog
    
    public Cursor() {
        myCreatedItems = new ArrayList<CreatedItem>();
        myOrientation = 90;
        myCoordinate = new Coordinate(0,0);
        isPenDown = false;
        myIsVisible = true;
        myColor = "Black";
    }

    public Coordinate getCoordinate () {
        return myCoordinate;
    }

    public double getOrientation() {
        return myOrientation;
    }
    
    public void setOrientation(double orientation) {
        myOrientation = orientation % 360; //TODO - check for negative values weird module vs remainder thing
    }
    
    public void setCoordinate (Coordinate coordinate) {
        createItem(coordinate);
        myCoordinate = coordinate;
        System.out.println(myCoordinate);
    }
    
    public void clearCreatedItems() {
        myCreatedItems.clear();
    }
    
    
    public void createItem(Coordinate nextCoordinate) {
        if(!isPenDown){
            myCreatedItems.add(new CreatedItem(myCoordinate, nextCoordinate));
        }
    }
    
    public void updateCoordinate(Consumer<Coordinate> func) {
        func.accept(myCoordinate);
    }

    @Override
    public List<Coordinate> getCreateItems () {
        List<Coordinate> drawCoordinates = new ArrayList<Coordinate>();
        return drawCoordinates;
    }

    public Boolean getIsPenDown () {
        return isPenDown;
    }

    public void setIsPenDown (Boolean myIsPenUp) {
        this.isPenDown = myIsPenUp;
    }

    public Boolean getIsVisible () {
        return myIsVisible;
    }

    public void setIsVisible (Boolean myIsVisible) {
        this.myIsVisible = myIsVisible;
    }
    
}
