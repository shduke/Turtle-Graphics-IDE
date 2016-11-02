package cursor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Function;
import command.utility.Constant;
import java.util.Observer;
import java.util.Set;

public class Cursor implements IDrawable, Observer, ICursor{
    private static final double DEFAULT_LAYER = 20;
    private static final boolean DEFAULT_IS_VISIBLE = true;
    private static final double DEFAULT_SIZE = 10;
    private List<IDrawable> myCreatedItems; //maybe create a drawableObject?
    private double myId;
    private Coordinate myCoordinate;
    private Angle myOrientation;
    private Boolean myIsVisible;
    private Double myLayer;
    private Pen myPen;
    private boolean myIsActive;
    private double myShape;
    private double mySize;
    //private String dog
    
    public Cursor(double id) {
        myCreatedItems = new ArrayList<IDrawable>();
        myId = id;
        myCreatedItems.add(this); //TODO - better way to add this?
        myOrientation = new Angle();
        myCoordinate = new Coordinate();
        myIsVisible = true;
        myLayer = DEFAULT_LAYER;
        myPen = new Pen();
        myCoordinate.addObserver(this);
        setIsActive(DEFAULT_IS_VISIBLE);
        mySize = DEFAULT_SIZE;
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
    
    

    private void createItem(Coordinate previousCoordinate, Coordinate nextCoordinate) {
        if(myPen.getIsPenDown()){
            myCreatedItems.add(new CreatedItem(myPen.getPenColor(), myPen.getPenSize(), previousCoordinate, nextCoordinate));
        }
    }


    @Override
    public List<IDrawable> getDrawableItems () {
        return Collections.unmodifiableList(myCreatedItems);
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
        //System.out.print(myIsVisible);
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
        double[] coordinates = (double[])arg;
        createItem(new Coordinate(coordinates[0], coordinates[1]), new Coordinate(coordinates[2], coordinates[3]));
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


    @Override
    public List<ICoordinate> getDrawableCoordinates () {
        return Collections.unmodifiableList(Arrays.asList(myCoordinate));
    }


    @Override
    public double getColor () {
        return myShape;
    }


    @Override
    public double getSize () {
        return mySize;
    }


    @Override
    public <E> E applyToActive (Function<ICursor, E> mapping) {
        // TODO Auto-generated method stub
        return null;
    }



    
}
