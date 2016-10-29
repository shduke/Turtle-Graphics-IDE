package cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Cursor implements Drawable{
    public List<Drawable> myCreatedItems; //maybe create a drawableObject?
    private Coordinate myCoordinate;
    private Angle myOrientation;
    private Boolean myIsVisible;
    private Double myLayer;
    private Pen myPen;
    //private String dog
    
    public Cursor() {
        myCreatedItems = new ArrayList<Drawable>();
        myCreatedItems.add(this); //TODO - better way to add this?
        myOrientation = new Angle(90);
        myCoordinate = new Coordinate(0,0);
        myIsVisible = true;
        myLayer = 10.0;
        myPen = new Pen();
    }

    public Coordinate getCoordinate () {
        return myCoordinate;
    }

    @Override
    public double getOrientation() {
        return myOrientation.getAngle();
    }
    
    public Angle getAngle() {
        return myOrientation;
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
        if(!myPen.getIsPenDown()){
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
        return myCoordinate.translate(distance, myOrientation.getAngle());
    }

    public boolean getIsVisible () {
        return myIsVisible;
    }

    public boolean setIsVisible(double isVisible) {
        return setIsVisible(isVisible == 1 ? 1 : 0);
    }
    
    public boolean setIsVisible (Boolean isVisible) {
        myIsVisible = isVisible;
        return isVisible;
    }
    
    public Pen getPen() {
        return myPen;
    }

    @Override
    public double getLayer () {
        return myLayer;
    }
    
}
