package cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.function.Consumer;
import command.utility.Constant;
import java.util.Observer;
import java.util.Set;

public class Cursor implements Drawable, Observer, ICursor{
    private List<Drawable> myCreatedItems; //maybe create a drawableObject?
    private double myId;
    private Coordinate myCoordinate;
    private Angle myOrientation;
    private Boolean myIsVisible;
    private Double myLayer;
    private Pen myPen;
    private boolean myIsActive;
    //private String dog
    
    public Cursor(double id) {
        myCreatedItems = new ArrayList<Drawable>();
        myId = id;
        myCreatedItems.add(this); //TODO - better way to add this?
        myOrientation = new Angle(90);
        myCoordinate = new Coordinate(0,0);
        myIsVisible = true;
        myLayer = 10.0;
        myPen = new Pen();
        myCoordinate.addObserver(this);
        setIsActive(true);
    }


    @Override
    public Coordinate getCoordinate () {
        return myCoordinate;
    }


    @Override
    public double getOrientation() {
        return myOrientation.getAngle();
    }
    

    @Override
    public Angle getAngle() {
        return myOrientation;
    }
    

    @Override
    public double clearCreatedItems() {
        myCreatedItems.clear();
        return 0;
    }
    
    

    @Override
    public void createItem(Coordinate nextCoordinate) {
        if(myPen.getIsPenDown()){
            myCreatedItems.add(new CreatedItem(myCoordinate, nextCoordinate));
        }
    }


    @Override
    public List<ICoordinate> getCreateItems () {
        List<ICoordinate> drawCoordinates = new ArrayList<ICoordinate>();
        drawCoordinates.add(myCoordinate);
        return drawCoordinates;
    }


    @Override
    public double move(double distance) { //TODO - is this bad?
        return myCoordinate.translate(distance, myOrientation.getAngle());
    }


    @Override
    public boolean getIsVisible () {
        return myIsVisible;
    }


    @Override
    public boolean setIsVisible (Boolean isVisible) {
        myIsVisible = isVisible;
        System.out.print(myIsVisible);
        return isVisible;
    }
    

    @Override
    public Pen getPen() {
        return myPen;
    }


    @Override
    public double getLayer () {
        return myLayer;
    }


    @Override
    public void update (Observable o, Object arg) {
        createItem((Coordinate)arg);
        System.out.println("ID: " + myId + " items: " + myCreatedItems.size());
    }


    @Override
    public boolean getIsActive () {
        return myIsActive;
    }


    @Override
    public double setIsActive (boolean isActive) {
        myIsActive = isActive;
        return myId;
    }


    public double getId () {
        return myId;
    }


    @Override
    public double getNumberOfTurtles () {
        return 1;
    }


    @Override
    public double activateCursors (List<Double> turtles) {
        return 0;
    }


    @Override
    public Constant[] getActiveCursorConstants () {
        return null;
    }

    
}
