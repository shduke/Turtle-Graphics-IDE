package cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Cursor implements Drawable{
    public List<Drawable> myCreatedItems; //maybe create a drawableObject?
    private Coordinate myCoordinate;
    private Angle myOrientation;
    private Boolean isPenDown;
    private Boolean myIsVisible;
    private String myColor;
    private Double myLayer;
    //private String dog
    
    public Cursor() {
        myCreatedItems = new ArrayList<Drawable>();
        myCreatedItems.add(this); //TODO - better way to add this?
        myOrientation = new Angle(90);
        myCoordinate = new Coordinate(0,0);
        isPenDown = false;
        myIsVisible = true;
        myColor = "Black";
        myLayer = 10.0;
    }

    public Coordinate getCoordinate () {
        return myCoordinate;
    }

    @Override
    public double getOrientation() {
        return myOrientation.getAngle();
    }
    
    public double setOrientation(double angle) {
        return myOrientation.setAngle(angle);
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
        drawCoordinates.add(myCoordinate);
        return drawCoordinates;
    }

    public double move(double distance) { //TODO - is this bad?
        myCoordinate.translate(distance, myOrientation.getAngle());
        System.out.println(myCoordinate);
        return distance;
    }
    
    public double rotate(double degrees) {
        myOrientation.rotate(degrees);
        return degrees;
    }
    
    public Boolean getIsPenDown () {
        return isPenDown;
    }

    public void setIsPenDown (Boolean myIsPenUp) {
        this.isPenDown = myIsPenUp;
    }

    public boolean getIsVisible () {
        return myIsVisible;
    }

    public void setIsVisible (Boolean myIsVisible) {
        this.myIsVisible = myIsVisible;
    }

    @Override
    public double getLayer () {
        return myLayer;
    }
    
}
